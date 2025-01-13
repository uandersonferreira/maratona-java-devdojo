package estudo.uanderson.javadevdojo.javacore.ZZAclassesInternas.test;


import estudo.uanderson.javadevdojo.javacore.Zgenerics.domain.Barco;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AnonymousClassesTest02 {
    public static void main(String[] args) {
        List<Barco> barcoList = new ArrayList<>(List.of(new Barco("Lancha"), new Barco("Canoa")));

       barcoList.sort((o1,o2) -> o1.getNome().compareTo(o2.getNome())); //-> Sintaxe nova de lampadas
       barcoList.sort(Comparator.comparing(Barco::getNome));// sintaxe de lampada melhorada

        barcoList.sort(new Comparator<Barco>() {
            @Override
            public int compare(Barco barco, Barco t1) {
                return barco.getNome().compareTo(t1.getNome());
            }
        });
        System.out.println(barcoList);


    }
}//AnonymousClassesTest02

/*
Estamos criando uma sub-classe anonima(que não têm nome)
que está sobreescrendo o metodo walk(mudando o comportamento do metodo)

 */
