public class ItemCura extends Item {

    public ItemCura(String nome) {
        super(nome);
    }

    public void coletar(Jogador jogador) {
        jogador.setPontosDeVida(10);
        super.coletar(jogador);
        System.out.println(" Voce ganhou 10 pontos de vida !!!");
        System.out.println("Voce tem " + jogador.getPontosDeVida() + " Pontos de vida atualmente");
        System.out.println("===== +++ =====");
    }
}