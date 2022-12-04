package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {
    public static void main(String[] args) {
        List<String> nomes = new ArrayList<>();
        List<String> nomes2 = new ArrayList<>();
        nomes.add("Uanderson");
        nomes.add("DevDojo");
        nomes2.add("Ferreira");
        nomes2.add("Oliveira");
       // System.out.println("Removido: "+ nomes.remove("Ferreira"));

        nomes.addAll(nomes2);

        for (String nome : nomes) {
            System.out.println(nome);//.replace('e', '3')
        }


        System.out.println("------------------");
        for (int i = 0; i < nomes.size() ; i++) {
            System.out.println(nomes.get(i));
           // nomes.add("Oliveira");//cria um loop
            //tomar cuidado ao add algo dentro de um laço
        }

    }//main
}//class
/*
Uma List, nada mais é do que uma interface que  extends Collection.
As List trabalham com os wrappers(Objeto/class) dos tipos primitivos:
String, Integer, Double, Float...
 */