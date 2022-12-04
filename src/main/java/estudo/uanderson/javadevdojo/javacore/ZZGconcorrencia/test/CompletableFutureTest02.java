package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.service.StoreService;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest02 {
    public static void main(String[] args) {
        StoreService storeService = new StoreService();

        searchPricesAsyncCompletableFuture(storeService);

    }

    private static void searchPricesAsyncCompletableFuture( StoreService storeService){
        long start =  System.currentTimeMillis();
        List<String> stores = List.of("Store 1","Store 2","Store 3","Store 4");

        List<CompletableFuture<Double>> completableFutureList = stores.stream()
                .map(storeService::getPricesAsyncCompletableFuture)
                .collect(Collectors.toList());

        List<Double> prices = completableFutureList.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        System.out.println(prices);


        long end = System.currentTimeMillis();
        System.out.printf("Time passed to searchPriceSync: %dms%n", (end-start));
        //StoreService.shutdown(); Não é obrigatório, ele ja encerra por si só


    }//method
}
