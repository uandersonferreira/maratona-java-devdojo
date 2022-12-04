package estudo.uanderson.javadevdojo.javacore.ZZClambdas.test;

import java.util.List;
import java.util.function.Consumer;

public class LambdaTest01 {
    public static void main(String[] args) {
        List<String> stringList = List.of("Uanderson", "Luffy", "Sasuke", "Naruto");
        List<Integer> integerList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        forEach(stringList, (String s) -> System.out.println(s) );
        forEach(integerList, (Integer i) -> System.out.println(i) );
    }

    private static <T> void forEach(List<T> list, Consumer<T> consumer){
        for (T elemento : list) {
            consumer.accept(elemento);
        }

    }//metodo
}//class

/*
Consumer não retorna nada, diferente da lambda Predicate.
 */
