public class Setor {
    private String nome;
    private double preco;
    private int qntd;
    private int capacidade;

    public Setor(String nome, double preco, int capacidade) {
        this.nome = nome;
        this.preco = preco;
        this.capacidade = capacidade;
        this.qntd = 0;
    }

    public void vender() {
        this.qntd++;
    }

    public int getCapacidade() {return this.capacidade;}
    public String getNome() {return this.nome;}
    public double getPreco() {return this.preco;}
    public int getQntd() {return this.qntd;}

    public String toString() {
        
        return this.nome + " " + this.preco + " " + this.qntd + "/" + this.capacidade;
    }
}
