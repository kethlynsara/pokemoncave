import java.util.Scanner;
import java.util.Random;
public class Combate {
    private Scanner entrada;
    private Random random;

    public Combate (){
        entrada = new Scanner(System.in);
    }
    /**
     * Trata o combate num loop recebendo a decisao e
     * executando-a, alem de exibir e atualizar os 
     * status durante o combate
     */
    public boolean luta(Jogador desafiado, Inimigo desafiante) {
        String decisao;
        while(desafiado.estaVivo() && desafiante.estaVivo()) {
            decisao = decisaoLuta(desafiante.getNome());
            if(decisao.equals("atacar")) {
                atacar(desafiado, desafiante);
                System.out.println("=== Voce o acertou em cheio ===");
                atacar(desafiante, desafiado);
                System.out.println("=== Ele te acertou em cheio ===");
            } else if(decisao.equals("defender")) {
                defender(desafiado, desafiante);
            }            
            exibeStatus(desafiado,desafiante);
        }

        return desafiado.estaVivo();
    }
    /**
     * Exibe acoes disponiveis e retorna a decisao do jogador
     */
    private String decisaoLuta(String nomeDesafiante) {
        System.out.println(nomeDesafiante + " te ataca ferozmente, o que");
        System.out.println(" voce deseja fazer?");
        System.out.println("atacar");
        System.out.println("defender");

        return entrada.nextLine();
    }

    private void atacar (Pokemon atacado, Pokemon atacante) { // pokemon -> variavel polimorfica
        atacante.atacar(atacado);
    }
    /**
     * Gera um valor aleatorio entre 0 e 9, a divisao por 9
     * com resto 0 indica defesa falha, recebendo dano por recuo,
     * no caso da defesa bem sucedida nao recebe dano
     * e o atacante recebe o dano por recuo
     */
    private void defender (Jogador jogador, Inimigo inimigo) {
        this.random = new Random();
        int chance = random.nextInt(10);
        System.out.println("=== Voce bloqueou o ataque do adversario !!! ===");

        if (chance % 9 == 0) { // de 0 a 9 a chance é de 2/10 ou 1/5 logo 20% chance de falha na defesa
            System.out.println("Porem ele golpeou com muita força!!!");
            System.out.println("E voce recua com o impacto ...");
            jogador.receberAtaque(5);
        } else {
            System.out.println("Ele recua atordoado ...");
            inimigo.receberAtaque(5);
        }
    }
    /**
     * Exibe os pontos de vida do inimigo e do jogador na luta
     * em tempo real para auxiliar na tomada de decisao
    */
    private void exibeStatus (Jogador jogador, Inimigo inimigo) {
        System.out.println("===== +++ =====");
        System.out.println("Seus pontos de Vida => " + jogador.getPontosDeVida());
        System.out.println("Pontos de vida de " + inimigo.getNome() + " => " + inimigo.getPontosDeVida());
        System.out.println("===== +++ =====");
    }
}