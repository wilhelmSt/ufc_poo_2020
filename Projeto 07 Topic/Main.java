import java.util.ArrayList;
import java.util.Collections;

class Pass {
    private String nome;
    private int idade;

    public Pass(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public String getNome() {
        return this.nome;
    }
    public int getIdade() {
        return this.idade;
    }
    public String toString() {
        return "";
    }
}

class Topic {
    public ArrayList<Pass> cadeiras;
    public int qtdPref;

    public Topic(int lotacao, int qtdPref) {
        this.qtdPref = qtdPref;
        this.cadeiras = new ArrayList<>(Collections.nCopies(lotacao, null));
    }

    public void descer(String nome) {
        // Verificar se o pass está na Topic

        boolean verifPass = false;
        for(Pass i : this.cadeiras) {
            if(i != null && i.getNome() == nome) {
                verifPass = true;
            }
        }

        if(verifPass) {
            for(int i = 0; i < this.cadeiras.size(); i++) {
                if(this.cadeiras.get(i).getNome() == nome) {
                    this.cadeiras.set(i, null);
                    break;
                }
            }
        } else {
            System.out.println("Passageiro nao esta na Topic");
        }

    }

    public boolean subir(Pass p) {
        boolean verifVaga = false;
        for(Pass i : this.cadeiras) {
            if(i == null) {
                verifVaga = true;
                break;
            }
        }
        for(Pass i : this.cadeiras) {
            if(i != null && i.getNome() == p.getNome()) {
                System.out.println("Passageiro ja esta na Topic");
                return false;
            }
        }

        if(verifVaga) {
            if(p.getIdade() >= 60) {
                for(int i = 0; i < this.cadeiras.size(); i++) {
                    if(this.cadeiras.get(i) == null) {
                        this.cadeiras.set(i, p);
                        return true;
                    }
                }
            } else {
                for(int i = this.qtdPref; i < this.cadeiras.size(); i++) {
                    if(this.cadeiras.get(i) == null) {
                        this.cadeiras.set(i, p);
                        return true;
                    }
                }
                for(int i = 0; i < this.qtdPref; i++) {
                    if(this.cadeiras.get(i) == null) {
                        this.cadeiras.set(i, p);
                        return true;
                    }
                }
            }
        } else {
            System.out.println("Topic esta lotada");
            return false;
        }
        return true;
    }

    public String toString() {
        System.out.print("[ ");
        for(int i = 0; i < this.cadeiras.size(); i++) {
            if(i < this.qtdPref && this.cadeiras.get(i) == null) {
                System.out.print("@ ");
            } else if(i >= this.qtdPref && this.cadeiras.get(i) == null) {
                System.out.print("= ");
            } else {
                System.out.print(this.cadeiras.get(i).getNome() +":"+this.cadeiras.get(i).getIdade()+" ");
            }
        }
        return "]";
    }
}

public class Main {
    public static void main(String[] args) {
        Topic topic = new Topic(5, 2);
        System.out.println(topic);

        topic.subir(new Pass("Davi", 17));
        topic.subir(new Pass("Joao", 103));
        topic.subir(new Pass("Ana", 35));
        topic.subir(new Pass("Rex", 20));
        topic.subir(new Pass("Bia", 16));
    
        System.out.println(topic);

        topic.descer("Davi");

        System.out.println(topic);

        topic.subir(new Pass("Aragao", 96));
        System.out.println(topic);
        topic.subir(new Pass("Lucas", 23));

        topic.descer("Marcelo");
        topic.descer("Ana");
        topic.subir(new Pass("Bia", 16));

        System.out.println(topic);
    }
}
