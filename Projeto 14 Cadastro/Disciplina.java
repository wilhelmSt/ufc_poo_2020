import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Disciplina {
    private String id;
    private Map<String, Aluno> m_alunos;

    public Disciplina(String idDisciplina) {
        this.id = idDisciplina;
        this.m_alunos = new TreeMap<>();
    }

    public void matricular(Aluno aluno) {
        this.m_alunos.put(aluno.getId(), aluno);
    }

    public void desmatricular(String idAluno) {
        for(String id : this.m_alunos.keySet()) {
            if(id.equals(idAluno)) {
                this.m_alunos.remove(idAluno);
                return;
            }
        }
    }

    public List<Aluno> getAlunos() {
        List<Aluno> alunos = new ArrayList<>();
        
        for(String id : this.m_alunos.keySet()) {
            alunos.add(this.m_alunos.get(id));
        }
        return alunos;
    }
    
    public String getId() {return this.id;}

}
