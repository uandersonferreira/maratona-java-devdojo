package estudo.uanderson.javadevdojo.javacore.Zgenerics.test;

import java.util.ArrayList;
import java.util.List;

public class WildcardTest02 {
    public static void main(String[] args) {
        List<Cachorro> cachorros = List.of(new Cachorro(), new Cachorro());
        List<Gato> gatos = List.of(new Gato(), new Gato());

        printConsulta(cachorros);

        List<Animal> animals = new ArrayList<>();
        printConsultaAnimal(animals);



    }//main
    // Type erasure -> WildCard == ?
    private static void printConsulta(List<? extends Animal> animals){
        for (Animal animal : animals) {
            animal.consulta();
        }
    }//printConsulta

    private static void printConsultaAnimal(List<? super Animal> animals){
       animals.add(new Cachorro());
       animals.add(new Cachorro());

    }//printConsultaAnimal


}//class
   /*
        1° Ao utilizar o WildCard ( ? ), perdemos a possibilidade de adicionar novos elementos a lista,
        devido a linha de herança e do poliformismo.

        2° Ao utilizar o Wildcard, para informar que aceitamos um objeto de um tipo mais generico
        podemos utilizar somente a palavra reservada "extends" idependenete ser
        uma classe ou Interface:
         - extends

        É necessário para corrigir o erro de compilação qaundo se usa Listas,
        que contém elementos com um graus de heranças diferentes, que precisam
        passar no TESTE É UM.


         -super


  */