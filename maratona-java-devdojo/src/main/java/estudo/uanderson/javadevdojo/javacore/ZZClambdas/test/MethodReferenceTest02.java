package estudo.uanderson.javadevdojo.javacore.ZZClambdas.test;
//REFERENCE TO AN INSTANCE METHOD OF A PARTICULAR OBJECT

import estudo.uanderson.javadevdojo.javacore.ZZClambdas.domain.Anime;
import estudo.uanderson.javadevdojo.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceTest02 {
    public static void main(String[] args) {
        AnimeComparators animeComparators = new AnimeComparators();
        List<Anime> animeList = new ArrayList<>( List.of(new Anime("Berserl", 43),
                new Anime("Naruto Shippuden", 550),
                new Anime("Tokyo ghoul", 48)
        ));//animeList

        //animeList.sort((a1,a2) -> animeComparators.compareByEpisodesNonStatic(a1,a2)); lambda normal
        animeList.sort(animeComparators::compareByEpisodesNonStatic);//lambda através/com um metodo de referência.
        System.out.println(animeList);


    }
}
