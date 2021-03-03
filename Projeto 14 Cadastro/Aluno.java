import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Aluno {
    private String id;
    private Map<String, Disciplina> m_disciplinas;

    public Aluno(String idAluno) {
        this.id = idAluno;
        this.m_disciplinas = new TreeMap<>();
    }

    public void matricular(Disciplina disciplina) {
        this.m_disciplinas.put(disciplina.getId(), disciplina);
    }

    public void desmatricular(String idDisciplina) {
        for(String id : this.m_disciplinas.keySet()) {
            if(id.equals(idDisciplina)) {
                this.m_disciplinas.remove(idDisciplina);
                return;
            }
        }
    }

    public List<Disciplina> getDisciplinas() {
        List<Disciplina> disciplinas = new ArrayList<>();

        for(String id : this.m_disciplinas.keySet()) {
            disciplinas.add(this.m_disciplinas.get(id));
        }
        return disciplinas;
    }

    public String getId() {return this.id;}
}
