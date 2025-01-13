package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest06 {
    //FINDING AND MATCHING
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
        System.out.println("anyMatch: "+lightNovels.stream().anyMatch(ln -> ln.getPrice() > 7));
        System.out.println("allMatch: "+lightNovels.stream().allMatch(ln -> ln.getPrice() > 0));// todos os elementos são maior que 0 ?
        System.out.println("noneMatch: "+lightNovels.stream().noneMatch(ln -> ln.getPrice() < 0));//nenhum elemento menor que 0 ?

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .findAny()
                .ifPresent(System.out::println);

        lightNovels
                .stream()
                .filter(ln -> ln.getPrice() > 4)
                .sorted(Comparator.comparing(LightNovel::getPrice).reversed())
                .findFirst()
                .ifPresent(System.out::println);

        lightNovels
                .stream()
                .filter(ln -> ln.getPrice() > 4)
                .max(Comparator.comparing(LightNovel::getPrice))
                .ifPresent(System.out::println);



    }//main


}//class
