public class ItemDefesa extends Item {

    public ItemDefesa() {
        super("Apricot berry");
    }

    public void coletar(Jogador jogador) {
        jogador.setArmadura(3);
        super.coletar(jogador);
        System.out.println(" Voce ganhou 3 pontos de defesa !!!");
        System.out.println("Voce tem " + jogador.getArmadura() + " Pontos de armadura atualmente");
        System.out.println("===== +++ =====");
    }
}