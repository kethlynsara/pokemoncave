/*a classe Jogador é uma especialização da classe Pokemon para representar um jogador
 */

public class Jogador extends Pokemon {
    private int vidaMaxima;

    /*
     * O construtor da classe Jogador chama o construtor da classe base (Pokemon)
     * usando super e inicializa os atributos pontosDeVida, armadura e ataque com os
     * valores fornecidos. Além disso, ele inicializa o atributo adicional
     * vidaMaxima com o valor de pontosDeVida.
     */
    public Jogador(int pontosDeVida, int armadura, int ataque) {
        super(pontosDeVida, armadura, ataque);
        vidaMaxima = pontosDeVida;
    }

    /*
     * Este método é uma sobreposição do método correspondente da classe base
     * (super.somarPontosDeVida(pontosDeVida)). Além de somar os pontos de vida,
     * verifica se os pontos de vida atuais excedem a vidaMaxima e, se sim, define
     * os pontos de vida para o valor máximo (setPontosDeVida(vidaMaxima)).
     */
    public void somarPontosDeVida(int pontosDeVida) {
        super.somarPontosDeVida(pontosDeVida);
        if (getPontosDeVida() > vidaMaxima)
            setPontosDeVida(vidaMaxima);
    }

    /* */
    public void somarArmadura(int armadura) {
        super.somarArmadura(armadura);
    }

    public void somarAtaque(int ataque) {
        super.somarAtaque(ataque);
    }
}
