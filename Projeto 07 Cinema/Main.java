import java.util.ArrayList;

class Cliente {
    public String id;
    public String nome;

    public Cliente(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }
}
class Cinema {
    private ArrayList<Cliente> clientes;
    public Cinema(int size) {
        this.clientes = new ArrayList<Cliente>();
        for(int i = 0; i < size; i++) {
            this.clientes.add(null);
        }
        
    }

    public void reservar(String nome, String id, int posicao) {
        for(int i = 0; i < this.clientes.size(); i++) {
            if(this.clientes.get(i) != null && this.clientes.get(i).nome.equals(nome)) {
                System.out.println("Cliente ja esta no cinema");
                break;
            } else if(this.clientes.get(posicao) == null) {
                this.clientes.set(posicao, new Cliente(nome, id));
                break; 
            } else if(this.clientes.get(posicao) != null) {
                System.out.println("Cadeira ja esta ocupada");
                break;
            }
        }
    }

    public void cancelar(String name) {
        for(int i = 0; i < this.clientes.size(); i++) {
            if (this.clientes.get(i) != null && this.clientes.get(i).nome.equals(name)) {
                this.clientes.set(i, null);
                break;
            } else {
                System.out.println("Cliente nao esta no cinema");
                break;
            }
        }
    }

    public String toString() {
        System.out.print("[ ");
        for(Cliente i : clientes) {
            if(i == null) {
                System.out.print("- ");
            } else {
                System.out.print(i.nome+":"+i.id+ " ");
            }
        }
        System.out.println("]");
        return "";
    }
}
class Fluxo {

}

public class Main {
    public static void main(String[] args) {
        Cinema cinema = new Cinema(0);

        cinema = new Cinema(4);
        System.out.println(cinema);

        cinema.reservar("davi", "3232", 0);
        System.out.println(cinema);

        cinema.reservar("davi", "3232", 2);
        cinema.reservar("joao", "3131", 3);

        System.out.println(cinema);

        cinema.cancelar("davi");
        System.out.println(cinema);

        cinema.cancelar("rita");
        System.out.println(cinema);

    }
}
