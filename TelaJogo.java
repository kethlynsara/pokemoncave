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
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TelaJogo {
    private JFrame tela;
    private Jogo jogo;
    private JTextArea areaTexto;
    private String historicoTexto;
    private JPanel quadroCentral;
    private JPanel quadroEsquerdo;
    private JPanel quadroInferior;
    private JPanel quadroDireito;
    private JScrollPane scroll;
    private Jogador jogador;

    private PalavrasComando comandos;

    public TelaJogo (Jogador jogador) {
        jogo = new Jogo(jogador);
        iniciarTexto();
        comandos = new PalavrasComando();
        areaTexto = new JTextArea();
        scroll = new JScrollPane(areaTexto);
        this.jogador = jogador;
        montarTela();
    }

    

    private void iniciarTexto () {
        historicoTexto = "===== + + + ===== \n";
        historicoTexto += "Bem-vindo ao PokemonCave Game! \n";
        historicoTexto += "PokemonCave Game eh um jogo de explorassao, incrivelmente intrigante. \n";
        historicoTexto += "Digite 'ajuda' caso precise de algumas dicas. \n";
        historicoTexto += "===== + + + =====";
        historicoTexto += jogo.imprimeLocalAtual();
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

        //iniciaPainelEsquerdo();

        iniciaPainelInferior();
        
        iniciaPainelDireito();
    }

    private void iniciaPainelEsquerdo () {
        // Define componentes para colocar no painel para colocar na janela - Painel esquerdo
        quadroEsquerdo = new JPanel();
        quadroEsquerdo.setLayout((new FlowLayout()));

        quadroEsquerdo.add(new JLabel(new ImageIcon("img/pk.jpeg")));
        tela.add(quadroEsquerdo, BorderLayout.WEST);
    }

    private void iniciaPainelInferior () {
       quadroInferior = new JPanel();
       quadroInferior.setLayout(new FlowLayout());
       
       HashMap<String,JButton> botoesAcao = new HashMap<String,JButton>();

       for(String s : comandos.listaDeComandos() ) {
            botoesAcao.put(s, new JButton(s));
       }
        
       configurarBotoes(botoesAcao, quadroInferior);
        
        // criar botoes para substituir os comandos e realizar as chamadas em jogo

        tela.add(quadroInferior, BorderLayout.SOUTH);
    }

    // ******** IMCOMPLETO *********
    private void configurarBotoes (HashMap<String,JButton> botoes, JPanel quadroInferior) {
        // NAO FUNCIONA
        botoes.get("sair").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tela.dispose();
            }
        });
        // FUNCIONA POREM EXIBE NO TERMINAL
        botoes.get("observar").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                historicoTexto += jogo.observarAmbiente();
                if (!jogador.estaVivo()) {
                    Font fonteTexto = new Font("Arial", Font.BOLD, 50);
                    areaTexto.setFont(fonteTexto);
                    historicoTexto = " VOCE MORREU !!!!";
                    tela.dispose();
                }
                areaTexto.setText(historicoTexto);
            }
        });
        // FUNCIONA POREM EXIBE NO TERMINAL
        botoes.get("ajuda").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                historicoTexto += jogo.imprimirAjuda();
                areaTexto.setText(historicoTexto);
            }
        });
        // NAO IMPLEMENTADO
        botoes.get("ir").addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jogador.estaVivo()) {
                    try {
                        if (jogo.irParaAmbiente(JOptionPane.showInputDialog("Para qual direcao deseja ir?"))) {
                            JOptionPane.showMessageDialog(tela, "Seus pontos de vida foram restaurados!!!", "PARABENS !!!",JOptionPane.INFORMATION_MESSAGE);
                        }
                            historicoTexto += jogo.imprimeLocalAtual();
                            areaTexto.setText(historicoTexto);
                    } catch (Exception error) {
                        JOptionPane.showMessageDialog(tela, error.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(tela, "VOCE MORREU", "FIM", JOptionPane.ERROR_MESSAGE);
                    tela.dispose();
                }
            }
        });

        quadroInferior.add(botoes.get("ir"));
        quadroInferior.add(botoes.get("observar"));
        quadroInferior.add(botoes.get("ajuda"));
        quadroInferior.add(botoes.get("sair"));
        

<<<<<<< HEAD
    }

    private void iniciaPainelDireito () {
        quadroDireito = new JPanel();
        quadroDireito.setLayout(new BoxLayout(quadroDireito, BoxLayout.Y_AXIS));
=======
    } 

    private void iniciaPainelCentral () {
        JPanel quadroCentral = new JPanel(new FlowLayout());
        areaTexto = new JTextArea();
>>>>>>> 0cda9ad105cc78324280f97f7aae2ea4911eaee9
        Font fonteTexto = new Font("Candara", Font.BOLD, 16);
        areaTexto.setFont(fonteTexto);
        areaTexto.setText(historicoTexto);
        areaTexto.setEditable(false);
        quadroDireito.add(scroll);
        tela.add(quadroDireito,BorderLayout.EAST);
    }


}
