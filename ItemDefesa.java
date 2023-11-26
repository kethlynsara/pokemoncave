public class ItemDefesa extends Item {

    public ItemDefesa(String nome) {
        super(nome);
    }

    public void coletar(Jogador jogador) {
        jogador.setArmadura(1);
        super.coletar(jogador);
        System.out.println(" Voce ganhou 1 ponto de defesa !!!");
        System.out.println("Voce tem " + jogador.getArmadura() + " Pontos de armadura atualmente");
        System.out.println("===== +++ =====");
    }
}