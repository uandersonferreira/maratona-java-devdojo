package estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.test;

import estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.dominio.Funcionario;

public class FuncionarioTeste01 {
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();

        funcionario.setNome( "Uanderson");
        funcionario.setIdade(19);
        funcionario.setSalarios( new double[]{1130,950,1200});

        funcionario.imprimeFuncionario();
        funcionario.mediaFuncionario();



    }//main
}//class
