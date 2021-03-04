import java.util.Map;
import java.util.TreeMap;

public class WhatsappService {
    private Map<String, Chat> rep_chat;
    private Map<String, User> rep_user;

    public WhatsappService() {
        this.rep_chat = new TreeMap<>();
        this.rep_user = new TreeMap<>();
    }

    protected User getUser(String userId) {
        for(String id : this.rep_user.keySet()) {
            if(userId.equals(id)) {
                return this.rep_user.get(id);
            }
        }

        System.out.println("fail: esse usuario nao existe");
        return null;
    }

    protected Chat getChat(String chatId) {
        for(String id : this.rep_chat.keySet()) {
            if(chatId.equals(id)) {
                return this.rep_chat.get(id);
            }
        }

        System.out.println("fail: esse chat nao existe");
        return null;
    }

    protected boolean chatExiste(Chat chat) {
        return this.rep_chat.containsValue(chat);
    }

    protected boolean userExiste(User user) {
        return this.rep_user.containsValue(user);
    }

    public String getChatsUser(String userId) {
        for(String id : this.rep_user.keySet()) {
            if(id.equals(userId)) {
                System.out.print("[ ");
                for(String idMap : this.rep_user.get(id).getChats().keySet()) {
                    System.out.print(idMap + " ");
                }
                System.out.println("]");
                return "";
            }
        }
        return "fail: nao existe esse user";
    }

    public String getUsersChat(String chatId) {
        for(String id : this.rep_chat.keySet()) {
            if(id.equals(chatId)) {
                System.out.print("[ ");
                for(String idMap : this.rep_chat.get(id).getUsers().keySet()) {
                    System.out.print(idMap + " ");
                }
                System.out.println("]");
                return "";
            }
        }
        return "fail: nao existe esse user";
    }

    public String getNotifyUser(String userId) {
        for(String id : this.rep_user.keySet()) {
            if(id.equals(userId)) {
                System.out.print("[ ");
                for(Notify not : this.rep_user.get(id).getNotify()) {
                    System.out.print(not + " ");
                }
                System.out.println("]");
            }
        }

        return "fail: nao existe esse user.";
    }

    public void createChat(String userId, String chatId) {
        boolean userVerif = false;
        boolean chatVerif = false;
        for(String id : this.rep_user.keySet()) {
            if(id.equals(userId)) {
                userVerif = true;
                break;
            }
        }

        for(String id : this.rep_chat.keySet()) {
            if(id.equals(chatId)) {
                chatVerif = true;
                break;
            }
        }

        if(userVerif && !chatVerif) {
            Chat chat = new Chat(chatId);
            chat.addUserchat(this.rep_user.get(userId));
            this.rep_user.get(userId).addChat(chat);
            this.rep_chat.put(chatId, chat);
            
        } else {
            System.out.println("fail: dados incorretos.");
        }

    }

    public void addByInvite(String guessId, String invitedId, String chatId) {
        boolean guessVerif = false;
        boolean invitedVerif = false;
        boolean chatVerif = false;
        for(String id : this.rep_user.keySet()) {
            if(id.equals(guessId)) {
                guessVerif = true;
                break;
            }
        }

        for(String id : this.rep_user.keySet()) {
            if(id.equals(invitedId)) {
                invitedVerif = true;
                break;
            }
        }

        for(String id : this.rep_chat.keySet()) {
            if(id.equals(chatId)) {
                chatVerif = true;
                break;
            }
        }

        
        // verify guess is in chat
        // verify invited not in chat
        if(invitedVerif && guessVerif && !chatVerif) {
            if(this.rep_chat.get(chatId).hasUser(guessId) && !this.rep_chat.get(chatId).hasUser(invitedId)) {
                this.rep_chat.get(chatId).addUserchat(this.rep_user.get(invitedId));
                this.rep_user.get(invitedId).addChat(this.rep_chat.get(chatId));
            }
        } else {
            System.out.println("fail: dados incorretos.");
        }
    }

    public void createUser(String userId) {
        for(String id : this.rep_user.keySet()) {
            if(id.equals(userId)) {
                System.out.println("fail: Esse usuario ja existe.");
                return;
            }
        }

        this.rep_user.put(userId, new User(userId));
    }

    public String allUsers() {
        System.out.print("[ ");
        for(String id : this.rep_user.keySet()) {
            System.out.print(id + " ");
        }
        return "]";
    }

    public void removerUserChat(String userId, String chatId) {
        boolean userVerif = false;
        boolean chatVerif = false;

        for(String id : this.rep_user.keySet()) {
            if(id.equals(userId)) {
                userVerif = true;
                break;
            }
        }

        for(String id : this.rep_chat.keySet()) {
            if(id.equals(chatId)) {
                chatVerif = true;
                break;
            }
        }

        if(userVerif && chatVerif) {
            this.rep_chat.get(chatId).rmUserChat(this.rep_user.get(userId));
            this.rep_user.get(userId).rmChat(this.rep_chat.get(chatId));
        } else {
            System.out.println("fail: dados incorretos.");
        }
    }

    public void sendMessage(String userId, String chatId, String message) {
        boolean userVerif = false;
        boolean chatVerif = false;

        for(String id : this.rep_user.keySet()) {
            if(id.equals(userId)) {
                userVerif = true;
                break;
            }
        }

        for(String id : this.rep_chat.keySet()) {
            if(id.equals(chatId)) {
                chatVerif = true;
                break;
            }
        }
        
        if(userVerif && chatVerif) {
            if(this.rep_chat.get(chatId).hasUser(userId)) {
                this.rep_chat.get(chatId).deliverZap(this.rep_user.get(userId), message);
            }
        } else {
            System.out.println("fail: dados incorretos.");
        }

        
    }

    public String readMessageUserChat(String userId, String chatId) {
        boolean userVerif = false;
        boolean chatVerif = false;

        for(String id : this.rep_user.keySet()) {
            if(id.equals(userId)) {
                userVerif = true;
                break;
            }
        }

        for(String id : this.rep_chat.keySet()) {
            if(id.equals(chatId)) {
                chatVerif = true;
                break;
            }
        }
        
        if(userVerif && chatVerif) {
            if(this.rep_chat.get(chatId).hasUser(userId)) {
                this.rep_chat.get(chatId).getUnread(userId);
            }
        } else {
            System.out.println("fail: dados incorretos.");
        }
        return "";
    }
}
