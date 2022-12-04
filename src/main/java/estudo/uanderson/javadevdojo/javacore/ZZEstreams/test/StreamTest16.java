package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamTest16 {
    public static void main(String[] args) {
        System.out.println("Processors: "+Runtime.getRuntime().availableProcessors());
        long num = 10_000_000;

        sunFor(num);
        sunStreamIterate(num);
        sunParallelStreamIterate(num);
        sunLongStreamIterate(num);
        sunParallelLongStreamIterate(num);
    }//main
    private static void sunFor(long num){
        System.out.println("Sun for ");
        long result = 0;
        long init = System.currentTimeMillis();
        for (int i = 1; i <= num ; i++) {
           result = result + i;
        }
        long end = System.currentTimeMillis();
        System.out.println(result +" "+ (end - init)+ "ms");
    }//method

    private static void sunStreamIterate(long num){
        System.out.println("Sun StreamIterate ");
        long init = System.currentTimeMillis();
        Long result = Stream.iterate(1L, i -> i+1)
                .limit(num)
                .reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result +" "+ (end - init)+ "ms");
    }//method

    private static void sunParallelStreamIterate(long num){
        System.out.println("Sun ParallelStreamIterate ");
        long init = System.currentTimeMillis();
        Long result = Stream.iterate(1L, i -> i+1)
                .limit(num)
                .parallel()//pode ser inserido em qualquer lugar da expressão, pois é soemnte uma flag que indica que irá trabalhar com multipls trades
                .reduce(0L, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println(result +" "+ (end - init)+ "ms");
    }//method

    private static void sunLongStreamIterate(long num){
        System.out.println("Sun LongStreamIterate ");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L,num)
                .reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result +" "+ (end - init)+ "ms");
    }//method
    private static void sunParallelLongStreamIterate(long num){
        System.out.println("Sun ParallelLongStreamIterate ");
        long init = System.currentTimeMillis();
        long result = LongStream.rangeClosed(1L,num)
                .parallel()
                .reduce(0L, Long::sum);
        long end = System.currentTimeMillis();
        System.out.println(result +" "+ (end - init)+ "ms");
    }//method

}//class

/*
Streams paralelas
processador -> núcleos -> trades

Runtime.getRuntime().availableProcessors(), por padrão é 8
 */