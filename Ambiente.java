import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Ambiente {

    private String descricao;
    private String nome;
    private Inimigo pokemonSelvagem;
    private HashMap<String,Ambiente> saidas;

    //Recebe e inicializa o nome e a descricao do ambiente
    public Ambiente(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        saidas = new HashMap<String,Ambiente>();
    }

    //Chama o outro construtor e coloca o inimigo informado no ambiente
    public Ambiente(String nome, String descricao, Inimigo inimigo) {
        this(nome,descricao);
        this.pokemonSelvagem = inimigo;
    }

    //Recebe uma direcao e o ambiente correspondente a
    //ela em relacao a este ambiente
    public void ajustarSaidas(String direcao, Ambiente ambiente) {
        saidas.put(direcao, ambiente);
    }

    //Retorna o ambiente correspondente a saida informada
    //em relacao a este ambiente
    public Ambiente getSaida(String direcao) {
        return saidas.get(direcao);
    }

    //Pega as chaves do hashmap e retorna uma lista
    //com as saidas disponiveis do ambiente
     public List<String> listaSaidas() {
        Set<String> saidasDisponiveis = saidas.keySet();
        List<String> listaChaves = new ArrayList<>(saidasDisponiveis);
        return Collections.unmodifiableList(listaChaves);
    }

    //Verifica se tem inimigo
    public boolean temInimigo() {
        return pokemonSelvagem != null;
    }

    //Retorna a descricao e informa caso tenha um inimigo
    public String descricaoCompleta() {
        if (temInimigo()) {
            return descricao + "\n Oh nao, voce encontrou um " + pokemonSelvagem.getNome() + " Selvagem";
        } else {
            return descricao;
        }
    }


    public String getNome() {
        return nome;
    }

    public Inimigo adversario() {
        return pokemonSelvagem;
    }

    //É chamado ao vencer uma luta para eliminar o
    //pokemon que se encontrava no ambiente
    public void eliminaPokemon() {
        pokemonSelvagem = null;
    }
}