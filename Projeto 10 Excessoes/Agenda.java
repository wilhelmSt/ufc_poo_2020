import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Agenda {
    private ArrayList<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void findContato(String nome) {
        for(Contato contato : contatos) {

            if(verifNull(contato)) {
                throw new RuntimeException("#Erro# contato is null");
            }


            if(contato.getNome() == nome) {
                System.out.println("Esse é o index desse contato:" + contatos.indexOf(contato));
            }
        }
        System.out.println("#ERRO# Contato nao foi encontrado.");
    }

    public void addContato(String nome, List<Fone> fonesC) {

        // Verificar se o nome já existe
        ArrayList<Fone> fones = new ArrayList<>(fonesC);
        boolean verif = true;
        for(Contato conta : contatos) {
            if(conta.getNome().equals(nome)) {
                System.out.println("#ERRO# Ja existe um contato com esse nome.");
                verif = false;
            }
        }
        if(verif) {
            Contato contato = new Contato(nome);
            for(Fone fone : fones){
                contato.addFone(fone.id, fone.number);
            }

            this.contatos.add(contato);
        }
        Collections.sort(this.contatos);
    }

    public boolean removeContato(String nome) {
        for(Contato conta : contatos) {

            if(verifNull(conta)) {
                throw new RuntimeException("#Erro# contato is null");
            }

            if(conta.getNome().equals(nome)) {
                contatos.remove(conta);
                Collections.sort(this.contatos);
                return true;
            }
        }
        System.out.println("#ERRO# Nao existe um contato com esse nome.");
        return false;
    }

    public boolean removeFone(String nome, int index) {
        
        for(Contato contato : this.contatos){
            if(contato.getNome().equals(nome)){
                contato.removeFone(index);
                return true;
            }
        }
        System.out.println("#ERRO# Nao existe um contato com esse nome.");
        return false;
    }

    public boolean addFone(String nome, String id, String number) {
        for(Contato contato : this.contatos){
            if(contato.getNome().equals(nome)){
                contato.addFone(id, number);
                return true;
            }
        }
        System.out.println("#ERRO# Nao existe um contato com esse nome.");
        return false;
    }

    public ArrayList<Contato> search(String pattern) {
        ArrayList<Contato> conta = new ArrayList<>();
        for(Contato contato : this.contatos){
            if(contato.getNome().contains(pattern)){
                conta.add(contato);
            }
        }
        for(Contato contato : this.contatos){
            for(Fone fone : contato.getFones()){
                if(fone.id.contains(pattern)) {
                    conta.add(contato);
                }  
            }
        }
        for(Contato contato : this.contatos){
            for(Fone fone : contato.getFones()){
                if(fone.number.contains(pattern)) {
                    conta.add(contato);
                }  
            }
        }
        return conta;

    }

    public ArrayList<Contato> getContatos() {
        return this.contatos;
    }

    public Contato getContato(String nome) {
        for(Contato contato : this.contatos){
            if(contato.getNome().equals(nome)){
                return contato;
            }
        }
        return null;
    }

    public String toString() {
        for(Contato contato : contatos) {
            System.out.println(contato);
        }
        return "";
    }

    public boolean verifNull(Contato contato) {
        if(contato == null) {
            return true;
        }
        return false;
    }
}
