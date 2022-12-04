package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.domain.Quote;
import estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest05 {
    public static void main(String[] args) {
        StoreServiceWithDiscount service = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(service);

    }//main

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service){
        long start =  System.currentTimeMillis();

        List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");

        var completableFutureList = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                .map(cf -> cf.thenAccept(store -> System.out.printf("%s finished in %d%n", store, (System.currentTimeMillis() - start))))
                .toArray(CompletableFuture[]::new);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutureList);
        //CompletableFuture<Object> voidCompletableFuture = CompletableFuture.anyOf(completableFutureList);
        voidCompletableFuture.join();
        System.out.printf("Finished? %b%n", voidCompletableFuture.isDone());


        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPricesWithDiscount: %dms%n", (end-start));
    }//method searchPricesWithDiscount

}//class
/*
-> allOf(CompletableFuture<?>... cfs):
Type - static CompletableFuture<Void>
Retorna um novo CompletableFuture que é concluído quando
todos o CompletableFutures dado completo.

-> anyOf(CompletableFuture<?>... cfs):
static CompletableFuture<Object>
Retorna um novo CompletableFuture que é concluído quando
qualquer um dos os CompletableFutures dados completos,
com o mesmo resultado.

link: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html


 */