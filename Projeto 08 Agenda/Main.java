import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.addContato("eva", Arrays.asList(new Fone("oio", "8585"), new Fone("cla", "9999")));
        agenda.addContato("ana", Arrays.asList(new Fone("Tim", "3434")));
        agenda.addContato("bia", Arrays.asList(new Fone("viv", "5454")));
        agenda.addContato("jao", Arrays.asList(new Fone("cas", "4567"), new Fone("oio", "8754")));

        System.out.println(agenda);

        agenda.removeContato("bia");
        System.out.println(agenda);

        agenda.addContato("ava", Arrays.asList(new Fone("viv", "5454")));
        agenda.addContato("rui", Arrays.asList(new Fone("viv", "2222"),new Fone("oio", "9991")));
        agenda.addContato("zac", Arrays.asList(new Fone("rec", "3131")));

        for(Contato contato : agenda.search("va")){
            System.out.println(contato);
        }

        for(Contato contato : agenda.search("999")){
            System.out.println(contato);
        }
    }
}
