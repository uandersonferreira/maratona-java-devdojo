package estudo.uanderson.javadevdojo.javacore.ZZJcrud.service;

import estudo.uanderson.javadevdojo.javacore.ZZJcrud.domain.Producer;
import estudo.uanderson.javadevdojo.javacore.ZZJcrud.repository.ProducerRepository;

import java.util.Optional;
import java.util.Scanner;


public class ProducerService {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void menu(int op){
        switch (op){
            case 1 -> findByName();
            case 2 -> delete();
            case 3 -> save();
            case 4 -> update();
            default -> throw new IllegalArgumentException("Not a valid option");
        }
    }


    private static void findByName(){
        System.out.print("Type the name or empty to all: ");
        String name = SCANNER.nextLine();

       ProducerRepository.findByName(name)
               .forEach(p -> System.out.printf("[%d] - %s%n", p.getId(), p.getName()));

    }//method

    private static void delete(){
        findByName();
        System.out.println("Type the id of the producer you want to delete");
        int id = Integer.parseInt(SCANNER.nextLine());
        System.out.println("Are you sure? Y/N ");
        String choice = SCANNER.nextLine();
        if (choice.equalsIgnoreCase("Y")){//ou (choice.toUpperCase().startsWith("S")
            ProducerRepository.delete(id);
        }

    }  //method

    private static void save(){
        System.out.println("Type the name of the producer");
        String name = SCANNER.nextLine();
        Producer producer = Producer.builder()
                .name(name)
                .build();

        ProducerRepository.save(producer);

    }

    private static void update(){
        findByName();
        System.out.println("Type the id of the object tou want to update");
        Optional<Producer> producerOptional = ProducerRepository.findById(Integer.parseInt(SCANNER.nextLine()));
        if (producerOptional.isEmpty()){
            System.out.println("Producer not found!");
            return;//evita um java.util.NoSuchElementException: No value present
        }

        Producer producerFromDb = producerOptional.get();
        System.out.println("Producer found: "+producerFromDb);
        System.out.println("Type the new name or enter to keep the same ");
        String name = SCANNER.nextLine();
        name = name.isEmpty() ? producerFromDb.getName() : name;//se for vazio pega o mesmo nome salvo na base de dados, senão salva com o novo nome

        Producer producerToUpdate = Producer.builder()
                .id(producerFromDb.getId())
                .name(name)
                .build();

        ProducerRepository.update(producerToUpdate);
    }



}//class
/*
  --- ANTES DA REFATORAÇÃO --
    private static void findByName(){
        System.out.print("Type the name or empty to all: ");
        String name = SCANNER.nextLine();

        List<Producer> producers = ProducerRepository.findByName(name);
        for (int i = 0; i < producers.size() ; i++) {
            Producer producer = producers.get(i);
            System.out.printf("[%d] - ID:%d | %s%n", i, producer.getId(), producer.getName());
        }
    }//method


- Por se trabalhar com objetos imutaveis ao realizar um
update necessita-se criar um novo objeto que irá receber
os novos dados é realizar a atuazlização na base de dados.

 */