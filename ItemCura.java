public class ItemCura extends Item implements Coletavel {

    public ItemCura(String nome) {
        super(nome);
    }

    public void coletar(Jogador jogador) {
        jogador.setPontosDeVida(10);
        System.out.println("===== +++ =====");
        System.out.println("É uma Berry " + nome + " Voce ganhou 10 pontos de vida !!!");
        System.out.println("Voce tem " + jogador.getPontosDeVida() + " Pontos de vida atualmente");
        System.out.println("===== +++ =====");
    }
}