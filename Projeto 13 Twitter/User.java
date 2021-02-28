import java.util.Map;
import java.util.TreeMap;

public class User {
    private String username;
    private Map<String, User> followers;
    private Map<String, User> following;
    private Map<Integer, Tweet> timeline;
    private int unreadCount;

    public User(String username) {
        this.username = username;
        this.followers = new TreeMap<>();
        this.following = new TreeMap<>();
        this.timeline = new TreeMap<>();
        this.unreadCount = 0;
    }

    public void follow(User user) {
        if(user.getUsername().equals(this.username)) {
            System.out.println("fail: You cannot follow youself.");
            return;
        }

        for(String id : this.following.keySet()) {
            if(id.equals(user.getUsername())) {
                System.out.println("fail: You all ready follow " + user.getUsername() + ".");
                return;
            }
        }

        this.following.put(user.getUsername(), user);
        user.followers.put(this.username, this);
    }

    public void unfollow(String user) {
        for(String id : this.following.keySet()) {
            if(id.equals(user)) {
                this.following.remove(user);
                this.following.get(id).followers.remove(this.username);
                return;
            }
        }

        System.out.println("fail: You dont follow " + user + ".");
    }

    public Tweet getTweet(int idTw) {
        for(int id : this.timeline.keySet()) {
            if(id == idTw) {
                Tweet tweet = this.timeline.get(id);
                return tweet;
            }
        }
        System.out.println("fail: There is none tweet with the id: " + idTw + ".");
        return null;
    }

    public void sendTweet(Tweet tweet) {
        this.timeline.put(tweet.getIdTw(), tweet);
        this.unreadCount++;
    }

    public String getUnread() {
        while(unreadCount > 0) {
            int index = this.timeline.size() - unreadCount - 1;
            System.out.println(this.timeline.get(index));
            unreadCount--;
        }
        this.unreadCount = 0;
        return "";
    }

    public String getTimeline() {
        for(int id : this.timeline.keySet()) {
            System.out.println(this.timeline.get(id));
        }
        this.unreadCount = 0;
        return "";
    }

    public String getUsername() {return this.username;}
    public Map<String, User> getFollowers() {return this.followers;}
    public void setUnreadCount(int unreadCount) {this.unreadCount = unreadCount;}
}
