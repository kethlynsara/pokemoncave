public class ItemCura extends Item {

    public ItemCura() {
        super("Oran berry");
    }

    public String coletar(Jogador jogador) {
        String msgColeta;
        jogador.somarPontosDeVida(10);
        super.coletar(jogador);
        msgColeta = "\nVoce ganhou 10 pontos de vida !!! \n";
        msgColeta += "Voce tem " + jogador.getPontosDeVida() + " Pontos de vida atualmente \n";
        msgColeta +="===== +++ ===== \n";
        
        return msgColeta;
    }
}