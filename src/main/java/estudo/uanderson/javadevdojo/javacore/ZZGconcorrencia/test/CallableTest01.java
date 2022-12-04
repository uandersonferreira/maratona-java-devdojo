package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import java.util.concurrent.*;

class RandomNumberCallable implements Callable<String>{

    @Override
    public String call() throws Exception {
        //Math.random();//é sicronizado
        int num = ThreadLocalRandom.current().nextInt(1,11);

        for (int i = 0; i < num ; i++) {
            System.out.printf("%s executando uma tarefa callable... %n",Thread.currentThread().getName());
        }

        return String.format("%s finished and the random number is %d%n ",Thread.currentThread().getName(), num);
    }
}//class RandomNumberCallable

public class CallableTest01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        RandomNumberCallable randomNumberCallable = new RandomNumberCallable();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<String> stringFuture = executorService.submit(randomNumberCallable);
        String s = stringFuture.get();
        System.out.printf("Program finished: %s", s);
        executorService.shutdown();

    }//main
}//class

/*
O Java 5 introduziu a interface
java.util.concurrent.Callable no pacote de simultaneidade
que é semelhante à interface Runnable, mas pode retornar
qualquer objeto e lançar Exception.

Links about Callable:
link: https://www.baeldung.com/java-runnable-callable
link: https://www.geeksforgeeks.org/difference-between-callable-and-runnable-in-java/




 */