package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {
    public static void main(String[] args) {
        Queue<String> fila = new PriorityQueue<>();
        fila.add("C");
        fila.add("A");
        fila.add("B");

        for (String s : fila) {
            System.out.println(s);
        }

        System.out.println("----------");

        while (!fila.isEmpty()){
            System.out.println(fila.poll());
        }


    }//main
}//class
/*
Queue -> fila, primeiro a entrar é o primeiro a sair

Queue<String> -> a class definida entre < > necessita ter
uma implementação do Comparable. e casso não sej possível
implementar a class possui methos sobrecarregados que aceitam um c
comparator.
EX:    Queue<String> fila = new PriorityQueue<>();



 */