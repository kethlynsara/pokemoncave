import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class TelaJogo {
    private JFrame tela;
    private JTextArea areaTexto;

    public TelaJogo () {

        montarTela();
    }

    private void montarTela () {
        tela = new JFrame("Pokemon Cave");

        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        iniciarComponentes();
        
        //montarJanela();
    }

    private void iniciarComponentes () {
        areaTexto = new JTextArea();
        Font fonteTexto = new Font("Candara", Font.BOLD, 16);
        areaTexto.setFont(fonteTexto);
    }


}
