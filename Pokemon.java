public class Pokemon {
    private int pontosDeVida;
    private int armadura;
    private int ataque;
    
    public Pokemon (int pontosDeVida, int armadura, int ataque) {
        this.pontosDeVida = pontosDeVida;
        this.armadura = armadura;
        this.ataque = ataque;
    }

    public int getPontosDeVida () {
        return pontosDeVida;
    }

    public int getAtaque () {
        return ataque;
    }

    public int getArmadura () {
        return armadura;
    }

    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public void somarPontosDeVida(int pontosDeVida) {
        this.pontosDeVida += pontosDeVida;
    }

    public void somarArmadura(int armadura) {
        this.armadura += armadura;
    }

    public void somarAtaque(int ataque) {
        this.ataque += ataque;
    }

    public boolean atacar(Pokemon adversario) {
        adversario.receberAtaque(ataque);
        return true;
    }
    
    public boolean receberAtaque(int dano) {
        dano -= armadura;
        pontosDeVida -= dano;
        return true;
    }

    public boolean estaVivo () {
        return pontosDeVida > 0;
    }
}