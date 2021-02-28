import java.util.TreeSet;

public class Tweet {
    private int idTw;
    private String username;
    private String msg;
    private TreeSet<String> likes;

    public Tweet(int id, String username, String msg) {
        setIdTw(id);
        setUsername(username);
        setMsg(msg);
        this.likes = new TreeSet<>();
    }

    public void like(String username) {
        this.likes.add(username);
    }


    public int getIdTw() {return this.idTw;}
    public String getUsername() {return this.username;}
    public String getMsg() {return this.msg;}
    public TreeSet<String> getLikes() {return this.likes;}

    public void setIdTw(int idTw) {this.idTw = idTw;}
    public void setUsername(String username) {this.username = username;}
    public void setMsg(String msg) {this.msg = msg;}

    public String toString() {
        System.out.print(getIdTw() + ":" + getUsername() + "( " + getMsg() + " )");
        if(this.likes.size() > 0) {
            System.out.print("[ ");
            for(String id : this.likes) {
                System.out.print(id + " ");
            }
            System.out.print(" ]");
        }
        return "";
    }
}
