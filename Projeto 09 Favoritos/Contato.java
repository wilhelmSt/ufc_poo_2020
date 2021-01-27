import java.util.ArrayList;

public class Contato {
    private String name;
    private ArrayList<Fone> fones;
    private boolean starred;

    public Contato(String name) {
        setName(name);
        this.fones = new ArrayList<>();
        this.starred = false;
    }

    public void addFone(String label, int number) {
        for(Fone fone : this.getFones()) {
            if(fone.getNumber() == number) {
                System.out.println("#ERRO# Esse numero ja esta cadastrado nesse contato");
                return;
            }
        }
        this.fones.add(new Fone(label, number));
    }
    public void rmFone(int index) {
        if(index < this.fones.size()) {
            this.fones.remove(index);
        } else {
            System.out.println("#ERRO# Esse existe fone nesse index");
        }
    }
    public void setBookmark(boolean value) {
        this.starred = value;
    }

    private void setName(String name){this.name = name;}
    public String getName(){return this.name;}
    public ArrayList<Fone> getFones() {return this.fones;}
    public boolean getStarred() {return this.starred;}

    public String toString() {
        if(starred) {
            System.out.print("@ " + this.getName());
        } else {
            System.out.print("- " + this.getName());
        }
        for(Fone fone : this.getFones()) {
            System.out.print(" [" + this.getFones().indexOf(fone) + ":" + fone + "]");
        }
        return " -";
    }
}
