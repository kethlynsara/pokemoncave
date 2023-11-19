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
    }

    public List<String> listaDeComandos() {
        return Collections.unmodifiableList(comandosValidos);
    }

    public boolean ehComando(String umaString){
        // Verifica se contem o comando.
        return comandosValidos.contains(umaString);
    }
}