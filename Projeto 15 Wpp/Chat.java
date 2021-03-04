import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Chat {
    private String id;
    protected Map<String, Inbox> inboxes;
    protected Map<String, User> users;

    public Chat(String id) {
        this.id = id;
        this.inboxes = new TreeMap<>();
        this.users = new TreeMap<>();
    }

    public List<Msg> getMsgs(String userId) {
        List<Msg> msgs = new ArrayList<>();

        for(String id : this.users.keySet()) {
            if(id.equals(userId)) {
                for(String in : this.inboxes.keySet()) {
                    for(Msg msg : this.inboxes.get(in).msgs) {
                        msgs.add(msg);                        
                    }
                }
            }
        }
        return msgs;
    }

    public void deliverZap(User userSend, String message) {
        Msg msg = new Msg(userSend.getId(), message);
        this.inboxes.get(userSend.getId()).addMsg(msg);
    }

    public Inbox getInboxUser(User user) {
        for(String id : this.users.keySet()) {
            if(id.equals(user.getId())) {
                for(String in : this.inboxes.keySet()) {
                    for(Msg msg : this.inboxes.get(in).msgs) {
                        System.out.println(msg.text);                        
                    }
                }
            }
        }
        return null;
    }

    public void getUnread(String userId) {
        for(String id : this.users.keySet()) {
            if(id.equals(userId)) {

            }
        }
    }

    public boolean hasUser(String userId) {
        boolean retorno = false;

        for(String id : this.users.keySet()) {
            if(id.equals(userId)) {
                retorno = true;
            }
        }

        return retorno;
    }

    public void addUserchat(User user) {
        for(String id : this.users.keySet()) {
            if(id.equals(user.getId())) {
                System.out.println("fail: esse usuario ja existe nesse chat.");
                return;
            }
        }

        this.users.put(user.getId(), user);
    }

    public void rmUserChat(User user) {
        if(this.users.containsValue(user)) {
            this.users.remove(user.getId());
        } else {
            System.out.println("fail: esse usuario nao existe nesse chat.");
        }
    }


    public Map<String, User> getUsers() {return this.users;}
    public String getId() {return this.id;}
}
