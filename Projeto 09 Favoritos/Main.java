import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.addContato("eva", Arrays.asList(new Fone("oio", 8585), new Fone("cla", 9999)));
        agenda.addContato("ana", Arrays.asList(new Fone("Tim", 3434)));
        agenda.addContato("bia", Arrays.asList(new Fone("viv", 5454)));
        agenda.addContato("ana", Arrays.asList(new Fone("casa", 4567), new Fone("oio", 8754)));
        agenda.addContato("rui", Arrays.asList(new Fone("casa", 3233)));
        agenda.addContato("zac", Arrays.asList(new Fone("fixo", 3131)));
        System.out.println(agenda);

        agenda.bookmark("eva");
        agenda.bookmark("ana");
        agenda.bookmark("ana");
        agenda.bookmark("zac");
        agenda.bookmark("rex");

        agenda.getBookmarks();

        agenda.rmContato("zac");
        System.out.println(agenda);

        agenda.unBookmark("ana");
        agenda.getBookmarks();

        System.out.println(agenda);
    }
}
