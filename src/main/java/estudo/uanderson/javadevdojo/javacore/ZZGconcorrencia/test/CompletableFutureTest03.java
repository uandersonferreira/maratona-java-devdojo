package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.service.StoreServiceDeprecate;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureTest03 {
    public static void main(String[] args) {
        StoreServiceDeprecate storeServiceDeprecate = new StoreServiceDeprecate();
        searchPricesAsyncCompletableFuture(storeServiceDeprecate);

    }

    private static void searchPricesAsyncCompletableFuture( StoreServiceDeprecate storeService){
        long start =  System.currentTimeMillis();
        // Trocando o pool pelo Comportamento das Threds
        // r == runnable
        ExecutorService executor = Executors.newFixedThreadPool(5, r ->{
            Thread thread =  new Thread(r);
            thread.setDaemon(true);
            return thread;
        });
        List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");
   //Mudando o comportamento de um method sicronico para assicronico

        List<CompletableFuture<Double>> completableFutureList = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> storeService.getPriceSync(s),executor))//por se sobrecarregado aceita um executor sendo assim passa a usar o pool de threds ao invés do join
                .collect(Collectors.toList());
        //Faz com que ocorra a mudança de comportamento.
        List<Double> prices = completableFutureList.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());


        System.out.println(prices);
        long end = System.currentTimeMillis();
        executor.shutdown();//Por causa do executor temos que chamar o method senão fica consumindo recurso e não finaliza
        System.out.printf("Time passed to searchPriceSync: %dms%n", (end-start));
        //StoreService.shutdown(); Não é obrigatório, ele ja encerra por si só


    }//method
}
