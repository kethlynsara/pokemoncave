public class Item implements Coletavel {
    public String nome;

    public Item (String nome) {
        this.nome = nome;
    }

    public String getNome () {
        return nome;
    }

    public void coletar (Jogador jogador) {
        System.out.println("===== É uma " + nome + " =====");
    }
}