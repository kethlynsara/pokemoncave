import java.util.Scanner;
import java.util.Random;
public class Combate {
    private Scanner entrada;
    private Random random;

    public Combate (){
        entrada = new Scanner(System.in);
    }

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

    private void defender (Jogador jogador, Inimigo inimigo) {
        this.random = new Random();
        int chance = random.nextInt(11);
        System.out.println("=== Voce bloqueou o ataque do adversario !!! ===");

        if (chance % 2 == 0) {
            System.out.println("Ele recua atordoado ...");
            inimigo.receberAtaque(5);
        } else {
            System.out.println("Porem ele golpeou com muita força!!!");
            System.out.println(" Voce recua com o impacto ...");
            jogador.receberAtaque(5);
        }
    }

    private void exibeStatus (Jogador jogador, Inimigo inimigo) {
        System.out.println("===== +++ =====");
        System.out.println("Seus pontos de Vida => " + jogador.getPontosDeVida());
        System.out.println("Pontos de vida de " + inimigo.getNome() + " => " + inimigo.getPontosDeVida());
        System.out.println("===== +++ =====");
    }
}