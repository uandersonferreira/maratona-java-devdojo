package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Consumidor;
import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {
    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("Uanderson");
        Consumidor consumidor2 = new Consumidor("Willian Suane");

        Manga mangaBoruto = new Manga(5L, "Boruto", 35.25);
        Manga mangaNanoMachine = new Manga(1L, "Nano Machine", 9.5);
        Manga mangaGodAsura = new Manga(3L, "God Asura", 12.99);
        Manga mangaAttackOnTitan = new Manga(6L, "Attack on titan", 25.99);
        Manga mangaMartialMachine = new Manga(10L, "martial machine", 20.00);

        Map<Consumidor, Manga> consumidorManga = new HashMap<>();

        consumidorManga.put(consumidor1, mangaBoruto);
        consumidorManga.put(consumidor2, mangaAttackOnTitan);

        for (Map.Entry<Consumidor, Manga> entry : consumidorManga.entrySet()) {
            System.out.println("Key: "+entry.getKey().getNome()+" -> "+"Value: "+entry.getValue().getNomeManga());
        }


    }//main
}//class
