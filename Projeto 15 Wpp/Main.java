public class Main {
    public static void main(String[] args) throws Exception {
        WhatsappService whatsapp = new WhatsappService();
        whatsapp.createUser("goku");
        whatsapp.createUser("sara");
        whatsapp.createUser("tina");
        System.out.println(whatsapp.allUsers());

        whatsapp.createChat("goku", "guerreiros");
        whatsapp.createChat("goku", "homens");
        whatsapp.createChat("sara", "familia");

        whatsapp.createChat("sara", "guerreiros");

        System.out.println(whatsapp.getChatsUser("goku"));
        System.out.println(whatsapp.getChatsUser("sara"));
        System.out.println(whatsapp.getChatsUser("tina"));

        whatsapp.addByInvite("goku", "sara", "guerreiros");
        whatsapp.addByInvite("sara", "tina", "guerreiros");
        whatsapp.addByInvite("tina", "goku", "familia");

        System.out.println(whatsapp.getChatsUser("sara"));
        //[guerreiros familia]
        System.out.println(whatsapp.getChatsUser("tina"));
        //[guerreiros]
        System.out.println(whatsapp.getChatsUser("goku"));
        //[guerreiros homens]
        System.out.println(whatsapp.getUsersChat("guerreiros"));
        //[goku sara tina]
        System.out.println(whatsapp.getUsersChat("familia"));
        //[sara]

        whatsapp.removerUserChat("sara", "guerreiros");
        System.out.println(whatsapp.getUsersChat("guerreiros"));
        //[goku tina]
        System.out.println(whatsapp.getChatsUser("sara"));
        //[familia]

        whatsapp.sendMessage("goku", "guerreiros", "oi, eu sou o goku");
        whatsapp.sendMessage("tina", "guerreiros", "oi goku");

        System.out.println(whatsapp.getNotifyUser("goku"));
        //[guerreiros(1) homens]
        System.out.println(whatsapp.getNotifyUser("tina"));
        //[guerreiros(1)]

        System.out.println(whatsapp.readMessageUserChat("goku", "guerreiros"));
        //[tina: oi goku]

        System.out.println(whatsapp.readMessageUserChat("tina", "guerreiros"));
        //[goku: oi, eu sou o goku]

        System.out.println(whatsapp.readMessageUserChat("sara", "guerreiros"));
        //fail: user sara nao esta no chat guerreiros

        whatsapp.sendMessage("goku", "guerreiros", "vamos sair tina?");
        whatsapp.sendMessage("tina", "guerreiros", "voce ta com fome goku?");
        whatsapp.sendMessage("goku", "guerreiros", "to com saudade de voce.");

        System.out.println(whatsapp.getNotifyUser("tina"));
        //[guerreiros(2)]
        System.out.println(whatsapp.getNotifyUser("goku"));
        //[guerreiros(1) homens]

        System.out.println(whatsapp.readMessageUserChat("goku", "guerreiros"));
        //[tina: voce ta com fome goku?]
        System.out.println(whatsapp.readMessageUserChat("tina", "guerreiros"));
        //[goku: vamos sair tina?]
        //[goku: to com saudade de voce.]
    }
}
