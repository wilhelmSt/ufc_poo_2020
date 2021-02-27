import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Agenda {
    private Map<String, Contact> contacts;

    public Agenda() {
        this.contacts = new TreeMap<>();
    }

    public void addContact(ContactPlus contato) {
        for(String id : this.contacts.keySet()) {
            if(id.equals(contato.getName())) {
                System.out.println("fail: esse contato ja existe.");
                return;
            }
        }

        this.contacts.put(contato.getName(), contato);
    }

    public void rmContact(String nome) {
        for(String id : this.contacts.keySet()) {
            if(nome.equals(id)) {
                this.contacts.remove(nome);
                return;
            }
        }

        System.out.println("fail: esse contato nao existe");
    }

    public Map<String, Contact> search(String pattern) {
        Map<String, Contact> conta = new TreeMap<>();
        for(String contato : this.contacts.keySet()) {
            if(contato.contains(pattern)) {
                conta.put(contato, contacts.get(contato));
            }
        }

        for(Entry<String, Contact> entry : this.contacts.entrySet()) {
            for(Fone fone : entry.getValue().getFones()) {
                if(fone.getLabel().contains(pattern)) {
                    conta.put(entry.getKey(), entry.getValue());
                }
            }
        }

        for(Entry<String, Contact> entry : this.contacts.entrySet()) {
            for(Fone fone : entry.getValue().getFones()) {
                if(fone.getNumber().contains(pattern)) {
                    conta.put(entry.getKey(), entry.getValue());
                }
            }
        }

        return conta;

    }

    public Map<String, Contact> getContacts() {return this.contacts;}

    public Contact getContact(String contato) {
        for(String id : this.contacts.keySet()) {
            if(id.equals(contato)) {
                return this.contacts.get(id);
            }
        }

        System.out.println("fail: Nao tem um contato com esse nome.");
        return null;
    }

    public String toString() {
        for(String id : this.contacts.keySet()) {
            System.out.println(this.contacts.get(id));
        }
        return "";
    }
}
