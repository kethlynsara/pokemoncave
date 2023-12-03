public class ItemDefesa extends Item {

    public ItemDefesa() {
        super("Apricot berry");
    }

    public String coletar(Jogador jogador) {
        String msgColeta;
        jogador.somarArmadura(3);
        super.coletar(jogador);
        msgColeta = "\n Voce ganhou 3 pontos de defesa !!! \n";
        msgColeta +="Voce tem " + jogador.getArmadura() + " Pontos de armadura atualmente \n";
        msgColeta += "===== +++ =====  \n";

        return msgColeta;
    }
}