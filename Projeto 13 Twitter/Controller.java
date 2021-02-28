import java.util.Map;
import java.util.TreeMap;

public class Controller {
    private Map<String, User> users;
    private Map<Integer, Tweet> tweets;
    private int nextTwId;

    public Controller() {
        this.users = new TreeMap<>();
        this.tweets = new TreeMap<>();
        this.nextTwId = 0;
    }

    public void sendTweet(String username, String msg) {
        Tweet tweet = new Tweet(this.nextTwId, username, msg);
        for(String id : this.users.keySet()) {
            if(id.equals(username)) {
                this.users.get(id).sendTweet(tweet);
                this.tweets.put(this.nextTwId, tweet);
                for(String idF : this.users.get(id).getFollowers().keySet()) {
                    this.users.get(id).getFollowers().get(idF).sendTweet(tweet);
                }
                this.nextTwId++;
            }
        }
    }

    public void addUser(String username) {
        for(String id : this.users.keySet()) {
            if(id.equals(username)) {
                System.out.println("fail: The user " + username + " allready exist.");
                return;
            }
        }

        this.users.put(username, new User(username));
    }

    public User getUser(String username) {
        for(String id : this.users.keySet()) {
            if(id.equals(username)) {
                return this.users.get(id);
            }
        }

        return null;
    }

    public Map<String, User> getUsers() {return this.users;}
    public Map<Integer, Tweet> getTweets() {return this.tweets;}
    public int getNextTwId() {return this.nextTwId;}
}
