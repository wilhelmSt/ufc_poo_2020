import java.util.ArrayList;
import java.util.List;

public class Inbox {
    public User user;
    public List<Msg> msgs;

    public Inbox(String id) {
        this.user = new User(id);
        this.msgs = new ArrayList<>();
    }

    public void addMsg(Msg msg) {
        this.msgs.add(msg);
    }

    public List<Msg> getMsgs() {return this.msgs;}
    public User getUser() {return this.user;}
}
