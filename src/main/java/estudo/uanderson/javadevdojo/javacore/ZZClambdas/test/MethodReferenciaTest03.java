package estudo.uanderson.javadevdojo.javacore.ZZClambdas.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;

//Reference to an instance method of an arbitrary object of a particular type
public class MethodReferenciaTest03 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(List.of("uanderson", "maria", "paulo", "Ana"));
        stringList.sort(String::compareTo);
        System.out.println(stringList);

      //  Function<String, Integer> numStringToInteger = s -> Integer.parseInt(s);
        Function<String, Integer> numStringToInteger = Integer::parseInt;
        Integer num = numStringToInteger.apply("56");
        System.out.println(num);

        BiPredicate<List<String>, String> checkName = List::contains;
        System.out.println(checkName.test(stringList, "maria"));

    }//main
}//class
