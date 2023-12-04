public class Pokemon {
    private int pontosDeVida;
    private int armadura;
    private int ataque;
    
    /*Construtor para inicializar um pokemon */
    public Pokemon (int pontosDeVida, int armadura, int ataque) {
        this.pontosDeVida = pontosDeVida;
        this.armadura = armadura;
        this.ataque = ataque;
    }
    /*métodos getPontosDeVida(), getAtaque() e getArmadura() 
    que permitem obter os valores desses atributos de forma controlada, respeitando o encapsulamento.
     */
    public int getPontosDeVida () {
        return pontosDeVida;
    }

    public int getAtaque () {
        return ataque;
    }

    public int getArmadura () {
        return armadura;
    }
    /* permite modificar os pontos de vida do Pokémon. */
    public void setPontosDeVida(int pontosDeVida) {
        this.pontosDeVida = pontosDeVida;
    }

    public void somarPontosDeVida(int pontosDeVida) {
        this.pontosDeVida += pontosDeVida;
    }
    /*O metodo informar que a armadura sera usada */
    public void somarArmadura(int armadura) {
        this.armadura += armadura;
    }

    /*O metodo aumenta o nivel de ataque */
    public void somarAtaque(int ataque) {
        this.ataque += ataque;
    }
    /*O método atacar(Pokemon adversario) permite que um Pokémon ataque outro, 
    reduzindo os pontos de vida do adversário com base no valor do ataque do Pokémon atacante. */
    public boolean atacar(Pokemon adversario) {
        adversario.receberAtaque(ataque);
        return true;
    }
    /*O método receberAtaque(int dano) é chamado quando um Pokémon recebe um ataque, 
    reduzindo os pontos de vida com base no dano recebido e descontando a armadura. */
    public boolean receberAtaque(int dano) {
        dano -= armadura;
        pontosDeVida -= dano;
        return true;
    }

    /*O método estaVivo() retorna um booleano indicando se o Pokémon está vivo com base nos seus pontos de vida. */
    public boolean estaVivo () {
        return pontosDeVida > 0;
    }
}