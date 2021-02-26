public class Pessoa {
    private String nome;
    private boolean meia;

    public Pessoa(String nome, boolean pagaMeia) {
        this.nome = nome;
        this.meia = pagaMeia;
    }

    public String toString() {
        String pagaMeia;
        if(this.meia) {
            pagaMeia = "sim";
        } else {
            pagaMeia = "nao";
        }
        
        return "Nome: " + this.nome + " Paga meia: " + pagaMeia;
    }

    public String getNome() {return this.nome;}
    public boolean getMeia() {return this.meia;}
}
