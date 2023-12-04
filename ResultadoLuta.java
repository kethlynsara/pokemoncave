public class ResultadoLuta { //Kethlyn
    /**
     * método estático recebe vários parâmetros, incluindo o nome do inimigo
     * (nomeInimigo), um item coletado (itemColetado), um booleano indicando se
     * todos os inimigos foram derrotados (todosInimigosDerrotados), e uma instância
     * de Jogador (jogador).
     */
    public static String obterMensagem(String nomeInimigo, Item itemColetado, boolean todosInimigosDerrotados,
            Jogador jogador) {
        String mensagem = " ";
        /*
         * O código verifica se itemColetado não é nulo. Se não for nulo, adiciona uma
         * mensagem indicando que o jogador venceu o combate e coletou o item que estava
         * com o inimigo. Além disso, chama o método coletar do item coletado.
         */
        if (itemColetado != null) {
            mensagem = "===== Você venceu o combate === \n" + "Você coletou o item que estava com " + nomeInimigo
                    + "\n";
            mensagem += itemColetado.coletar(jogador);
        }

        if (todosInimigosDerrotados) {
            mensagem += "\nTodos os inimigos foram derrotados! Voce Venceu !!! \n";
        }

        return mensagem;
    }
}
/*
 * esse método gera uma mensagem de resultado com base nos parâmetros
 * fornecidos, incluindo informações sobre a vitória, a coleta de itens e a
 * derrota de inimigos
 */
