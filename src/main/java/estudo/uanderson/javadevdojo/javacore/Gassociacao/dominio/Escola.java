package estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio;

import estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Execicio.Professor;

/*
 1 escola tem vários professores(1 pra *). unidirecional
 AGREGAÇÃO
 */
public class Escola {
    private String nome;
    private Professor[] professores;

    public Escola(String nome) {
        this.nome = nome;
    }//construtor

    public Escola(String nome, Professor[] professores) {
        this.nome = nome;
        this.professores = professores;
    }////construtor

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor[] getProfessores() {
        return professores;
    }

    public void setProfessores(Professor[] professores) {
        this.professores = professores;
    }

    public void imprime(){
        System.out.println("Escola: "+this.nome);
        if (professores == null){
            return;
        }

        for (Professor professor : professores) {
            System.out.println("Professor(es): "+professor.getNome());
        }
        System.out.println("---------------------------------");


    }//imprime
}//class
