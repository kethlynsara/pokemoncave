public class ItemAtaque extends Item {

    public ItemAtaque() {
        super("Liechi berry");
    }

    public String coletar(Jogador jogador) {
        String msgColeta;
        jogador.somarAtaque(3);
        super.coletar(jogador);
        msgColeta = "\n Voce ganhou 3 pontos de ataque !!! \n";
        msgColeta += "Voce tem " + jogador.getAtaque() + " Pontos de ataque atualmente \n";
        msgColeta +="===== +++ =====\n";

        return msgColeta;
    }
}