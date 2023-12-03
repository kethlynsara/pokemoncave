public class ResultadoLuta {
    public static String obterMensagem(String nomeInimigo, Item itemColetado, boolean todosInimigosDerrotados, Jogador jogador) {
        String mensagem = " ";

        if (itemColetado != null) {
            mensagem = "===== Você venceu o combate === \n" + "Você coletou o item que estava com " + nomeInimigo + "\n";
            mensagem += itemColetado.coletar(jogador);
        }

        if (todosInimigosDerrotados) {
            mensagem += "\nTodos os inimigos foram derrotados! Voce Venceu !!! \n";
        }

        return mensagem;
    }
}

