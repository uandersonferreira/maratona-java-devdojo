package estudo.uanderson.javadevdojo.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {
    public static void main(String[] args) {
        List<String> stringsList = List.of("Uanderson", "Ferreira", "de", "Oliveira");
        List<Integer> integersLength = map(stringsList, (String s) -> s.length());
        List<String> stringsUpperCase = map(stringsList, s -> s.toUpperCase());

        System.out.println(integersLength);
        System.out.println(stringsUpperCase);


    }//main

    private static <T, R>  List<R>  map(List<T> list,Function<T, R> function){
        List<R> result = new ArrayList<>();
        for (T elemento : list) {
            R apply = function.apply(elemento);
            result.add(apply);
        }
        return result;


    }

}//class

/*
A FUNCTION POSSUE DOIS PARAMETROS:
    T -> TIPO DOS ELEMENTOS
    R -> RETORNO DOS ELEMENTOS



 */
