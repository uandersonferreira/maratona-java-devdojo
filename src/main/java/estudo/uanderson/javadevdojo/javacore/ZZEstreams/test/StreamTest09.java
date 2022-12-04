package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1,50)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));
        System.out.println();

        IntStream.range(1,50)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.print(n + " "));

        //Strings
        System.out.println();
        Stream.of("Nada é ", "Impossível ","se você tenta")
                .map(String::toUpperCase)
                .forEach(System.out::print);//s -> System.out.print(s)

        //Arrays
        System.out.println();
        int num[] = {1,2,3,4,5,6};
        Arrays.stream(num)
                .average()
                .ifPresent(s -> System.out.print("average(média): "+s));//System.out::println
        
        //Files
        System.out.println();
        try (Stream<String> stringStreamLines = Files.lines(Paths.get("file.txt"))) {
            stringStreamLines
                    .filter(lines -> lines.contains("Java"))
                    .forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }




    }//main
}//class
