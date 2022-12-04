package estudo.uanderson.javadevdojo.javacore.ZZJcrud.test;

import estudo.uanderson.javadevdojo.javacore.ZZJcrud.service.AnimeService;
import estudo.uanderson.javadevdojo.javacore.ZZJcrud.service.ProducerService;

import java.util.Scanner;

public class CrudTest01 {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        int op;
        while (true){
            menu();
            op = Integer.parseInt(SCANNER.nextLine());
            if (op == 0) break;

                switch (op){
                    case 1 -> {
                        while (true) {
                            try {
                                producerMenu();
                                op = Integer.parseInt(SCANNER.nextLine());
                                if (op == 9) break;
                                ProducerService.menu(op);
                            } catch (IllegalArgumentException e) {
                                System.out.println("Option Invalid, tente novamente!");
                            }
                        }//while interno

                    }
                    case 2 ->{
                        while (true) {
                                animeMenu();
                                op = Integer.parseInt(SCANNER.nextLine());
                                if (op == 9) break;
                                AnimeService.menu(op);
                                if(op != 1 |op != 2 |op != 3  |op != 4 ){
                                     System.out.println("Option Invalid, tente Novamente!!");
                                }
                        }//while interno
                    }
                }
        }//while


    }//main

    private static void menu(){
        System.out.println("Type the Number of your operation");
        System.out.println("  1 - Producer");
        System.out.println("  2 - Anime");
        System.out.println("  0 - Exit");
        System.out.print("option:  ");
    }
    private static void producerMenu(){
        System.out.println("Type the Number of your operation");
        System.out.println("  1 - Search for producer");
        System.out.println("  2 - Delete producer");
        System.out.println("  3 - Save producer");
        System.out.println("  4 - Update producer");
        System.out.println("  9 - Go Back");
        System.out.print("option:  ");

    }

    private static void animeMenu(){
        System.out.println("Type the Number of your operation");
        System.out.println("  1 - Search for anime");
        System.out.println("  2 - Delete anime");
        System.out.println("  3 - Save anime");
        System.out.println("  4 - Update anime");
        System.out.println("  9 - Go Back");
        System.out.print("option:  ");

    }
}//class
