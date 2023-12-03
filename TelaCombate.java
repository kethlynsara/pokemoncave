import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.util.HashMap;

public class TelaCombate {
    private JFrame tela;
    private Combate combate;
    private JTextArea descricaoLuta;
    private String listaAcoes;
    private JPanel campoCombate; // centro
    private JPanel campoAcao; // Inferior
    private JScrollPane scroll;
    private Inimigo inimigo;
    private Jogador jogador;
    private static boolean resultado;

    public TelaCombate (Inimigo inimigo, Jogador jogador) {
        resultado = true;
        combate = new Combate();        
        listaAcoes = combate.iniciarLuta(inimigo.getNome());
        descricaoLuta = new JTextArea();
        scroll = new JScrollPane(descricaoLuta);
        this.inimigo = inimigo;
        this.jogador = jogador;
        montarJanela();
    }

    public static boolean lutar(Inimigo inimigo, Jogador jogador) {
        new TelaCombate(inimigo,jogador);
        return resultado;
    }

    private void montarJanela() {
        tela = new JFrame("Combate");    
        tela.setSize(300, 400);
        tela.setLayout(new BorderLayout());

        prepararInterface();

        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setVisible(true);
    }

    private void prepararInterface() {
        montarCampoAcao();
        montarCampoCombate();
    }

    private void montarCampoAcao() {
        campoAcao = new JPanel();
        campoAcao.setLayout(new BoxLayout(campoAcao, BoxLayout.X_AXIS));

        JButton botaoAtaque = new JButton("Atacar");
        JButton botaoDefesa = new JButton("Defender");

        botaoAtaque.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                combate.atacar(inimigo, jogador);
                listaAcoes += "=== X Voce o atacou em cheio X === \n";
                combate.atacar(jogador,inimigo);
                listaAcoes += "\n === x Voce foi atacado X === \n";
                listaAcoes += combate.segueLuta(inimigo.getNome());
                listaAcoes += combate.exibeStatus(jogador,inimigo);
                descricaoLuta.setText(listaAcoes);
                if (!jogador.estaVivo()){
                    resultado = false;
                    tela.dispose();
                }
                if (!inimigo.estaVivo()) {
                    tela.dispose();
                }
            }
        });

        botaoDefesa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listaAcoes += combate.defender(jogador,inimigo);
                listaAcoes += combate.exibeStatus(jogador,inimigo);
                descricaoLuta.setText(listaAcoes);
            }
        });

        campoAcao.add(botaoAtaque);
        campoAcao.add(botaoDefesa);
        
        tela.add(campoAcao,BorderLayout.SOUTH);
    }

    private void montarCampoCombate () {
        campoCombate = new JPanel();
        campoCombate.setLayout(new BoxLayout(campoCombate, BoxLayout.Y_AXIS));

        Font fonteTexto = new Font("Times New Roman", Font.BOLD, 20);
        descricaoLuta.setFont(fonteTexto);
        descricaoLuta.setText(listaAcoes);
        descricaoLuta.setEditable(false);

        campoCombate.add(scroll);
        
        tela.add(campoCombate,BorderLayout.CENTER);
    }
}