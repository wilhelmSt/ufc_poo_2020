import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        AgendaPlus agenda = new AgendaPlus();
        agenda.addContact(new ContactPlus("eva", Arrays.asList(new Fone("oio", 8585), new Fone("cla", 9999))));
        agenda.addContact(new ContactPlus("ana", Arrays.asList(new Fone("Tim", 3434))));
        agenda.addContact(new ContactPlus("bia", Arrays.asList(new Fone("viv", 5454))));
        agenda.addContact(new ContactPlus("ana", Arrays.asList(new Fone("cas", 4567), new Fone("oio", 8754))));
        System.out.println(agenda);

        agenda.star("eva");
        agenda.star("ana");
        agenda.star("ana");
        agenda.star("zac");
        agenda.star("rex");

        System.out.println(agenda);


        agenda.getBookmarks();

        agenda.rmContact("eva");
        System.out.println(agenda);

        agenda.unStar("ana");
        agenda.getBookmarks();
        System.out.println(agenda);
    }
}
