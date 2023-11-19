public class ItemAtaque extends Item implements Coletavel {

    public ItemAtaque(String nome) {
        super(nome);
    }

    public void coletar(Jogador jogador) {
        jogador.setAtaque(3);
        System.out.println("===== +++ =====");
        System.out.println("É uma Berry " + nome + " Voce ganhou 3 pontos de ataque !!!");
        System.out.println("Voce tem " + jogador.getAtaque() + " Pontos de ataque atualmente");
        System.out.println("===== +++ =====");
    }
}