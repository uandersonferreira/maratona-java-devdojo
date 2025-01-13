package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest05 {
    public static void main(String[] args) {
        List<String> words = List.of("Sasuke", "Naruto", "Kira", "Bell");
        String[] lettersWords = words.get(0).split("");
        System.out.println(Arrays.toString(lettersWords));
        System.out.println("-----------------------");

        List<String[]> collect = words.stream().map(w -> w.split("")).collect(Collectors.toList());
        Stream<String> stream = Arrays.stream(lettersWords);

        List<String> lettersWords2 = words.stream()
                .map(w -> w.split(""))
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());

        System.out.println(lettersWords2);

    }
}
