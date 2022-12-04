package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.service;

import estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.domain.Discount;
import estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.domain.Quote;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class StoreServiceWithDiscount {
    Locale localeUS = Locale.US;

    public String getPriceSync(String storeName){
      double price =  priceGenerator();//poderia está vindo de um api
        Discount.Code discountCode = Discount.Code.values()[ThreadLocalRandom.current().nextInt(
                Discount.Code.values().length
        )];//Poderia está vindo de um banco de dados

        return String.format(localeUS,"%s:%.2f:%s", storeName, price,discountCode);
    }

    //Method que aplica o desconto após ser passado uma cotação(Quote)
    public String applyDiscount(Quote quote){
        delay();
        double discountValue = quote.getPrice() * (100 - quote.getDiscountCode().getPercentage()) / 100;
        return String.format(localeUS,"'%s' original price: '%.2f'. Applying discount code '%s'. Final price: '%.2f'",
                quote.getStoreName(),
                quote.getPrice(),
                quote.getDiscountCode(),
                discountValue
        );
    }//method

    private double priceGenerator(){
        delay();
        return ThreadLocalRandom.current().nextDouble(1,500) * 10;
    }
    private void delay(){
        try {
            int milli = ThreadLocalRandom.current().nextInt(200, 2500);
            TimeUnit.MILLISECONDS.sleep(milli);
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