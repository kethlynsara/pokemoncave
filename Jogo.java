public class Jogo {
    private Analisador analisador;
    private Ambiente ambienteAtual;
        
    /**
     * Cria o jogo e incializa seu mapa interno.
     */
    public Jogo() {
        criarAmbientes();
        analisador = new Analisador();
    }

    /**
     * Cria todos os ambientes e liga as saidas deles
     */
    private void criarAmbientes() {
        Ambiente fonteTermal, tunelRochoso, tunelLago, buracoTopo, salaVazia, tunelSalaCristal, areaIgnea,
        salaoSecreto, cavernaEscura, laboratorio, altarCristal, abismo, pedestalCrisal;
      
        // cria os ambientes

        fonteTermal = new Ambiente(" fonte");
        tunelRochoso = new Ambiente("rochoso");
        tunelLago = new Ambiente("lago");
        buracoTopo = new Ambiente("buraco");
        salaVazia = new Ambiente("sala vazia");
        tunelSalaCristal = new Ambiente("sala cristal");
        areaIgnea = new Ambiente("area com lava");
        salaoSecreto = new Ambiente("salao secreto");
        cavernaEscura = new Ambiente("caverna escura");
        laboratorio = new Ambiente("laboratorio");
        altarCristal = new Ambiente("altar cristal");
        abismo = new Ambiente("abismo");
        pedestalCrisal = new Ambiente("pedesta de cristal");

        // inicializa as saidas dos ambientes
        //andar central
        fonteTermal.ajustarSaidas("leste", tunelRochoso);
        fonteTermal.ajustarSaidas("baixo", salaoSecreto);
        
        tunelRochoso.ajustarSaidas("norte", tunelLago);
        tunelRochoso.ajustarSaidas("oeste", fonteTermal);

        tunelLago.ajustarSaidas("norte", tunelSalaCristal);
        tunelLago.ajustarSaidas("sul", tunelRochoso);
        tunelLago.ajustarSaidas("leste", buracoTopo);
        tunelLago.ajustarSaidas("baixo", laboratorio);

        buracoTopo.ajustarSaidas("oeste", tunelLago);
        buracoTopo.ajustarSaidas("baixo", abismo);

        tunelSalaCristal.ajustarSaidas("sul", tunelLago);
        tunelSalaCristal.ajustarSaidas("oeste", areaIgnea);
        tunelSalaCristal.ajustarSaidas("leste", salaVazia);

        salaVazia.ajustarSaidas("oeste", tunelSalaCristal);

        areaIgnea.ajustarSaidas("leste", tunelSalaCristal);
        areaIgnea.ajustarSaidas("baixo", altarCristal);

        //andar inferior
        altarCristal.ajustarSaidas("cima", areaIgnea);

        abismo.ajustarSaidas("cima", buracoTopo);
        abismo.ajustarSaidas("norte", pedestalCrisal);

        salaoSecreto.ajustarSaidas("cima", fonteTermal);
        salaoSecreto.ajustarSaidas("leste", cavernaEscura);

        cavernaEscura.ajustarSaidas("oeste", salaoSecreto);

        pedestalCrisal.ajustarSaidas("sul", abismo);

        ambienteAtual = tunelRochoso;  // o jogo comeca na area rochosa
    }

    /**
     *  Rotina principal do jogo. Fica em loop ate terminar o jogo.
     */
    public void jogar() {            
        imprimirBoasVindas();

        // Entra no loop de comando principal. Aqui nos repetidamente lemos
        // comandos e os executamos ate o jogo terminar.
                
        boolean terminado = false;
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Ate mais!");
    }

    /**
     * Imprime a mensagem de abertura para o jogador.
     */
    private void imprimirBoasVindas()
    {
        System.out.println();
        System.out.println("Bem-vindo ao World of Zuul!");
        System.out.println("World of Zuul eh um novo jogo de aventura, incrivelmente chato.");
        System.out.println("Digite 'ajuda' se voce precisar de ajuda.");
        System.out.println();
        
        imprimeLocalAtual();
    }


    // Método que imprime o local atual em que esta o jogador
    private void imprimeLocalAtual(){
        System.out.println("Voce esta em um(a) " + ambienteAtual.getDescricao());
    
        System.out.println("Saidas disponiveis:");
        
        for (String s: ambienteAtual.listaSaidas()) {
            System.out.print(s + "  ");
        }
        System.out.println();
    }

    /**
     * Dado um comando, processa-o (ou seja, executa-o)
     * @param comando O Comando a ser processado.
     * @return true se o comando finaliza o jogo.
     */
    private boolean processarComando(Comando comando){
        boolean querSair = false;

        if(comando.ehDesconhecido()) {
            System.out.println("Eu nao entendi o que voce disse...");
            return false;
        }

        String palavraDeComando = comando.getPalavraDeComando();
        if (palavraDeComando.equals("ajuda")) {
            imprimirAjuda();
        }
        else if (palavraDeComando.equals("ir")) {
            irParaAmbiente(comando);
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }

        return querSair;
    }

    // Implementacoes dos comandos do usuario

    /**
     * Printe informacoes de ajuda.
     * Aqui nos imprimimos algo bobo e enigmatico e a lista de 
     * palavras de comando
     */
    private void imprimirAjuda() 
    {
        System.out.println("Voce esta perdido. Voce esta sozinho. Voce caminha");
        System.out.println("pela universidade.");
        System.out.println();
        System.out.println("Suas palavras de comando sao:");
        System.out.print("==  ");
        for (String e : analisador.comandos()) {
            System.out.print(e + "  ");
        }
        System.out.println("==");
    }

    /** 
     * Tenta ir em uma direcao. Se existe uma saida entra no 
     * novo ambiente, caso contrario imprime mensagem de erro.
     */
    private void irParaAmbiente(Comando comando) {
        if(!comando.temSegundaPalavra()) {
            // se nao ha segunda palavra, nao sabemos pra onde ir...
            System.out.println("Ir pra onde?");
            return;
        }

        String direcao = comando.getSegundaPalavra();

        // Tenta sair do ambiente atual
        Ambiente proximoAmbiente = null;
        
        if (ambienteAtual.listaSaidas().contains(direcao)) {
            proximoAmbiente = ambienteAtual.getSaida(direcao);
        }

        if (proximoAmbiente == null) {
            System.out.println("Nao ha passagem!");
        } else {
            ambienteAtual = proximoAmbiente;            
           imprimeLocalAtual();
        }
    }

    /** 
     * "Sair" foi digitado. Verifica o resto do comando pra ver
     * se nos queremos realmente sair do jogo.
     * @return true, se este comando sai do jogo, false, caso contrario
     */
    private boolean sair(Comando comando) 
    {
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nos queremos sair
        }
    }
}
