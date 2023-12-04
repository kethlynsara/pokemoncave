import java.awt.Component;
import java.util.ArrayList;
import java.util.Collections;


public class Jogo extends Component{ // Luis Gustavo && Kethlyn
    private Ambiente ambienteAtual;
    private Jogador jogador;
    private PalavrasComando comandos;
    private int inimigosDerrotados;
        
    // Cria o jogo, definindo seu mapa e cenários.
    public Jogo(Jogador jogador) {
        this.jogador = jogador;
        inimigosDerrotados = 0;
        comandos = new PalavrasComando();
        criarMapa();
    }

    /* Cria todos os ambientes e liga as saidas deles*/
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
        laboratorio = new Ambiente("Laboratorio", "É um estranho laboratorio com uma gaiola arrombada", new Inimigo("MewTwo", 100, 13, 17, new Item("Diploma")));
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

    // Metodo usado para informar a localizacao atual do jogador
    public String imprimeLocalAtual(){
        String exibeLocal = "\nVoce esta no(a) " + ambienteAtual.getNome() + "\n";
        exibeLocal += "Saidas disponiveis: \n";
        
        for (String s: ambienteAtual.listaSaidas()) {
            exibeLocal += s + "  ";
        }
        exibeLocal += "\n";
        return exibeLocal;
    }

    // Implementacoes dos comandos do usuario

    //Exibimos uma mensagem contextualizada com o jogo
    //E listamos as possíveis decisões do jogador
    public String imprimirAjuda(){
        String ajuda = "\nVoce esta perdido e sozinho. Então voce caminha \n";
        ajuda += "pela enorme caverna estranha. \n \n";
        ajuda += "Suas ações disponíveis são: \n";
        ajuda += "===  ";
        for (String e : comandos.listaDeComandos()) {
            ajuda += e + "  ";
        }
        ajuda += "=== \n";

        return ajuda;
    }

    /*Tenta ir em uma direcao. Se existe uma saida entra no 
    novo ambiente, caso contrario imprime mensagem de erro.*/    
    public boolean irParaAmbiente(String direcao) {
        
        Ambiente proximoAmbiente = null;
        
        if (ambienteAtual.listaSaidas().contains(direcao)) {
            proximoAmbiente = ambienteAtual.getSaida(direcao);
        }

        if (proximoAmbiente == null) {
            throw new IndexOutOfBoundsException("Nao ha nada nessa direcao!!!");
        } else {
            ambienteAtual = proximoAmbiente;
            if (ambienteAtual.getNome() == "Gruta D'Água") {
                jogador.somarPontosDeVida(200);
                return true;
           }
        }

        return false;
    }

    public String observarAmbiente(){
        String descricaoAmbiente = "\n" + ambienteAtual.descricaoCompleta();        

        if (ambienteAtual.temInimigo()) {
                String luta = lutar();
                descricaoAmbiente += luta + imprimeLocalAtual();
        }
        return descricaoAmbiente;
    }

    public boolean venceu(){
        return inimigosDerrotados == getInimigosDoJogo().size();
    }

    public String lutar() {
        boolean vitoria = TelaCombate.lutar(ambienteAtual.adversario(), jogador);
        String nomeInimigo = ambienteAtual.adversario().getNome();
        Item itemColetado = null;

        if (vitoria) {
            itemColetado = ambienteAtual.adversario().soltarItem();
            ambienteAtual.eliminaPokemon();
            inimigosDerrotados++;
            return ResultadoLuta.obterMensagem(nomeInimigo, itemColetado, inimigosDerrotados == getInimigosDoJogo().size(), jogador);
        } else {
            return " VOCÊ MORREU !!!";
        }
    }
}
