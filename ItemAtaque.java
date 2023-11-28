public class ItemAtaque extends Item {

    public ItemAtaque() {
        super("Liechi berry");
    }

    public void coletar(Jogador jogador) {
        jogador.setAtaque(3);
        super.coletar(jogador);
        System.out.println(" Voce ganhou 3 pontos de ataque !!!");
        System.out.println("Voce tem " + jogador.getAtaque() + " Pontos de ataque atualmente");
        System.out.println("===== +++ =====");
    }
}