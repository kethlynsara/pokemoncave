import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalavrasComando {
    private static ArrayList<String> comandosValidos;

    /**
     * Construtor - inicializa as palavras de comando.
     */
    public PalavrasComando() {
        comandosValidos = new ArrayList<String>();
        comandosValidos.add("ir");
        comandosValidos.add("sair");
        comandosValidos.add("ajuda");
        comandosValidos.add("observar");
        comandosValidos.add("agir");
    }

    public List<String> listaDeComandos() {
        return Collections.unmodifiableList(comandosValidos);
    }

    public boolean ehComando(String umaString){
        for(int i = 0; i < comandosValidos.size(); i++) {            
            if(comandosValidos.get(i).equals(umaString))
                return true;
        }
        // se chegamos aqui, a string nao foi encontrada nos comandos.
        return false;
    }
}
