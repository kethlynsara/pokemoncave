import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class TelaJogo {
    private JFrame tela;
    private Jogo jogo;
    private JTextArea areaTexto;

    private PalavrasComando comandos;

    public TelaJogo () {
        jogo = new Jogo();
        comandos = new PalavrasComando();
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
        
        iniciaPainelCentral();
    }

    private void iniciaPainelEsquerdo () {
        // Define componentes para colocar no painel para colocar na janela - Painel esquerdo
        JPanel quadroEsquerdo = new JPanel(new FlowLayout());
        quadroEsquerdo.add(new JLabel(new ImageIcon("img/pk.jpeg")));
        tela.add(quadroEsquerdo, BorderLayout.WEST);
    }

    private void iniciaPainelInferior () {
       JPanel quadroInferior = new JPanel(new FlowLayout());
       
       HashMap<String,JButton> botoesAcao = new HashMap<String,JButton>();

       for(String s : comandos.listaDeComandos() ) {
            botoesAcao.put(s, new JButton(s));
       }
        
       configurarBotoes(botoesAcao, quadroInferior);
        
        // criar botoes para substituir os comandos e realizar as chamadas em jogo

        tela.add(quadroInferior, BorderLayout.SOUTH);
    }

    private void configurarBotoes (HashMap<String,JButton> botoes, JPanel quadroInferior) {
        // NAO FUNCIONA
        botoes.get("sair").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogo.sair(new Comando("sair", null));
            }
        });
        // FUNCIONA POREM EXIBE NO TERMINAL
        botoes.get("observar").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogo.observarAmbiente();
            }
        });
        // FUNCIONA POREM EXIBE NO TERMINAL
        botoes.get("ajuda").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogo.imprimirAjuda();
            }
        });
        // NAO IMPLEMENTADO
        botoes.get("ir").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //jogo.imprimirAjuda();
            }
        });

        quadroInferior.add(botoes.get("sair"));
        quadroInferior.add(botoes.get("observar"));
        quadroInferior.add(botoes.get("ajuda"));
        quadroInferior.add(botoes.get("ir"));

    }

    private void iniciaPainelCentral () {
        JPanel quadroCentral = new JPanel(new FlowLayout());
        areaTexto = new JTextArea();
        Font fonteTexto = new Font("Candara", Font.BOLD, 16);
        areaTexto.setFont(fonteTexto);
        areaTexto.setText(jogo.imprimirBoasVindas());
        areaTexto.setEditable(false);
        quadroCentral.add(areaTexto);
        tela.add(quadroCentral,BorderLayout.CENTER);
    }


}
