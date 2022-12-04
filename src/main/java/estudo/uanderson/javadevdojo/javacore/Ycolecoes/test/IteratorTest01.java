package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Manga;

import java.util.ArrayList;
import java.util.List;

public class IteratorTest01 {
    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(5L,"Boruto", 35.25, 0));
        mangas.add(new Manga(1L,"Nano Machine",9.5,20));
        mangas.add(new Manga(3L, "God Asura", 12.99,15));
        mangas.add(new Manga(6L,"Attack on titan",25.99,5));
        mangas.add(new Manga(10L,"martial machine", 20.00,0));

//        Iterator<Manga> mangaIterator = mangas.iterator();
//        while (mangaIterator.hasNext()){//retorna true sempre que tiver um proximo elemento na lista
//            //Manga nextManga = mangaIterator.next();
//            if (mangaIterator.next().getQuantidade() == 0){
//                mangaIterator.remove();
//            }
//        }

        mangas.removeIf(manga -> manga.getQuantidade() == 0);//programação funcional
        for (Manga manga : mangas) {

            System.out.println(manga);
        }


    }//main
}//class
