public class Inimigo extends Pokemon { // Luis Gustavo
/*a classe Inimigo é uma extensão da classe Pokemon com a adição de atributos específicos para inimigos (nome e item). Ela herda comportamentos gerais de Pokémon, 
mas também tem funcionalidades específicas relacionadas a inimigos, como soltar itens quando são derrotados. */
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