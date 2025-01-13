package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class StreamTest10 {
    public static void main(String[] args) {
       // Stream.iterate(); aceita um UnaryOperator e Predicate
        //Stream.generate(); aceita um supplier
        Stream.iterate(1, n -> n + 2)
                .limit(20)
                .forEach(n -> System.out.print(n + " "));
        System.out.println("\n----------------");
        //Sequência de finobaci
        //0,1,1,2,3,5,8,13,21,34...
        //  0  1
        // (0, 1), (1,1), (2,3), (3,5)...

        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .forEach(array -> System.out.print(Arrays.toString(array) +" ") );
        System.out.println("\n----------------");

        Stream.iterate(new int[]{0,1}, n -> new int[]{n[1], n[0] + n[1]})
                .limit(10)
                .map(arrays -> arrays[0])
                .forEach(System.out::println);
        System.out.println("\n----------------");

        ThreadLocalRandom random = ThreadLocalRandom.current();
        Stream.generate(() -> random.nextInt(25))
                .limit(15)
                .forEach( n -> System.out.print(n +"  "));


    }//main
}//class
