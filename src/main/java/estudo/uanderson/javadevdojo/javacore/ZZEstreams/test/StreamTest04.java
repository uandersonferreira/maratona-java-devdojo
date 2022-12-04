package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamTest04 {
    public static void main(String[] args) {
        List< List<String> > devdojo = new ArrayList<>();
        List<String> graphicDesigners = List.of("Gisele", "Maria Batista", "Pedro");
        List<String> developers = List.of("Uanderson", "Adriela ", "Jane kelly");
        List<String> students = List.of("Édipo", "Carlos Eduardo", "Sara Cristina","Adailton");

        devdojo.add(graphicDesigners);
        devdojo.add(developers);
        devdojo.add(students);

        int i = 1;
        for (List<String> people : devdojo) {
            for (String person : people) {
                System.out.println(i+"° "+person);
                i++;
            }
        }//for
        System.out.println("------------------");

        devdojo.stream().flatMap(Collection::stream).forEach(System.out::println);




    }//main
}//class
/*
Em Java 8, podemos usar o flatMappara converter o fluxo de 2 níveis
 acima em um nível de fluxo ou uma matriz 2d em uma matriz 1d.
 Ex: List< List<String> > para List<String>

 Basicamente usamos quando temos que acessar elementos de uma
  lista, que está contida dentro de outra lista. Como o exemplo acima.

 Referência: https://mkyong.com/java8/java-8-flatmap-example/#what-is-flatmap
 */
