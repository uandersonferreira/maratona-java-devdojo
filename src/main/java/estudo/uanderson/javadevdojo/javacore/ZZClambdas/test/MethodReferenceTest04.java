package estudo.uanderson.javadevdojo.javacore.ZZClambdas.test;

import estudo.uanderson.javadevdojo.javacore.ZZClambdas.domain.Anime;
import estudo.uanderson.javadevdojo.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

//Reference to a constructor
public class MethodReferenceTest04 {
    public static void main(String[] args) {
        Supplier<AnimeComparators> newAnimeComparatos = () -> new AnimeComparators();//o objeto não está sendo criado aqui,
                                                                        // somente estamos passando ele para a interface

        AnimeComparators animeComparators = newAnimeComparatos.get();//aqui está sendo criado/pegado(retornado do method
                                                                     // da Interface Supplier) o objeto de anime

        List<Anime> animeList = new ArrayList<>( List.of(new Anime("Berserl", 43),
                new Anime("Naruto Shippuden", 550),
                new Anime("Tokyo ghoul", 48)
        ));//animeList

        animeList.sort(animeComparators::compareByEpisodesNonStatic);
        System.out.println(animeList);
        System.out.println("--------------------------------");

        //EXEMPLO COM UM CONSTRUTOR QUE RECEBE PARAMETROS
        BiFunction<String, Integer, Anime> animeBiFunction = (title, episodes) -> new Anime(title,episodes);
        BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new;

        System.out.println(animeBiFunction2.apply("Super Campeões", 36));//apply se encarrega de criar o novo anime

        for (Anime anime : animeList) {
            System.out.println(anime);
        }


    }//main
}//class

/*

Type Parameters: BiFunction
    T - the type of the first argument to the function
    U - the type of the second argument to the function
    R - the type of the result of the function

 */
