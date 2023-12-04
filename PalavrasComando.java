import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PalavrasComando { // Luis Gustavo && Kethlyn
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

    /*
     * O método listaDeComandos retorna uma lista imutável (usando
     * Collections.unmodifiableList) contendo os comandos válidos. Isso é feito para
     * garantir que a lista original não possa ser modificada fora da classe.
     */
    public List<String> listaDeComandos() {
        return Collections.unmodifiableList(comandosValidos);
    }

    /*
     * O método ehComando recebe uma string como parâmetro e verifica se essa string
     * está presente na lista de comandos válidos. Retorna true se a string for um
     * comando válido e false caso contrário.
     */
    public boolean ehComando(String umaString) {
        // Verifica se contem o comando.
        return comandosValidos.contains(umaString);
    }
}