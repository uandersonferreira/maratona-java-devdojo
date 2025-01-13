package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.Category;
import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.LightNovel;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest14 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Eleceed", 2.55,Category.FANTASY),
            new LightNovel("The Challegen", 3.00, Category.FANTASY),
            new LightNovel("Unordinary", 10.00, Category.DRAMA),
            new LightNovel("Nano Machine", 2.99, Category.FANTASY),
            new LightNovel("Fullmetal Alchemist", 2.55,Category.FANTASY),
            new LightNovel("Martial Peark", 3.98,Category.FANTASY),
            new LightNovel("Martial Peark", 3.98,Category.FANTASY),
            new LightNovel("Martial God Asura", 4.00,Category.FANTASY),
            new LightNovel("Monogatari", 5.00,Category.ROMANCE)
    ));

    public static void main(String[] args) {
      // contar por categoria
        Map<Category, Long> collect = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                         Collectors.counting()));
        for (Map.Entry<Category, Long> categoryLongEntry : collect.entrySet()) {
            System.out.println(categoryLongEntry.getKey()+" -> "+categoryLongEntry.getValue());
        }
        System.out.println();

        Map<Category, Optional<LightNovel>> collect2 = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.maxBy(Comparator.comparing((LightNovel::getPrice)))));

        for (Map.Entry<Category, Optional<LightNovel>> optionalEntry : collect2.entrySet()) {
            System.out.println(optionalEntry);
        }
        //Sem retornar um optional com groupingBy(), collectionAndThen(), Optional::get
        Map<Category, LightNovel> collect3 = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(LightNovel::getPrice)),
                                Optional::get)));
        System.out.println();
        for (Map.Entry<Category, LightNovel> lightNovelEntry : collect3.entrySet()) {
            System.out.println(lightNovelEntry);
        }
        //Sem retornar um optional com toMap/ Functional, BinaryOperator
        Map<Category, LightNovel> collect4 = lightNovels.stream()
                .collect(Collectors.toMap(LightNovel::getCategory,
                        Function.identity(),
                        BinaryOperator.maxBy(Comparator.comparing(LightNovel::getPrice))));
        System.out.println();
        for (Map.Entry<Category, LightNovel> lightNovelEntry : collect4.entrySet()) {
            System.out.println(lightNovelEntry);
        }


    }//main
}//class
