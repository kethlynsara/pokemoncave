import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class Ambiente {

    private String descricao;
    private String nome;
    private HashMap<String,Ambiente> saidas;

    public Ambiente(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
        saidas = new HashMap<String,Ambiente>();
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

    public String getDescricao(){
        return descricao;
    }

    public String getNome() {
        return nome;
    }
}