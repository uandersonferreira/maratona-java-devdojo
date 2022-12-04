package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Consumidor;
import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Manga;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest03 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("Uanderson");
        Consumidor consumidor2 = new Consumidor("Maria");

        Manga mangaBoruto = new Manga(5L, "Boruto", 35.25);
        Manga mangaNanoMachine = new Manga(1L, "Nano Machine", 9.5);
        Manga mangaGodAsura = new Manga(3L, "God Asura", 12.99);
        Manga mangaAttackOnTitan = new Manga(6L, "Attack on titan", 25.99);
        Manga mangaMartialMachine = new Manga(10L, "Martial machine", 20.00);

        List<Manga> mangaConsumidor1List = List.of(mangaBoruto, mangaNanoMachine,mangaGodAsura);
        List<Manga> mangaConsumidor2List = List.of(mangaAttackOnTitan, mangaMartialMachine);
        Map<Consumidor, List<Manga> > consumidorMangaMap = new HashMap<>();

        consumidorMangaMap.put(consumidor1, mangaConsumidor1List);
        consumidorMangaMap.put(consumidor2, mangaConsumidor2List);

        for (Map.Entry<Consumidor, List<Manga>> entry : consumidorMangaMap.entrySet()) {
            System.out.println("====="+entry.getKey().getNome().toUpperCase()+"=====");
            //Pelo o value ser uma lista foi criado um laço para poder ter um formatação melhor
            for (Manga manga : entry.getValue()) {
                System.out.println("  -> "+manga.getNomeManga());
            }

        }


    }//main
}//class
