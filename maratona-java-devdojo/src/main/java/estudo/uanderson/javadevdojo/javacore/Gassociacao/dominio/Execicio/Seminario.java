package estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Execicio;

public class Seminario {
    private String titulo;
    private Aluno[] alunos; //-UM SEMINÁRIO PODERÁ TER NENHUM OU VÁRIOS ALUNOS ( Agregação unidirecional)
    private Local local;//   -UM SEMINÁRIO DEVE TER UM LOCAL ( Associação unidirecional)



    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Seminario(String titulo, Aluno[] alunos) {
        this.titulo = titulo;
        this.alunos = alunos;
    }

    public Seminario(String titulo, Aluno[] alunos, Local local) {
        this.titulo = titulo;
        this.alunos = alunos;
        this.local = local;
    }

    public Aluno[] getAlunos() {
        return alunos;
    }

    public void setAlunos(Aluno[] alunos) {
        this.alunos = alunos;
    }

    public String getTitulo() {
        return titulo;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }
}
