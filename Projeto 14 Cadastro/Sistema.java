import java.util.Map;
import java.util.TreeMap;

public class Sistema {
    private Map<String, Aluno> alunos;
    private Map<String, Disciplina> disciplinas;

    public Sistema() {
        this.alunos = new TreeMap<>();
        this.disciplinas = new TreeMap<>();
    }

    public void addAluno(String idAluno) {
        for(String id : this.alunos.keySet()) {
            if(id.equals(idAluno)) {
                System.out.println("fail: Esse aluno ja existe.");
                return;
            }
        }

        Aluno aluno = new Aluno(idAluno);
        this.alunos.put(idAluno, aluno);
    }

    public void addDisciplina(String idDisciplina) {
        for(String id : this.disciplinas.keySet()) {
            if(id.equals(idDisciplina)) {
                System.out.println("fail: Essa disciplina ja existe.");
                return;
            }
        }

        Disciplina disciplina = new Disciplina(idDisciplina);
        this.disciplinas.put(idDisciplina, disciplina);
    }

    public void matricular(String idAluno, String idDisciplina) {
        boolean aluVerif = false, disVerif = false;
        for(String idA : this.alunos.keySet()) {
            if(idA.equals(idAluno)) {
                aluVerif = true;
                break;
            }
        }

        for(String idD : this.disciplinas.keySet()) {
            if(idD.equals(idDisciplina)) {
                disVerif = true;
                break;
            }
        }

        if(aluVerif && disVerif) {
            this.alunos.get(idAluno).matricular(this.disciplinas.get(idDisciplina));
            this.disciplinas.get(idDisciplina).matricular(this.alunos.get(idAluno));
        } else {
            System.out.println("fail: Dado(s) incorreto(s).");
        }
    }

    public void desmatricular(String idAluno, String idDisciplina) {
        boolean aluVerif = false, disVerif = false;
        for(String idA : this.alunos.keySet()) {
            if(idA.equals(idAluno)) {
                aluVerif = true;
                break;
            }
        }

        for(String idD : this.disciplinas.keySet()) {
            if(idD.equals(idDisciplina)) {
                disVerif = true;
                break;
            }
        }

        if(aluVerif && disVerif) {
            this.alunos.get(idAluno).desmatricular(idDisciplina);
            this.disciplinas.get(idDisciplina).desmatricular(idAluno);
        } else {
            System.out.println("fail: Dado(s) incorreto(s).");
        }
    }

    public void rmAluno(String idAluno) {
        for(String idA : this.alunos.keySet()) {
            if(idA.equals(idAluno)) {
                this.alunos.remove(idAluno);

                for(String idD : this.disciplinas.keySet()) {
                    this.disciplinas.get(idD).desmatricular(idAluno);
                }
                return;
            }
        }

        System.out.println("fail: Esse aluno nao existe.");
    }


    public String toString() {
        System.out.println("alunos:");
        for(String idA : this.alunos.keySet()) {
            System.out.print(idA + "[ ");
            for(Disciplina alunoD : this.alunos.get(idA).getDisciplinas()) {
                System.out.print(alunoD.getId() + " ");
            }
            System.out.println("]");
        }

        System.out.println("disciplinas:");
        for(String idD : this.disciplinas.keySet()) {
            System.out.print(idD + "[ ");
            for(Aluno disciplinaA : this.disciplinas.get(idD).getAlunos()) {
                System.out.print(disciplinaA.getId() + " ");
            }
            System.out.println("]");
        }
        return "";
    }
}
