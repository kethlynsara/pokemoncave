import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class TelaJogo {
    private JFrame tela;
    private Jogo jogo;
    private JTextArea areaTexto;

    public TelaJogo () {
        jogo = new Jogo();
        montarTela();
    }

    private void montarTela () {

        // Cria janela define tamanho e layout
        tela = new JFrame("Pokemon Cave"); 
        tela.setSize(500, 600);
        tela.setLayout(new BorderLayout());

        iniciarComponentes();

        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
        

    }

    private void iniciarComponentes () {

        iniciaPainelEsquerdo();

        iniciaPainelInferior();
        
    }

    private void iniciaPainelEsquerdo () {
        // Define componentes para colocar no painel para colocar na janela - Painel esquerdo
        JPanel quadroEsquerdo = new JPanel(new FlowLayout());
        quadroEsquerdo.add(new JLabel(new ImageIcon("img/pk.jpeg")));
        tela.add(quadroEsquerdo, BorderLayout.WEST);
    }

    private void iniciaPainelInferior () {
        JPanel quadroInferior = new JPanel(new FlowLayout());
        areaTexto = new JTextArea();
        Font fonteTexto = new Font("Candara", Font.BOLD, 16);
        areaTexto.setFont(fonteTexto);
        areaTexto.setText(jogo.imprimirBoasVindas());
        areaTexto.setEditable(false);
        quadroInferior.add(areaTexto);
        
        // criar botoes para substituir os comandos e realizar as chamadas em jogo

        tela.add(quadroInferior, BorderLayout.SOUTH);
    }


}
