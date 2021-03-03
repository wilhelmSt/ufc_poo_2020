import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Sistema sys = new Sistema();
        for(String id : Arrays.asList("alice", "edson", "bruno"))
            sys.addAluno(id);
        for(String id : Arrays.asList("fup", "aps", "poo"))
            sys.addDisciplina(id);


        // CHECK
        for(String id : Arrays.asList("fup", "aps", "poo"))
            sys.matricular("bruno", id);
        for(String id : Arrays.asList("fup", "poo"))
            sys.matricular("alice", id);
        sys.matricular("edson", "fup");
        System.out.println(sys);

        // CHECK
        sys.desmatricular("bruno", "poo");
        sys.desmatricular("bruno", "aps");
        System.out.println(sys);

        // CHECK
        sys.rmAluno("alice");
        System.out.println(sys);

    }
}
