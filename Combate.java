
import java.util.Random;
public class Combate { // Luis Gustavo && Kethlyn Sara
    private Random random;

    /**
     * Exibe texto para informar açao
     */
    public String iniciarLuta(String nomeDesafiante) {
        return nomeDesafiante + " te ataca ferozmente, o que voce deseja fazer? \n";
    }

    public String segueLuta(String nomeDesafiante) {
        return nomeDesafiante + " permanece firme, o que voce fazer?\n";
    }
    
    public void atacar (Pokemon atacado, Pokemon atacante) { // pokemon -> variavel polimorfica
        atacante.atacar(atacado);
    }

    /**
     * Gera um valor aleatorio entre 0 e 9, a divisao por 9
     * com resto 0 indica defesa falha, recebendo dano por recuo,
     * no caso da defesa bem sucedida nao recebe dano
     * e o atacante recebe o dano por recuo
     */
    public String defender (Jogador jogador, Inimigo inimigo) {
        this.random = new Random();
        int chance = random.nextInt(10);
        String descricaoAcontecimento = "=== Voce bloqueou o ataque do adversario !!! === \n";

        if (chance % 9 == 0) { // de 0 a 9 a chance é de 2/10 ou 1/5 logo 20% chance de falha na defesa
            jogador.receberAtaque(5);
            descricaoAcontecimento += "Porem ele golpeou com muita força!!! \n E voce recuou com o impacto ... \n";
            return descricaoAcontecimento;
        } else {
            inimigo.receberAtaque(5);
            descricaoAcontecimento += "Ele recua atordoado ...\n";
            return descricaoAcontecimento;         
        }
    }

    /**
     * Exibe os pontos de vida do inimigo e do jogador na luta
     * em tempo real para auxiliar na tomada de decisao
    */
    public String exibeStatus (Jogador jogador, Inimigo inimigo) {
        String status = "===== +++ =====";
        status += "\n Seus pontos de Vida " +  jogador.getPontosDeVida();
        status += "\n Pontos de vida de " + inimigo.getNome() + " => " + inimigo.getPontosDeVida();
        status += "\n ===== +++ ===== \n";
        return status;
    }
}