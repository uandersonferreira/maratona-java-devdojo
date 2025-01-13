package estudo.uanderson.javadevdojo.javacore.ZZHpadroesdeprojeto.test;

import estudo.uanderson.javadevdojo.javacore.ZZHpadroesdeprojeto.dominio.Person;

public class BuilderPatternTest01 {
    public static void main(String[] args) {
        Person build = Person.PersonBuilder
                .aPerson()
                .firstName("Uanderson")
                .lastName("Oliveira")
                .userName("Uanderson1")
                .email("uanderson@teste")
                .build();

        System.out.println(build);

    }//main
}//class
