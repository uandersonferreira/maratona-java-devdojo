package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Manga;
import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneTestMarcaCompator implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone smartphone1, Smartphone smartphone2) {
        return smartphone1.getMarca().compareTo(smartphone2.getMarca());
    }
}

class MangaPrecoComparator implements Comparator<Manga>{

    @Override
    public int compare(Manga manga, Manga outroManga) {
        return Double.compare(manga.getPreco(), outroManga.getPreco());
    }
}
public class NavigableSetTest01 {
    public static void main(String[] args) {
        NavigableSet<Smartphone> navigableSet = new TreeSet<>(new SmartphoneTestMarcaCompator());
        Smartphone smartphone = new Smartphone("146450", "Nokia");
        navigableSet.add(smartphone);
        System.out.println(navigableSet);
        System.out.println("----------------------------");

        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());

        mangas.add(new Manga(5L,"Boruto", 35, 0));
        mangas.add(new Manga(1L,"Nano Machine",9.5,20));
        mangas.add(new Manga(3L, "God Asura", 12.99,15));
        mangas.add(new Manga(6L,"Attack on titan",25.99,5));
        mangas.add(new Manga(10L,"martial machine", 19.00,0));
        mangas.add(new Manga(11L,"Eleceed", 20.00,0));
        mangas.add(new Manga(11L,"Eleceed 2", 20.00,0));// TreeSet não utiliza o equals para realizar a chegagem, mas sim o que foi definido no compareTo, para definir se são obj == ou não.

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        //mangas.descendingSet() pega a lista do ultimo elemento para o primeiro

        Manga narutoShippunden = new Manga(18L, "Naruto Shippunden", 20, 55);

        //Methos utilizados para comparação
        //lower <  retorna o 1° elemento menor contido numa coleção em relação ao obj de comparação
        //floor <= retorna o 1° elemento menor ou igual contido numa coleção em relação ao obj de comparação
        //higher > retorna o 1° elemento maior contido numa coleção em relação ao obj de comparação
        //ceiling >=  retorna o 1° elemento maior ou igual contido numa coleção em relação ao obj de comparação

        System.out.println("---------------------------");
        System.out.println("Lower: "+mangas.lower(narutoShippunden));//dentro de mangas qual é o menos elemento comparado com o Obj Manga "narutoShippunden".
        System.out.println("Floor: "+mangas.floor(narutoShippunden));
        System.out.println("Higher: "+mangas.higher(narutoShippunden));
        System.out.println("Ceiling: "+mangas.ceiling(narutoShippunden));

        System.out.println("\nSize: "+mangas.size());
        System.out.println("PollFirst: "+mangas.pollFirst());//remove o 1° elemento da Lista (já ordenda)
        System.out.println("PollLast: "+mangas.pollLast());//remove o Último elemento da Lista (já ordenada)
        System.out.println("Size: "+mangas.size());
        System.out.println("----------------------------------");
        for (Manga manga : mangas) {
            System.out.println(manga);
        }


    }//main
}//class
/*
O treeSet não utiliza o equals para comparação, mas sim o compaTo.

Class com o nome "Tree" geralmente vão trabalhar diretamente
com uma lista ordenado, precisam do sort e que as class add a coleção
temham o compareble implementado. Caso contrário gera-se uma exception:
"ClassCastException".

E caso seja necessário seria a ordenação é preciso que,
uma class seja criada/ou implemente o Comparator<T>, e é necessário que
passe a sua intância para a coleção, conforme abaixo(**);

class SmartphoneTestMarcaCompator implements Comparator<Smartphone> {
    @Override
    public int compare(Smartphone smartphone1, Smartphone smartphone2) {
        return smartphone1.getMarca().compareTo(smartphone2.getMarca());
    }
}

**E que seja passado um objeto dessa class para a coleção TreeSet:
   NavigableSet<Smartphone> navigableSet = new TreeSet<>(new SmartphoneTestMarcaCompator());
 Ou
   NavigableSet<Smartphone> navigableSet = new TreeSet<>(new Smartphone());
   Mas neste caso em que a propria class implementa é necessário criar
   um construtor sobrecarregado.(Teste próprio, desconheco os riscos dessa implementação)





 */
