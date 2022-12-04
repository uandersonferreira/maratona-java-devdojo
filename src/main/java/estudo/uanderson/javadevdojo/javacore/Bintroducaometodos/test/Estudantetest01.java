package estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.test;

import estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.dominio.Estudante01;
import estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.dominio.ImpressoraEstudante;

public class Estudantetest01 {
    public static void main(String[] args) {
        Estudante01 estudante01 = new Estudante01();
        Estudante01 estudante02 = new Estudante01();
        ImpressoraEstudante impressora = new ImpressoraEstudante();


        estudante01.nome = "Uanderson";
        estudante01.idade = 19;
        estudante01.sexo = "M";

        System.out.println("------------");

        estudante01.nome = "Maria";
        estudante01.idade = 42;
        estudante01.sexo = "F";

        System.out.println(estudante01.nome);
        System.out.println(estudante01.idade);
        System.out.println(estudante01.sexo);

        System.out.println("------------");

        System.out.println(estudante02.nome);
        System.out.println(estudante02.idade);
        System.out.println(estudante02.sexo);

        impressora.imprimeEstudante(estudante01);
        impressora.imprimeEstudante(estudante02);

        /*
        Quando passamos objetos como paramentros, estamos passando a
        referencia do objeto em memória.
        Deve-se tomar cuidado ao passar a referência de um objeto, pois
        se caso acontecer algumas alteração nele, as alterações ocorreram em todos os locais
        que o chamam.
         */





    }
}
