package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.service.StoreService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFutureTest01 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();
       // searchPricesSync(storeService);
        //searchPricesAsyncFuture(storeService);
        searchPricesAsyncCompletableFuture(storeService);
    }

    private static void searchPricesSync( StoreService storeService){
        long start =  System.currentTimeMillis();
        System.out.println(storeService.getPriceSync("Store 1"));
        System.out.println(storeService.getPriceSync("Store 2"));
        System.out.println(storeService.getPriceSync("Store 3"));
        System.out.println(storeService.getPriceSync("Store 4"));
       long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync: %dms%n", (end-start));

    }

    private static void searchPricesAsyncFuture( StoreService storeService){
        long start =  System.currentTimeMillis();
        Future<Double> pricesAsyncFuture1 = storeService.getPricesAsyncFuture("Store 1");
        Future<Double> pricesAsyncFuture2 = storeService.getPricesAsyncFuture("Store 2");
        Future<Double> pricesAsyncFuture3 = storeService.getPricesAsyncFuture("Store 3");
        Future<Double> pricesAsyncFuture4 = storeService.getPricesAsyncFuture("Store 4");

        try {
            System.out.printf("1°: %.2f%n",pricesAsyncFuture1.get());
            System.out.printf("2°: %.2f%n",pricesAsyncFuture2.get());
            System.out.printf("3°: %.2f%n",pricesAsyncFuture3.get());
            System.out.printf("4°: %.2f%n",pricesAsyncFuture4.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync: %dms%n", (end-start));
        StoreService.shutdown();//desligar as threads

    }//method


    private static void searchPricesAsyncCompletableFuture( StoreService storeService){
        long start =  System.currentTimeMillis();
        CompletableFuture<Double> pricesAsyncFuture1 = storeService.getPricesAsyncCompletableFuture("Store 1");
        CompletableFuture<Double> pricesAsyncFuture2 = storeService.getPricesAsyncCompletableFuture("Store 2");
        CompletableFuture<Double> pricesAsyncFuture3 = storeService.getPricesAsyncCompletableFuture("Store 3");
        CompletableFuture<Double> pricesAsyncFuture4 = storeService.getPricesAsyncCompletableFuture("Store 4");

            System.out.printf("1°: %.2f%n",pricesAsyncFuture1.join());
            System.out.printf("2°: %.2f%n",pricesAsyncFuture2.join());
            System.out.printf("3°: %.2f%n",pricesAsyncFuture3.join());
            System.out.printf("4°: %.2f%n",pricesAsyncFuture4.join());

        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync: %dms%n", (end-start));
        //StoreService.shutdown(); Não é obrigatório, ele ja encerra por si só


    }//method


}//class
/*
Um CompltableFuture é usado para programação assíncrona.
Programação assíncrona significa escrever código sem bloqueio.
Ele executa uma tarefa em um encadeamento separado do encadeamento
do aplicativo principal e notifica o encadeamento principal
sobre seu progresso, conclusão ou falha.

Dessa forma, o thread principal não bloqueia ou espera a conclusão
da tarefa. Outras tarefas são executadas em paralelo.
-Portanto, é um elemento de uma cadeia.
Quando mais de um thread tenta concluir - concluir excepcionalmente ou
cancelar um CompletableFuture, apenas um deles é bem-sucedido.


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
Não precisa tratar as exceptions, pois as exceção não são do tipo checadas.


 link: https://www.javatpoint.com/completablefuture-in-java


 */