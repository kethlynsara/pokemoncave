import java.util.HashMap;

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

    public String getDescricao(){
        return descricao;
    }
}