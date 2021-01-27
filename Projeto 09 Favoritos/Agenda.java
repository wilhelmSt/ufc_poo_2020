import java.util.Map.Entry;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Collections;

public class Agenda {
    private TreeMap<String, Contato> contacts;
    private TreeMap<String, Contato> bookmarks;

    public Agenda() {
        this.contacts = new TreeMap<>();
        this.bookmarks = new TreeMap<>();
    }

    public void addContato(String name, List<Fone> foneC) {
        if(this.contacts.containsKey(name)) {
            System.out.println("#ERRO# ja existe um contato com esse nome.");
            return;
        }
        Contato contato = new Contato(name);
        for(Fone fone : foneC) {
            contato.addFone(fone.getLabel(), fone.getNumber());
        }
        this.contacts.put(name, contato);
    }

    public void rmContato(String name) {
        if(this.contacts.containsKey(name)) {
            this.contacts.remove(name);
            return;
        }
        System.out.println("#ERRO# Nao existe um contato com esse nome.");
    }

    public TreeMap<String, Contato> search(String pattern) {
        TreeMap<String, Contato> mapa = new TreeMap<String, Contato>();

        for(String i : this.contacts.keySet()) {
            if(i.contains(pattern)) {
                mapa.put(i, this.contacts.get(i));
            }
        }
        
        int patternInt = Integer.parseInt(pattern);

        for(Entry<String, Contato> a : contacts.entrySet()) {
            for(Fone b : a.getValue().getFones()) {
                if(b.getNumber() == patternInt) {
                    mapa.put(a.getKey(), a.getValue());
                }
            }
        }

        return mapa;
    }
    
    public void bookmark(String name) {
        if(this.contacts.containsKey(name)) {
            if(this.contacts.get(name).getStarred()) {
                System.out.println("#ERRO# Esse contato ja esta favoritado");
                return;
            } else {
                this.contacts.get(name).setBookmark(true);
                this.bookmarks.put(name, this.contacts.get(name));
                return;
            }
        }
        System.out.println("#ERRO# Esse nome nao existe nos contatos");
    }
    public void unBookmark(String name) {
        if(this.contacts.containsKey(name)) {
            if(this.contacts.get(name).getStarred()) {
                this.contacts.get(name).setBookmark(false);
                this.bookmarks.remove(name);
                return;
            } else {
                System.out.println("#ERRO# Esse contato ja nao estava favoritado");
                return;
            }
            
        }
        System.out.println("#ERRO# Esse nome nao existe nos contatos");
    }
    public void getBookmarks() {
        for(Contato contato : this.contacts.values()) {
            if(contato.getStarred()) {
                System.out.print(contato);
                System.out.println("");
            }
        }
        System.out.println("");
    }

    public Contato getContato(String name) {
        if(this.contacts.containsKey(name)) {
            return this.contacts.get(name);
        }
        System.out.println("#ERRO# Nao existe um contato com esse nome.");
        return null;
    }
    public TreeMap<String, Contato> getContatos(){return this.contacts;}

    @Override
    public String toString() {
        for(Contato contato : this.getContatos().values()) {
            System.out.println(contato);
        }
        return "";
    }
}
