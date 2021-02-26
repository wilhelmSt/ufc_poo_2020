import java.util.Map.Entry;
import java.util.Map;
import java.util.TreeMap;

public class Evento {
    private String nome;
    private Map<String, Setor> repSetores;

    public Evento(String nome) {
        this.nome = nome;
        this.repSetores = new TreeMap<>();
    }

    public void addSetor(Setor setor) {

        if(verifNull(setor)) {
            throw new RuntimeException("Fail: setor is null");
        }

        this.repSetores.put(setor.getNome(), setor);
    }

    public String getNome() {return this.nome;}
    public Map<String, Setor> getRepSetores() {return this.repSetores;}

    public boolean verifNull(Setor setor) {
        if(setor == null) {
            return true;
        }
        return false;
    }

    public String toString() {
        System.out.println(this.nome);
        for(Entry<String, Setor> entry : this.repSetores.entrySet()) {
            System.out.println( "[ " + entry.getValue() + " ]");
        }
        return "";
    }
}