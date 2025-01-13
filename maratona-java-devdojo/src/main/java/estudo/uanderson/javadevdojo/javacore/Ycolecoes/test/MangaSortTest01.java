package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class MangaByIdCompator implements Comparator<Manga>{

    @Override
    public int compare(Manga manga1, Manga manga2) {
        return manga1.getId().compareTo(manga2.getId());
    }
}

public class MangaSortTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(5L,"Boruto", 35.25));
        mangas.add(new Manga(1L,"Nano Machine",9.5));
        mangas.add(new Manga(3L, "God Asura", 12.99));
        mangas.add(new Manga(6L,"Attack on titan",25.99));
        mangas.add(new Manga(10L,"martial machine", 20.00));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("----------------ORDENANDO POR NOME------------");

        Collections.sort(mangas);
        for (Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("----------------ORDENANDO POR ID ATRAVÉS DA CLASS CRIADA PRO COMPARE----------");

       // Collections.sort(mangas, new MangaByIdCompator());
        mangas.sort(new MangaByIdCompator());//method proprio do objeto
        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        //PAREI AULA 172

    }//main
}
