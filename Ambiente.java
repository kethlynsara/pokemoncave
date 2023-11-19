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

    public Ambiente(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        saidas = new HashMap<String,Ambiente>();
    }

    public Ambiente(String nome, String descricao, Inimigo inimigo) {
        this(nome,descricao);
        this.pokemonSelvagem = inimigo;
    }

    public void ajustarSaidas(String direcao, Ambiente ambiente) {
        saidas.put(direcao, ambiente);
    }

    public Ambiente getSaida(String direcao) {
        return saidas.get(direcao);
    }

    //pega as chaves do hashmap e retorna em uma lista
     public List<String> listaSaidas() {
        Set<String> saidasDisponiveis = saidas.keySet();
        List<String> listaChaves = new ArrayList<>(saidasDisponiveis);
        return Collections.unmodifiableList(listaChaves);
    }

    public boolean temInimigo() {
        return pokemonSelvagem != null;
    }

    private String getDescricao(){
        return descricao;
    }

    public String descricaoCompleta() {
        if (temInimigo()) {
            return getDescricao() + "\n Oh nao, voce encontrou um " + pokemonSelvagem.getNome() + " Selvagem";
        } else {
            return getDescricao();
        }
    }

    public String getNome() {
        return nome;
    }

    public Inimigo adversario() {
        return pokemonSelvagem;
    }
}