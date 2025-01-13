package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {
    public static void main(String[] args) {
        MangaByIdCompator mangaByIdCompator = new MangaByIdCompator();

        //Com se faz para realizar uma busca numa lista que possui o compare custominado
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(5L,"Boruto", 35.25));
        mangas.add(new Manga(1L,"Nano Machine",9.5));
        mangas.add(new Manga(3L, "God Asura", 12.99));
        mangas.add(new Manga(6L,"Attack on titan",25.99));
        mangas.add(new Manga(10L,"martial machine", 20.00));

        //Collections.sort(mangas);
        mangas.sort(mangaByIdCompator);

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Manga mangaToSearch = new Manga(3L, "God Asura", 12.99);
        System.out.println(Collections.binarySearch(mangas,mangaToSearch, mangaByIdCompator));
        //binarySearch também serve para arrays é a mesma regra se aplica

    }//main
}//class
/*



 */