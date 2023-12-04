/*a classe Item é uma representação de um item que pode ser coletado 
 * Ela implementa a interface Coletavel, fornecendo uma implementação específica para o método coletar.
 *  O método coletar retorna uma mensagem informativa indicando que o item foi coletado e inclui o nome do item.
 */
public class Item implements Coletavel {
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