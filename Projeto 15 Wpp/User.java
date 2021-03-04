import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class User {
    private String id;
    protected Map<String, Chat> chats;
    protected List<Notify> notify;

    public User(String id) {
        this.id = id;
        this.chats = new TreeMap<>();
        this.notify = new ArrayList<>();
    }
    
    public Notify getNotifyUser(String chat) { // In doubt
        for(Notify not : this.notify) {
            if(not.chatId.equals(chat)) {
                return not;
            }
        }

        System.out.println("fail: Essa notificacao nao existe.");
        return null;
    }

    public void addChat(Chat chat) {
        for(String idChat : this.chats.keySet()) {
            if(chat.getId().equals(idChat)) {
                System.out.println("fail: Esse chat ja existe.");
                return;
            }
        }

        this.chats.put(chat.getId(), chat);
    }

    public void addNotify(Chat chat) { // In doubt
        for(Notify not : this.notify) {
            if(not.chatId.equals(chat.getId())) {
                System.err.println("fail: Essa notificacao ja existe");
                return;
            }
        }

        Notify not = new Notify(chat.getId());
        this.notify.add(not);
    }

    public void rmChat(Chat chat) {
        for(String idChat : this.chats.keySet()) {
            if(chat.getId().equals(idChat)) {
                this.chats.remove(idChat);
                return;
            }
        }

        System.out.println("fail: Nao existe esse chat.");
    }

    public Map<String, Chat> getChats() {return this.chats;}
    public List<Notify> getNotify() {return this.notify;}
    public String getId() {return this.id;}
}
