package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.List;

public class StreamTest08 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Eleceed", 2.55),
            new LightNovel("The Challegen", 3.00),
            new LightNovel("Unordinary", 10.00),
            new LightNovel("Nano Machine", 2.99),
            new LightNovel("Fullmetal Alchemist", 2.55),
            new LightNovel("Martial Peark", 3.98),
            new LightNovel("Martial Peark", 3.98),
            new LightNovel("Martial God Asura", 4.00)
    ));

    public static void main(String[] args) {
        lightNovels.stream()
                .map(LightNovel::getPrice)
                .filter(price -> price > 3)
                .reduce(Double::sum)
                .ifPresent(System.out::println);

        //Parando de deixar o java fazer o cast é retornando um tipo primitivo
        double sumDouble = lightNovels.stream()
                .mapToDouble(LightNovel::getPrice)
                .filter(price -> price > 3)
                .sum();

        System.out.println(sumDouble);


        // DoubleStream;
       // LongStream
        //IntStream


    }//main
}//class
