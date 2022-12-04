package estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Execicio;

public class Professor {
    private String nome;
    private String especialidade;
    private Seminario seminarios[];//   -UM PROFESSOR PODERÁ MINISTRAR VÁRIOS SEMINÁRIOS( Agregação unidirecional)


    public Professor(String nome) {
        this.nome = nome;
    }//construtor

    public Professor(String nome, String especialidade, Seminario[] seminarios) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.seminarios = seminarios;
    }

    public Professor(String nome, String especialidade) {
        this.nome = nome;
        this.especialidade = especialidade;
    }


    public void imprime(){
        System.out.println("-----------");
        System.out.println("Professor: "+this.nome);
        if (this.seminarios == null) return;//se não tiver seminários retorna null e encerrar.

        System.out.println("## Seminários Cadastrados ##");

        for (Seminario seminario : this.seminarios) {
            System.out.println("Titulo: "+seminario.getTitulo());
            System.out.println("Local: "+seminario.getLocal().getEndereço());

            if (seminario.getAlunos() == null || seminario.getAlunos().length == 0) continue;//vai continuar a interar sobre o seminário
                                                        // mesmo se não tiver nenhum aluno. Nulo é diferente de vazio.
            System.out.println("** Alunos **");
            for (Aluno aluno : seminario.getAlunos()) {
                System.out.println("Aluno: "+aluno.getNome());
                System.out.println("Idade: "+aluno.getIdade());
            }


        }

    }



    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Seminario[] getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(Seminario[] seminarios) {
        this.seminarios = seminarios;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
