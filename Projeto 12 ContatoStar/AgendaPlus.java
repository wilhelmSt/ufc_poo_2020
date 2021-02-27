import java.util.Map.Entry;
import java.util.Map;
import java.util.TreeMap;

public class AgendaPlus extends Agenda{
    private Map<String, ContactPlus> bookmarks;

    public AgendaPlus() {
        this.bookmarks = new TreeMap<>();
        for(Entry<String, Contact> entry : getContacts().entrySet()) {
            this.bookmarks.put(entry.getKey(), new ContactPlus(entry.getValue().getName(), entry.getValue().getFones()));
        }
    }

    @Override
    public void addContact(ContactPlus contato) {
        for(String id : this.bookmarks.keySet()) {
            if(contato.getName().equals(id)) {
                System.out.println("fail: esse contato ja existe.");
                return;
            }
        }

        this.bookmarks.put(contato.getName(), contato);
    }

    @Override
    public void rmContact(String nome) {
        for(String id : this.bookmarks.keySet()) {
            if(nome.equals(id)) {
                this.bookmarks.remove(nome);
                return;
            }
        }

        System.out.println("fail: esse contato nao existe");
    }

    public void star(String id) {
        for(String contato : this.bookmarks.keySet()) {
            if(contato.equals(id)) {
                this.bookmarks.get(id).setBookmark(id);
                return;
            }
        }

        System.out.println("fail: esse contato nao existe.");
    }

    public void unStar(String id) {
        for(String contato : this.bookmarks.keySet()) {
            if(contato.equals(id)) {
                this.bookmarks.get(contato).starred = false;
                return;
            }
        }

        System.out.println("fail: esse contato nao existe.");
    }

    public void getBookmarks() {
        for(String id : this.bookmarks.keySet()) {
            if(this.bookmarks.get(id).starred) {
                System.out.println(this.bookmarks.get(id));
            }
        }
    }

    @Override
    public String toString() {
        for(String id : this.bookmarks.keySet()) {
            System.out.println(this.bookmarks.get(id));
        }
        return "";
    }
}
