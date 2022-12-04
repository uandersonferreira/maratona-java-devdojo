package estudo.uanderson.javadevdojo.javacore.ZZDoptional.test;

import estudo.uanderson.javadevdojo.javacore.ZZDoptional.domain.Manga;
import estudo.uanderson.javadevdojo.javacore.ZZDoptional.repositorio.MangaRepository;

import java.util.Optional;

public class OptionalTest02 {
    public static void main(String[] args) {
        Optional<Manga> mangaByTitle = MangaRepository.findByTitle("Boku no Hero");
        mangaByTitle.ifPresent(manga -> manga.setTitle("Boku no Hero 2"));
        System.out.println("ifPresent: "+mangaByTitle);

        Manga  mangaById = MangaRepository.findById(2).orElseThrow(IllegalArgumentException::new);
        System.out.println("orElseThrow: "+mangaById);

        Manga newManga = MangaRepository.findByTitle("Boruto").orElse(new Manga(3, "Boruto", 100)); // ou
        Manga newManga2 = MangaRepository.findByTitle("Boruto").orElseGet( () -> new Manga(3, "Boruto", 100));
        System.out.println("orElse: "+newManga);
        System.out.println("orElseGet + Lambda: "+newManga2);


    }//main
}//class
