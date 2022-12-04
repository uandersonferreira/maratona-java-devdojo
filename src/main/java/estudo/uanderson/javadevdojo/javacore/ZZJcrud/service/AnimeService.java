package estudo.uanderson.javadevdojo.javacore.ZZJcrud.service;

import estudo.uanderson.javadevdojo.javacore.ZZJcrud.domain.Producer;
import estudo.uanderson.javadevdojo.javacore.ZZJcrud.domain.Anime;
import estudo.uanderson.javadevdojo.javacore.ZZJcrud.repository.AnimeRepository;

import java.util.Optional;
import java.util.Scanner;


public class AnimeService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op){
        switch (op) {
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
        }

    }


    private static void findByName(){
        System.out.print("Type the name or empty to all: ");
        String name = SCANNER.nextLine();

       AnimeRepository.findByName(name)
               .forEach(p -> System.out.printf("[%d] - %s %d %s%n", p.getId(), p.getName(), p.getEpisodes(), p.getProducer().getName()));

    }//method

    private static void delete(){
        findByName();
        System.out.println("Type the id of the anime you want to delete");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? Y/N ");
        String choice = SCANNER.nextLine();
        if (choice.equalsIgnoreCase("Y")){//ou (choice.toUpperCase().startsWith("S")
            AnimeRepository.delete(id);
        }

    }  //method

    private static void save(){
        System.out.printf("Type the name of the anime: ");
        String name = SCANNER.nextLine();
        System.out.print("Type the number of episodes: ");
        int episodes = Integer.parseInt(SCANNER.nextLine());
        System.out.print("Type the ID of producer: ");
        Integer producerId = Integer.parseInt(SCANNER.nextLine());
        Producer producer = Producer.builder()
                .id(producerId)
                .build();

        Anime anime = Anime.builder()
                .episodes(episodes)
                .name(name)
                .producer(producer)
                .build();

        AnimeRepository.save(anime);

    }

    private static void update(){
        findByName();
        System.out.println("Type the id of the object tou want to update");
        Optional<Anime> animeOptional = AnimeRepository.findById(Integer.parseInt(SCANNER.nextLine()));
        if (animeOptional.isEmpty()){
            System.out.println("Anime not found!");
            return;//evita um java.util.NoSuchElementException: No value present
        }

        Anime animeFromDb = animeOptional.get();
        System.out.println("Anime found: "+animeFromDb);
        System.out.println("Type the new name or enter to keep the same ");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? animeFromDb.getName() : name;//se for vazio pega o mesmo nome salvo na base de dados, senão salva com o novo nome

        System.out.println("Type the new number of episodes: ");
        int episodes =Integer.parseInt(SCANNER.nextLine());

        Anime animeToUpdate = Anime.builder()
                .id(animeFromDb.getId())
                .episodes(episodes)
                .producer(animeFromDb.getProducer())
                .name(name)
                .build();

        AnimeRepository.update(animeToUpdate);
    }



}//class
