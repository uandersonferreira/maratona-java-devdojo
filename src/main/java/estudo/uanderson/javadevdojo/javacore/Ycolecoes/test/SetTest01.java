package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Manga;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {
    public static void main(String[] args) {
        Set<Manga> mangas = new HashSet<>();

        mangas.add(new Manga(5L,"Boruto", 35.25, 0));
        mangas.add(new Manga(1L,"Nano Machine",9.5,20));
        mangas.add(new Manga(3L, "God Asura", 12.99,15));
        mangas.add(new Manga(6L,"Attack on titan",25.99,5));
        mangas.add(new Manga(10L,"martial machine", 20.00,0));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }//main
}//class
/*
Set -> Não permite elementos duplicados dentro da coleção
hasSet -> Coleção que permite apenas elementos únicos, onde
serão organizados/ordenados pelo has, portanto não é possível
determinar a posição/olocação de um elemento dentro da lista, pois são
realocados conforme seu hasCode gerado.

->No set Não existe index, porque não é indexado, sendo assim, não é
permitido pegar um elemento pelo seu index.
Ex:   mangas.get(0);

Sendo assim é necessário interar sobre a lista/coleção.

LinkedHashSet -> mantém a ordem de inserção ao contrário do HashSet.
 */
