package estudo.uanderson.javadevdojo.javacore.ZZClambdas.test;

import estudo.uanderson.javadevdojo.javacore.ZZClambdas.domain.Anime;
import estudo.uanderson.javadevdojo.javacore.ZZClambdas.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;

public class MethosReferenceTest01 {
    //LAMBDAS + REFERÊNCIA A METODOS STATICOS

    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>( List.of(new Anime("Berserl", 43),
                new Anime("Naruto Shippuden", 550),
                new Anime("Tokyo ghoul", 48)
        ));//animeList

      animeList.sort((a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));
      animeList.sort((a1, a2) -> AnimeComparators.compareByTitle(a1, a2));
      animeList.sort(AnimeComparators::compareByTitle);//é possível pois so temos 1 chamada de method
      animeList.sort(AnimeComparators::compareByEpisodes);//é possível pois so temos 1 chamada de method


       int i=1;
        for (Anime anime : animeList) {
            System.out.println((i)+"° - "+anime);
            i += 1;
        }


    }//main
}

/*
Por estamos usando a class Collections é seu method sort,
precisamos que o objeto passado seja mutavel por isso usamos um ArrayList, senão irá gerar
o erro: "UnsupportedOperationException"

OBS:
-> Um objeto mutável é um objeto cujo estado pode ser modificado após sua criação.
-> Imutáveis são os objetos cujo o estado não podem ser mudados uma vez criados.

 */
