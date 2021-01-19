import java.util.ArrayList;

public class Contato implements Comparable<Contato>{
    private String nome;
    private ArrayList<Fone> fones;

    public Contato(String nomeC){
        this.nome = nomeC;
        this.fones = new ArrayList<Fone>();
    }

    public boolean addFone(String id, String number) {
        // verificar se o number já está cadastrado nos fones
        for(Fone fone : this.fones) {
            if(fone.number.equals(number)) {
                System.out.println("#ERRO# Esse numero ja esta cadastrado no nome dessa pessoa");
                return false;
            }
        }
        this.fones.add(new Fone(id, number));
        return true;
    }

    public boolean removeFone(int index) {
        // verificar se o index existe nos fones cadastrados
        if(index < this.fones.size()) {
            this.fones.remove(index);
            return true;
        } else {
            System.out.println("#ERRO# Esse index nao esta presente no ArrayList fones");
            return false;
        }
    }

    // Functions getters
    public String getNome() {return this.nome;}
    public ArrayList<Fone> getFones() {return this.fones;}
    // Function return string
    public String toString() {
        System.out.print("- "+this.nome);
        for(Fone fone : fones) {
            System.out.print(" ["+fones.indexOf(fone)+":"+fone.id+":"+fone.number+"]");
        }
        return " -";
    }

    public int compareTo(Contato other){
        return this.nome.compareTo(other.getNome());
    }
}
