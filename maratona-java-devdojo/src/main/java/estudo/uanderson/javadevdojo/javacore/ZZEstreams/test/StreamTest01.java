package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest01 {

    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Eleceed", 2.55),
            new LightNovel("Unordinary", 1.99),
            new LightNovel("Nano Machine", 2.99),
            new LightNovel("Fullmetal Alchemist", 3.99),
            new LightNovel("Martial Peark", 3.98),
            new LightNovel("Martial God Asura", 4.00)
    ));

    public static void main(String[] args) {
        lightNovels.sort(Comparator.comparing(LightNovel::getTitle));

        ArrayList<String> titleList = new ArrayList<>();//para armazenar os mangas que atendem a condiçõa
        for (LightNovel novel : lightNovels) {
            if (novel.getPrice() <= 4){
               titleList.add(novel.getTitle());
            }
            if (titleList.size() >= 3){
                break;
            }
        }//for

        for (String s : titleList) {
            System.out.println(s);
        }
        System.out.println("------------------------");
        System.out.println(lightNovels);


    }//main

}//class

/*
1° - order LightNovel by title
2° - Retrieve the first 3 title light novels with price less than 4;

 */