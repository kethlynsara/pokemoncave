public class ItemDefesa extends Item implements Coletavel{

    public ItemDefesa(String nome) {
        super(nome);
    }

    public void coletar(Jogador jogador) {
        jogador.setArmadura(1);
        System.out.println("===== +++ =====");
        System.out.println("É uma Berry " + nome + " Voce ganhou 1 ponto de defesa !!!");
        System.out.println("Voce tem " + jogador.getArmadura() + " Pontos de armadura atualmente");
        System.out.println("===== +++ =====");
    }
}