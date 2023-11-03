import java.util.*;

public class Ambiente {

    private String descricao;
    private HashMap<String,Ambiente> saidas;

    public Ambiente(String descricao) {
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
}