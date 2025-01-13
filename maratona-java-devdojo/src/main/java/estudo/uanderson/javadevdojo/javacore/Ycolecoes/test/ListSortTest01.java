package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {
    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>();
        mangas.add("Boruto");
        mangas.add("Nano Machine");
        mangas.add("God Asura");
        mangas.add("Attack on titan");
        mangas.add("martial machine");

        Collections.sort(mangas);//Ordena os elementos da list por ordem alfabetica

        List<Double> dinheiros = new ArrayList<>();
        dinheiros.add(100.20);
        dinheiros.add(10.20);
        dinheiros.add(85.15);
        dinheiros.add(23.10);
        for (String mangaList : mangas) {
            System.out.println(mangaList);
        }
        System.out.println("---------------------");
        System.out.println("Antes: "+dinheiros);
        Collections.sort(dinheiros);//ordena do menor para o maior, em ordem crescente
        System.out.println("Após Ordenar: "+dinheiros);


    }//main
}
