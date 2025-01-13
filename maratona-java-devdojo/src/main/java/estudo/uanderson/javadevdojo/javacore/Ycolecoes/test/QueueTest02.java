package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Manga;

import java.util.PriorityQueue;

public class QueueTest02 {
    public static void main(String[] args) {                   //Definido qual a ordem que será sera feita a ordenação dos elementos
        PriorityQueue<Manga> mangasQueue = new PriorityQueue<>(new MangaPrecoComparator().reversed());//reversed para definir a ordem contrário do que foi definido no compare.

        mangasQueue.add(new Manga(5L,"Boruto", 35, 0));
        mangasQueue.add(new Manga(1L,"Nano Machine",9.5,20));
        mangasQueue.add(new Manga(3L, "God Asura", 12.99,15));
        mangasQueue.add(new Manga(6L,"Attack on titan",25.99,5));
        mangasQueue.add(new Manga(10L,"martial machine", 19.00,0));
        mangasQueue.add(new Manga(11L,"Eleceed", 20.00,0));

        while (!mangasQueue.isEmpty()){
            System.out.println(mangasQueue.poll());
        }

    }//main
}//class

/*
Ao tentar add um objeto cuja class, não implementa o
comparable irá gerar uma Exception "ClassCastException".
Ex:
 Consumidor consumidor = new Consumidor("ua");
        PriorityQueue<Consumidor> consumidorQueue = new PriorityQueue<>();
        consumidorQueue.add(consumidor);



 */
