/* a classe ItemCura é uma especialização da classe Item, 
representando um item específico de cura ("Oran berry"). 
Ao coletar este item, o jogador ganha 10 pontos de vida,
 e uma mensagem informativa é gerada para indicar a coleta bem-sucedida e
  mostrar o estado atual dos pontos de vida do jogador. */

public class ItemCura extends Item {
    /*
     * O construtor da classe ItemCura chama o construtor da classe base (Item)
     * usando super e passa o nome "Oran berry" como parâmetro. Isso associa
     * automaticamente o nome ao item quando uma instância de ItemCura é criada.
     */
    public ItemCura() {
        super("Oran berry");
    }

    /*
     * A classe ItemCura substitui o método coletar da interface Coletavel. Ao
     * coletar um ItemCura, o jogador recebe um aumento de 10 pontos de vida
     * (jogador.somarPontosDeVida(10)).
     * O método também chama o método coletar da classe base
     * (super.coletar(jogador)), que é o método definido na classe Item. Isso pode
     * ser útil se houver lógica adicional na implementação do método coletar da
     * classe Item.
     * A mensagem informativa é construída, informando ao jogador que ele ganhou 10
     * pontos de vida, mostrando os pontos de vida atuais do jogador e adicionando
     * uma mensagem adicional.
     * A mensagem construída é então retornada.
     */
    public String coletar(Jogador jogador) {
        String msgColeta;
        jogador.somarPontosDeVida(10);
        super.coletar(jogador);
        msgColeta = "\nVoce ganhou 10 pontos de vida !!! \n";
        msgColeta += "Voce tem " + jogador.getPontosDeVida() + " Pontos de vida atualmente \n";
        msgColeta += "===== +++ ===== \n";

        return msgColeta;
    }
}