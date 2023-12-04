public class Item implements Coletavel { // Luis Gustavo
    public String nome;

    public Item (String nome) {
        this.nome = nome;
    }

    public String getNome () {
        return nome;
    }

    public String coletar (Jogador jogador) {
        return "===== É uma " + nome + " =====";
    }
}