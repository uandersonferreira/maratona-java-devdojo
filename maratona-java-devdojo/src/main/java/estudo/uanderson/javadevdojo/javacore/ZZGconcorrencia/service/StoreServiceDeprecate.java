package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.service;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreServiceDeprecate {
    // 242 - Concorrência pt 14 - CompletableFuture pt 03 - ThreadFactory
    //Transformar um method sicronico em assicronico

    public double getPriceSync(String storeName){
        System.out.printf("Getting prices sync for store %s%n", storeName);
        return priceGenerator();
    }

    private double priceGenerator(){
        System.out.printf("%s generating price %n", Thread.currentThread().getName());
        delay();
        return ThreadLocalRandom.current().nextDouble(1,500) * 10;
    }
    private void delay(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}//class
/*
Os métodos CompletableFuture usados com mais frequência são:

 supplyAsync(): Conclui seu trabalho de forma assíncrona.
 O resultado do fornecedor é executado por uma tarefa de
 ForkJoinPool.commonPool() como padrão. O método
 supplyAsync() retorna CompletableFuture no qual podemos
 aplicar outros métodos.

 thenApply(): O método aceita a função como um argumento.
 Ele retorna um novo CompletableStage quando esse estágio
 é concluído normalmente. O novo estágio é usado como
 argumento para a função fornecida.

 join(): o método retorna o valor do resultado quando
 concluído. Ele também lança um CompletionException
 (exceção não verificada) se for concluído excepcionalmente.

 */