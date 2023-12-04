public class ItemAtaque extends Item { //Kethlyn

/**
 * classe chamada ItemAtaque, que estende a classe Item.
 */
    /*
     * O construtor da classe ItemAtaque chama o construtor da classe base (Item)
     * usando super e passa o nome "Liechi berry" como parâmetro.
     * Portanto, quando um ItemAtaque é criado, ele é automaticamente associado a
     * esse nome.
     */
    public ItemAtaque() {
        super("Liechi berry");
    }

    /*
     * A classe ItemAtaque substitui o método coletar da interface Coletavel.
     * Ao coletar um ItemAtaque, o jogador recebe um aumento de 3 pontos de ataque
     * (jogador.somarAtaque(3)).
     * Além disso, o método chama o método coletar da classe base
     * (super.coletar(jogador)),
     * que é o método definido na classe Item.
     * O método constrói uma mensagem informativa sobre a coleta,
     * informando ao jogador que ele ganhou 3 pontos de ataque,
     * mostrando o ataque atual do jogador e adicionando uma mensagem adicional.
     * A mensagem construída é então retornada
     */
    public String coletar(Jogador jogador) {
        String msgColeta;
        jogador.somarAtaque(3);
        super.coletar(jogador);
        msgColeta = "\n Voce ganhou 3 pontos de ataque !!! \n";
        msgColeta += "Voce tem " + jogador.getAtaque() + " Pontos de ataque atualmente \n";
        msgColeta += "===== +++ =====\n";

        return msgColeta;
    }
}