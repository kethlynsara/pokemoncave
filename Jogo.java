public class Jogo {
    private Analisador analisador;
    private Ambiente ambienteAtual;
        
    // Cria o jogo, definindo seu mapa e cenários.
    public Jogo() {
        criarMapa();
        analisador = new Analisador();
    }

    // Cria todos os ambientes e liga as saidas deles
    private void criarMapa() {

        Ambiente fonteTermal, tunelRochoso, tunelLago, buracoTopo, salaVazia, tunelSalaCristal, areaIgnea,
        salaoSecreto, cavernaEscura, laboratorio, altarCristal, abismo, pedestalCrisal;
      
        // Cria os ambiente, inserindo a descrição e o nome dos ambientes

        fonteTermal = new Ambiente("Fonte Termal", " descrissao ");
        tunelRochoso = new Ambiente("Túnel Rochoso", " descrissao ");
        tunelLago = new Ambiente("Lago Subterrâneo", " descrissao ");
        buracoTopo = new Ambiente("Buraco", " descrissao ");
        salaVazia = new Ambiente("Sala Vazia", " descrissao ");
        tunelSalaCristal = new Ambiente("Sala de Cristal", " descrissao ");
        areaIgnea = new Ambiente("Região com Magma", " descrissao ");
        salaoSecreto = new Ambiente("Salao Secreto", " descrissao ");
        cavernaEscura = new Ambiente("Caverna Escura", " descrissao ");
        laboratorio = new Ambiente("Laboratorio", " descrissao ");
        altarCristal = new Ambiente("Altar de Cristal", " descrissao ");
        abismo = new Ambiente("Fundo do Abismo", " descrissao ");
        pedestalCrisal = new Ambiente("Pedestal de Cristal", " descrissao ");

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

        ambienteAtual = tunelRochoso;  // O ambiente onde o jogo comeca é na area rochosa
    }

    // Onde o jogo é excecutado. Fica em loop ate terminar o jogo.
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

    // Imprime a mensagem de abertura para o jogador.
    private void imprimirBoasVindas(){
        System.out.println();
        System.out.println("Bem-vindo ao PokemonCave Game!");
        System.out.println("PokemonCave Game eh um jogo de explorassao, incrivelmente intrigante.");
        System.out.println("Digite 'ajuda' caso precise de algumas dicas.");
        System.out.println();
        
        imprimeLocalAtual();
    }

    // Metodo usado para informar a localizacao atual do jogador
    private void imprimeLocalAtual(){
        System.out.println("Voce esta no(a) " + ambienteAtual.getNome());
    
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
    Exibimos uma mensagem contextualizada com o jogo
    E listamos as possíveis decisões do jogador
    */
    private void imprimirAjuda(){
        System.out.println("Voce esta perdido e sozinho. Então voce caminha");
        System.out.println("pela enorme caverna estranha.");
        System.out.println();
        System.out.println("Suas ações disponíveis são:");
        System.out.print("==  ");
        for (String e : analisador.comandos()) {
            System.out.print(e + "  ");
        }
        System.out.println("==");
    }

    /**
    Tenta ir em uma direcao. Se existe uma saida entra no 
    novo ambiente, caso contrario imprime mensagem de erro.
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
    "Sair" foi digitado. Verifica o resto do comando pra ver
    se nos queremos realmente sair do jogo.
    @return true, se este comando sai do jogo, false, caso contrario
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
