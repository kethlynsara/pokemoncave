public class Jogador extends Pokemon {
    private int vidaMaxima;
    public Jogador(int pontosDeVida, int armadura, int ataque) {
        super(pontosDeVida, armadura, ataque);
        vidaMaxima = pontosDeVida;
    }

    public void somarPontosDeVida(int pontosDeVida) {
       super.somarPontosDeVida(pontosDeVida);
       if (getPontosDeVida() > vidaMaxima) setPontosDeVida(vidaMaxima);
    }
              
    public void somarArmadura(int armadura) {
        super.somarArmadura(armadura);
    }

    public void somarAtaque(int ataque) {
        super.somarAtaque(ataque);
    }
}
