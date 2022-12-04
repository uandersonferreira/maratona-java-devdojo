package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest01 {
    private static final ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private static final DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("HH:mm:ss");

    private static void beeper(){
        Runnable r = () -> {
            System.out.println(LocalTime.now().format(formatter) + " beep");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

       //executor.schedule(r, 5, TimeUnit.SECONDS);
      //ScheduledFuture<?> scheduledFuture = executor.scheduleWithFixedDelay(r, 1, 5, TimeUnit.SECONDS);
      ScheduledFuture<?> scheduledFuture = executor.scheduleAtFixedRate(r, 1, 5, TimeUnit.SECONDS);

        executor.schedule(() ->{
            System.out.println("Cancelando o schedule");
             scheduledFuture.cancel(false);
             executor.shutdown();
        },10, TimeUnit.SECONDS);


    }//beeper


    public static void main(String[] args) {
        System.out.println(LocalTime.now().format(formatter));
        beeper();
    }


}//class
/*
schedule - Cria e executa uma ação única que se torna
habilitada após o atraso determinado.
Sintaxe:
schedule(Runnable command, long delay, TimeUnit unit)

utilizando Callable ao invés de um Runnable:
schedule(Callable<V> callable, long delay, TimeUnit unit)

scheduleWithFixedDelay- Cria e executa uma ação periódica
que se torna habilitada após um determinado atraso e
subsequentemente com o determinado atraso entre o término
de uma execução e o início da próxima execução.
Sintaxe:
scheduleWithFixedDelay (comando Runnable, long initialDelay, long delay, unidade TimeUnit)

scheduleAtFixedRate - Cria e executa uma ação periódica que
é habilitada primeiro após um determinado atraso e
posteriormente com o período determinado.
Sintaxe:
scheduleAtFixedRate (comando Runnable, long initialDelay, longo período, unidade TimeUnit)

link:https://acervolima.com/classe-scheduledthreadpoolexecutor-em-java/
link: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ScheduledExecutorService.html




 */