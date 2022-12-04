package estudo.uanderson.javadevdojo.javacore.ZZDoptional.repositorio;

import estudo.uanderson.javadevdojo.javacore.ZZDoptional.domain.Manga;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class MangaRepository {
    private static List<Manga> mangaList = new ArrayList<>(List.of(
            new Manga(1, "Boku no Hero",60),
            new Manga(2,"Overlord", 36),
            new Manga(3,"Naruto Shippuden", 501)
    ));

    public static Optional<Manga> findByTitle(String title){
        return findBy(manga -> manga.getTitle().equals(title));
//        Manga found = null;
//        for (Manga manga : mangaList) {
//            if (manga.getTitle().equals(title)){
//                found = manga;
//            }
//        }
//        return  Optional.ofNullable(found);
    }//findByTitle

    public static Optional<Manga> findById(Integer idManga){
        return findBy(manga -> manga.getId().equals(idManga));

        //SIMPLIFICAMOS TUDO EM APENAS UMA LINHA
//        Manga found = null;
//        for (Manga manga : mangaList) {
//            if (manga.getId().equals(idManga)){
//                found = manga;
//            }
//        }
//        return  Optional.ofNullable(found);

    }//findById

    public static Optional<Manga> findBy(Predicate<Manga> predicateManga){
        Manga found = null;
        for (Manga manga : mangaList) {
            if (predicateManga.test(manga)){
                found = manga;
            }
        }
        return  Optional.ofNullable(found);
    }//findByTitle



}//class
