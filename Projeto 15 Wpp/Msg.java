public class Msg {
    public String userId;
    public String text;

    public Msg(String id, String txt) {
        this.userId = id;
        this.text = txt;
    } 

    public String toString() {
        return this.userId + " " + this.text;
    }
}
