package estudo.uanderson.javadevdojo.javacore.Gassociacao.teste;

import estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Execicio.Aluno;
import estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Execicio.Local;
import estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Execicio.Professor;
import estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Execicio.Seminario;

public class ExemploAssociacao {
    /*
    CRIE UM SISTEMA QUE GERENCIE SEMINÁRIOS

   O SISTEMA DEVERÁ CADASTRAR SEMINÁRIOS, ESTUDANTES, PROFESSORES E LOCAL ONDE SERÁ REALIZADO

   -UM ALUNO PODERÁ ESTAR EM APENAS UM SEMINÁRIO (associação unidirecional )
   -UM SEMINÁRIO PODERÁ TER NENHUM OU VÁRIOS ALUNOS ( Agregação unidirecional)
   -UM PROFESSOR PODERÁ MINISTRAR VÁRIOS SEMINÁRIOS
   -UM SEMINÁRIO DEVE TER UM LOCAL

   **CAMPOS BÁSICOS (SEM RELACIONAMENTO)

   -SEMINÁRIO: TITULO
   -ALUNO: NOME E IDADE
   -PROFESSOR: NOME, ESPECIALIDADE
   -LOCAL: ENDEREÇO
     */

    public static void main(String[] args) {
        Local local = new Local("Ruas das Palmeiras");
        Aluno aluno = new Aluno("Uanderson",19);
        Professor professor = new Professor("Kakashi","Professor");

        Aluno alunosParaSeminario[] = {aluno};

        Seminario seminario = new Seminario("História do Brasil",alunosParaSeminario,local);

        Seminario[] seminariosDisponiveis = {seminario};// vetor para guardar os seminários criados.

        professor.setSeminarios(seminariosDisponiveis);//add um professor ao seminário.

        professor.imprime();
    }
}
