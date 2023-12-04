import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GerarDiploma { //Kethlyn

    public static void gerarDiplomaVitoria(String nomeJogador, JFrame tela) {
        try (FileWriter arq = new FileWriter("ResultadoVitoria.txt");) {
            arq.write("Parabéns, " + nomeJogador + "!!! Voce venceu o jogo!!!!\n");            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(tela, "Falha ao gerar seu diploma :(", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void gerarDiplomaDerrota(String nomeJogador, JFrame tela) {
        try (FileWriter arq = new FileWriter("ResultadoDerrota.txt");) {
            arq.write("Voce morreu! Tente novamente, " + nomeJogador + "\n");

        } catch (IOException e) {
            JOptionPane.showMessageDialog(tela, "Falha ao gerar seu certificado de desonhra (>:o)", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}