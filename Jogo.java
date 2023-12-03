import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;

public class Jogo extends Component{
    private Analisador analisador;
    private Ambiente ambienteAtual;
    private boolean terminado;
    private Jogador jogador;
    private Combate combate;
    private int inimigosDerrotados;
        
    // Cria o jogo, definindo seu mapa e cenários.
    public Jogo() {
        criarMapa();
        analisador = new Analisador();
        terminado = false;
        jogador = new Jogador(100,5,20);
        combate = new Combate();
        inimigosDerrotados = 0;
    }

    // Cria todos os ambientes e liga as saidas deles
    private void criarMapa() {

        Ambiente grutaSubterranea, tunelRochoso, tunelLago, buracoTopo, salaVazia, tunelSalaCristal, areaIgnea,
        salaoSecreto, cavernaEscura, laboratorio, altarCristal, abismo, pedestalCrisal;

        ArrayList<Inimigo> inimigos = getInimigosDoJogo();      
      
        // Cria os ambiente, inserindo a descrição e o nome dos ambientes

        grutaSubterranea = new Ambiente("Gruta D'Água", "É Longo corrego com uma agua cristalina, cercada por rochas e algumas estalactites", inimigos.get(0));
        tunelRochoso = new Ambiente("Túnel Rochoso", "É um túnel amplo com pouca iluminacao e uma pequena trilha no centro");
        tunelLago = new Ambiente("Lago Subterrâneo", "É um grande lago com água fresca e limpa, cercado de minerios nas paredes rochosas", inimigos.get(1));
        buracoTopo = new Ambiente("Buraco", "É um enorme e profundo abismo, cercado de estactites e estalagmites", inimigos.get(2));
        salaVazia = new Ambiente("Sala Vazia", "É uma sala com pouca mobilia, bem iluminada e espacosa", inimigos.get(3));
        tunelSalaCristal = new Ambiente("Sala de Cristal", "É um salao com paredes feitas de cristais que reluzem em uma cor vibrante");
        areaIgnea = new Ambiente("Região quente", "É uma caverna com magma correndo ao fundo, bem escura");
        salaoSecreto = new Ambiente("Salao Secreto", "É uma Sala escondida entre as rochas com algumas estantes e livros");
        cavernaEscura = new Ambiente("Caverna Escura", "É uma área ampla, cheia de rochas e bem escura", inimigos.get(4));
        laboratorio = new Ambiente("Laboratorio", "É um estranho laboratorio com uma gaiola arrombada", new Inimigo("MewTwo", 150, 15, 20, new Item("Diploma")));
        altarCristal = new Ambiente("Altar de Cristal", "É um ambiente cercado de cristais bem iluminado e amplo, com um altar no centro");
        abismo = new Ambiente("Fundo do Abismo", "É uma caverna com muitas rochas pontiagudas e extremamente escura",inimigos.get(5));
        pedestalCrisal = new Ambiente("Pedestal de Cristal", "É um grande salao com um pedestal ao fim cercado de cristais pelo caminho", inimigos.get(6));

        // Define as rotas de saida
        //andar central
        grutaSubterranea.ajustarSaidas("leste", tunelRochoso);
        grutaSubterranea.ajustarSaidas("baixo", salaoSecreto);
        
        tunelRochoso.ajustarSaidas("norte", tunelLago);
        tunelRochoso.ajustarSaidas("oeste", grutaSubterranea);

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

        salaoSecreto.ajustarSaidas("cima", grutaSubterranea);
        salaoSecreto.ajustarSaidas("leste", cavernaEscura);

        cavernaEscura.ajustarSaidas("oeste", salaoSecreto);

        pedestalCrisal.ajustarSaidas("sul", abismo);

        ambienteAtual = tunelRochoso;  // O ambiente onde o jogo comeca é na area rochosa
    }

    // Devolve a lista de inimigos de forma aleatória
    private ArrayList<Inimigo> getInimigosDoJogo() {
        ArrayList<Inimigo> inimigos = new ArrayList<>();
        
        inimigos.add(new Inimigo("Zubat", 75, 3, 17, new ItemDefesa()));
        inimigos.add(new Inimigo("Rufflet", 80, 4, 16, new ItemDefesa()));
        inimigos.add(new Inimigo("Cramorant", 85, 5, 15, new ItemAtaque()));
        inimigos.add(new Inimigo("Sneasel", 90, 6, 14, new ItemAtaque()));
        inimigos.add(new Inimigo("Makuhita", 95, 7, 13, new ItemAtaque()));
        inimigos.add(new Inimigo("Delibird", 100, 8, 12, new ItemCura()));
        inimigos.add(new Inimigo("Geodude", 105, 9, 11, new ItemCura()));
        
        
        Collections.shuffle(inimigos);

        return inimigos;
    }

    // Onde o jogo é excecutado. Fica em loop ate terminar o jogo.
    public void jogar() {

        // Entra no loop de comando principal. Aqui nos repetidamente lemos
        // comandos e os executamos ate o jogo terminar.                
        while (! terminado) {
            Comando comando = analisador.pegarComando();
            terminado = processarComando(comando);
        }
        System.out.println("Obrigado por jogar. Ate mais!");
    }

    // Imprime a mensagem de abertura para o jogador.
    public String imprimirBoasVindas(){
        String montaBoasVindas;
        montaBoasVindas = "===== + + + ===== \n";
        montaBoasVindas += "Bem-vindo ao PokemonCave Game! \n";
        montaBoasVindas += "PokemonCave Game eh um jogo de explorassao, incrivelmente intrigante. \n";
        montaBoasVindas += "Digite 'ajuda' caso precise de algumas dicas. \n";
        montaBoasVindas += "===== + + + =====";
        
        montaBoasVindas += imprimeLocalAtual();
        return montaBoasVindas;
    }

    // Metodo usado para informar a localizacao atual do jogador
    private String imprimeLocalAtual(){
        String exibeLocal = "\nVoce esta no(a) " + ambienteAtual.getNome() + "\n";
        exibeLocal += "Saidas disponiveis: \n";
        
        for (String s: ambienteAtual.listaSaidas()) {
            exibeLocal += s + "  ";
        }
        exibeLocal += "\n";
        return exibeLocal;
    }

    // Dado um comando, processa-o (ou seja, executa-o)
    // @param comando O Comando a ser processado.
    // @return true se o comando finaliza o jogo.     
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
        else if (palavraDeComando.equals("observar")) {
            observarAmbiente();
        }
        else if (palavraDeComando.equals("sair")) {
            querSair = sair(comando);
        }

        return querSair;
    }

    // Implementacoes dos comandos do usuario

    //Exibimos uma mensagem contextualizada com o jogo
    //E listamos as possíveis decisões do jogador
    public String imprimirAjuda(){
        String ajuda = "Voce esta perdido e sozinho. Então voce caminha \n";
        ajuda += "pela enorme caverna estranha. \n \n";
        ajuda += "Suas ações disponíveis são: \n";
        ajuda += "===  ";
        for (String e : analisador.comandos()) {
            ajuda += e + "  ";
        }
        ajuda += "===";

        return ajuda;
    }

    //Tenta ir em uma direcao. Se existe uma saida entra no 
    //novo ambiente, caso contrario imprime mensagem de erro.
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

    public void observarAmbiente(){ // Como coletar decisao, muda Palavras de comando???
        System.out.println(ambienteAtual.descricaoCompleta());        

        if (ambienteAtual.temInimigo()) {
                lutar();
                imprimeLocalAtual();
        }
    }

    private void lutar() {
        if (!combate.luta(jogador, ambienteAtual.adversario())) {
            terminado = false;
            System.out.println("Voce esta morto, tente novamente !!!");
        } else {
            System.out.println("Voce esta coletou o item que estava com " + ambienteAtual.adversario().getNome());
            ambienteAtual.adversario().soltarItem().coletar(jogador);
            ambienteAtual.eliminaPokemon();
            inimigosDerrotados++;

            if (inimigosDerrotados == getInimigosDoJogo().size()) {
                System.out.println("Todos os inimigos foram derrotados! O último ambiente está liberado.");
            }
        } 
    }

    //"Sair" foi digitado. Verifica o resto do comando pra ver
    //se nos queremos realmente sair do jogo.
    //@return true, se este comando sai do jogo, false, caso contrario    
    public boolean sair(Comando comando) {
        if(comando.temSegundaPalavra()) {
            System.out.println("Sair o que?");
            return false;
        }
        else {
            return true;  // sinaliza que nos queremos sair
        }
    }

}
