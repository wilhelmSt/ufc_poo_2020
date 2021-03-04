public class Notify {
    public String chatId;
    public int unreadCount;

    public Notify(String id) {
        this.chatId = id;
        this.unreadCount = 0;
    }

    public String getId() {return this.chatId;}
    public int getUnreadCount() {return this.unreadCount;}

    public void addCount() {
        this.unreadCount++;
    }

    public void rmNotify() {
        this.unreadCount = 0;
    }

    public String toString() {
        return this.chatId + "(" + this.unreadCount + ")";
    }
}
