public class ItemDefesa extends Item { //Kethlyn
    /*
     * construtor da classe ItemDefesa chama o construtor da classe base (Item)
     * usando super e passa o nome "Apricot berry" como parâmetro. Isso associa
     * automaticamente o nome ao item quando uma instância de ItemDefesa é criada.
     */
    public ItemDefesa() {
        super("Apricot berry");
    }

    /*
     * A classe ItemDefesa substitui o método coletar da interface Coletavel. Ao
     * coletar um ItemDefesa, o jogador recebe um aumento de 3 pontos de armadura
     * (jogador.somarArmadura(3)).
     * O método também chama o método coletar da classe base
     * (super.coletar(jogador)), que é o método definido na classe Item. Isso pode
     * ser útil se houver lógica adicional na implementação do método coletar da
     * classe Item.
     * A mensagem informativa é construída, informando ao jogador que ele ganhou 3
     * pontos de defesa, mostrando os pontos de armadura atuais do jogador e
     * adicionando uma mensagem adicional.
     * A mensagem construída é então retornada.
     */
    public String coletar(Jogador jogador) {
        String msgColeta;
        jogador.somarArmadura(3);
        super.coletar(jogador);
        msgColeta = "\n Voce ganhou 3 pontos de defesa !!! \n";
        msgColeta += "Voce tem " + jogador.getArmadura() + " Pontos de armadura atualmente \n";
        msgColeta += "===== +++ =====  \n";

        return msgColeta;
    }
}