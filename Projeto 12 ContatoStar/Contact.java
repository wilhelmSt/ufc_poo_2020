import java.util.ArrayList;
import java.util.List;

public class Contact implements Comparable<Contact>{
    private String name;
    private ArrayList<Fone> fones;

    public Contact(String nome, List<Fone> fones) {
        this.name = nome;
        this.fones = new ArrayList<>(fones);
    }

    public void addFone(String label, int number) {
        for(Fone fone : this.fones) {
            if(fone.getLabel().equals(label)) {
                System.out.println("fail: O fone " + fone + " já existe");
                return;
            }
        }

        this.fones.add(new Fone(label, number));
    }

    public void rmFone(int index) {
        if(index >= this.fones.size() || index < 0) {
            System.out.println("fail: index " + index + " nao existe");
            return;
        }

        this.fones.remove(index);
    }

    public ArrayList<Fone> getFones() {return this.fones;}
    public String getName() {return this.name;}

    public void setName(String name) {this.name = name;}
    public void setFones(ArrayList<Fone> fones) {this.fones = fones;}

    public String toString() {
        System.out.print(getName() + " ");
        for(Fone fone : getFones()) {
            System.out.print("[" + getFones().indexOf(fone) + ":" + fone + "]");
        }
        return "";
    }

    @Override
    public int compareTo(Contact o) {
        return this.name.compareTo(o.getName());
    }
}
