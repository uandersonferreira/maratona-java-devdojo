package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.Category;
import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamTest12 {
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

        Map<Category, List<LightNovel>> categoryLightNovelMap = new HashMap<>();
        ArrayList<LightNovel> fantasyList = new ArrayList<>();
        ArrayList<LightNovel> dramaList = new ArrayList<>();
        ArrayList<LightNovel> romanceList = new ArrayList<>();

        for (LightNovel lightNovel : lightNovels) {
            switch (lightNovel.getCategory()){
                case DRAMA: dramaList.add(lightNovel);break;
                case FANTASY: fantasyList.add(lightNovel);break;
                case ROMANCE: romanceList.add(lightNovel);break;
            }//switch
        }//for

        categoryLightNovelMap.put(Category.DRAMA, dramaList);
        categoryLightNovelMap.put(Category.FANTASY, fantasyList);
        categoryLightNovelMap.put(Category.ROMANCE, romanceList);
        for (Map.Entry<Category, List<LightNovel>> categoryListEntry : categoryLightNovelMap.entrySet()) {
            System.out.println(categoryListEntry.getKey()+ " -> "+ categoryListEntry.getValue());
        }

        System.out.println();
    /*
        Tudo isso resumido em duas linhas de código, usando o
        Collectors.groupingBy();
   */

        Map<Category, List<LightNovel>> collect = lightNovels.stream().collect(Collectors.groupingBy(LightNovel::getCategory));
        //System.out.println(collect);
        for (Map.Entry<Category, List<LightNovel>> categoryListEntry : collect.entrySet()) {
            System.out.println(categoryListEntry.getKey()+" -- "+ categoryListEntry.getValue());
        }


    }//main
}//class
