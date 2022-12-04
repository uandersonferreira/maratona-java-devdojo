package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import java.util.List;

public class StreamTest07 {
    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6);

        integers.stream().reduce((x, y) -> x + y).ifPresent(System.out::println);//Retorna Optional, pois a lista pode está vazia!
        System.out.println(integers.stream().reduce(0,(x, y) -> x + y));

        System.out.println("---------------Sum---------------------");
        integers.stream().reduce(Integer::sum).ifPresent(System.out::println);//Retorna Optional, pois a lista pode está vazia!
        System.out.println(integers.stream().reduce(0, Integer::sum));

        System.out.println("-----------------Mult----------------------");

        integers.stream().reduce((x, y) -> x * y).ifPresent(System.out::println);//Retorna Optional, pois a lista pode está vazia!
        System.out.println(integers.stream().reduce(1,(x, y) -> x * y));

        System.out.println("----------------max-----------------------");

        integers.stream().reduce((x,y) -> x > y ? x : y).ifPresent(System.out::println);
        integers.stream().reduce(Integer::max).ifPresent(System.out::println);
        System.out.println(integers.stream().reduce(0,Integer::max));//T identity passado retorno um Integer, senão um Optional
    }


}

/*
(Sum, min, max, average, and string concatenation)
Soma, min, max, média e concatenação de strings
são todas especiais casos de redução. A soma de um
fluxo de números pode ser expressa como:

     Integer sum = integers.reduce(0, (a, b) -> a+b);

ou:

     Integer sum = integers.reduce(0, Integer::sum);


Referência: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/stream/Stream.html#reduce(java.util.function.BinaryOperator)
 */