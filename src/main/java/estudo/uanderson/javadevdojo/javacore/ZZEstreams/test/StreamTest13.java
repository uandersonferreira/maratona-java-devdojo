package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.Category;
import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.LightNovel;
import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamTest13 {
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
        Map<Promotion, List<LightNovel>> collect = lightNovels.stream()
                .collect(Collectors.groupingBy(ln -> ln.getPrice() < 4 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE
                ));

        for (Map.Entry<Promotion, List<LightNovel>> promotionListEntry : collect.entrySet()) {
            System.out.println(promotionListEntry.getKey()+" -> "+promotionListEntry.getValue());
        }
        System.out.println();
        //Map<Category, Map<Promotion, List<LightNovel>>>
        //ctrl + alt + m  para refatorar o código

        Map<Category, Map<Promotion, List<LightNovel>>>  collect2 = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.groupingBy(getPromotionFunction()
                        )));

        for (Map.Entry<Category, Map<Promotion, List<LightNovel>>> categoryMapEntry : collect2.entrySet()) {
            System.out.println(categoryMapEntry.getKey()+" -> "+categoryMapEntry.getValue());
        }


    }//main

    private static Function<LightNovel, Promotion> getPromotionFunction() {
        return ln -> ln.getPrice() < 4 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
    }
}//class
