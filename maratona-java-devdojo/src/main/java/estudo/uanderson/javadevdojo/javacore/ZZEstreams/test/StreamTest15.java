package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.Category;
import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.LightNovel;
import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.Promotion;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest15 {
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
        Map<Category, DoubleSummaryStatistics> collect = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.summarizingDouble(LightNovel::getPrice)));

        for (Map.Entry<Category, DoubleSummaryStatistics> entry : collect.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();

        //-----------O toList Retorna os valores Duplicados(2 elemento com o mesmo valor = 2 valores retornados)-----------------------------
        Map<Category, List<Promotion>> collect2 = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                         Collectors.mapping(getPromotionFunction(),
                         Collectors.toList())));
        for (Map.Entry<Category, List<Promotion>> entry : collect2.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();
        //--------SEM OS VALORES DUPLICADOS (2 elemento com o mesmo valor = somente 1 valor retornado) ------
        Map<Category, Set<Promotion>> collect3 = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.mapping(getPromotionFunction(),
                                Collectors.toSet())));
        for (Map.Entry<Category, Set<Promotion>> entry : collect3.entrySet()) {
            System.out.println(entry);
        }
        System.out.println();
        //Retornando dentro de um LinkedHashSet(prioriza a ordem de inseção)
        // através do fabrincador de coleções toCollection;
        Map<Category, LinkedHashSet<Promotion>> collect04 = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.mapping(getPromotionFunction(),
                                Collectors.toCollection(LinkedHashSet::new))));
        for (Map.Entry<Category, LinkedHashSet<Promotion>> entry : collect04.entrySet()) {
            System.out.println(entry);
        }


    }//main

    private static Function<LightNovel, Promotion> getPromotionFunction() {
        return ln -> ln.getPrice() < 4 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }
}//class
