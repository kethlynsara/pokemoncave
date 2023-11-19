public class Inimigo extends Pokemon {
    private String nome;
    private Item item;

    public Inimigo (String nome, int pontosDeVida, int armadura, int ataque, Item item) {
        super(pontosDeVida, armadura, ataque);
        this.nome =  nome;
        this.item = item;
    }

    public String getNome () {
        return nome;
    }

    public Item soltarItem () {
        return item;
    }
}