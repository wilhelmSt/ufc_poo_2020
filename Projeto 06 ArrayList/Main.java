import java.util.ArrayList;

class Espiral {
    public String nome;
    public int quantidade;
    public float preco;

    public Espiral(String nome, int quantidade, float preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String toString() {
        return "";
    }
}

class Maquina {
    private ArrayList<Espiral> espirais;
    private float saldoCliente;
    private float lucro;
    private int maxProdutos;

    public Maquina(int quantidadeEspirais, int maxProdutos) {
        this.maxProdutos = maxProdutos;
        this.saldoCliente = 0f;
        this.lucro = 0f;

        this.espirais = new ArrayList<Espiral>();
        for(int i = 0; i < quantidadeEspirais; i++) {
            this.espirais.add(new Espiral("Empty", 0, 0f));
        }

    }

    public void inserirDinheiro(float dinheiro) {
        this.saldoCliente += dinheiro;
    }

    public void pedirTroco() {
        this.lucro = this.saldoCliente;
        this.saldoCliente = 0;
    }

    public void vender(int index) {
        if(index >= this.espirais.size()) {
            System.out.println("Indice nao existe");
        } else if (this.espirais.get(index).nome == "Empty" || this.espirais.get(index).quantidade == 0) {
            System.out.println("Espiral sem produtos");
        } else if (this.saldoCliente < this.espirais.get(index).preco) {
            System.out.println("Saldo insuficiente");
        } else {
            this.saldoCliente -= this.espirais.get(index).preco;
            this.espirais.get(index).quantidade--;
        }
    }

    public void alterarEspiral(int index, String nome, int quantidade, float preco) {
        if(index >= espirais.size()) {
            System.out.println("Indice nao existe");
        } else if (quantidade > this.maxProdutos) {
            System.out.println("Limite excedido");
        } else {
            Espiral alteraEspiral = new Espiral(nome, quantidade, preco);
            this.espirais.set(index, alteraEspiral);
        }
    }

    public void limparEspiral(int index) {
        if(index >= espirais.size()) {
            System.out.println("Indice nao existe");
        } else {
            Espiral limpaEspiral = new Espiral("Empty", 0, 0f);
            this.espirais.set(index, limpaEspiral);
        }
    }

    public float getSaldo() {
        return this.saldoCliente;
    }

    public String toString() {
        System.out.println("Saldo: "+this.getSaldo()+" RS");
        for (int i = 0; i < espirais.size(); i++) {
            System.out.println(i+" [ "+espirais.get(i).nome+" : "+espirais.get(i).quantidade+" U : "+espirais.get(i).preco+" RS]");
        }
        return "";
    }
}

public class Main {
    public static void main(String[] args) {
        Maquina maquina = new Maquina(3, 5);

        maquina.alterarEspiral(2, "todinho", 3, 2.50f);
        maquina.alterarEspiral(0, "tampico", 1, 1.50f);
        maquina.alterarEspiral(1, "xaverde", 3, 5.00f);

        maquina.inserirDinheiro(5f);
        maquina.inserirDinheiro(4f);

        System.out.println(maquina);

        maquina.pedirTroco();

        maquina.inserirDinheiro(8f);

        System.out.println(maquina);

        maquina.vender(1);
        maquina.vender(0);
        maquina.pedirTroco();

        System.out.println(maquina);
    }
}
