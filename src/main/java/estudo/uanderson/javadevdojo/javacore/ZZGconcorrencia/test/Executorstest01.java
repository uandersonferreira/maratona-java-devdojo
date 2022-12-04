package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Printer implements Runnable{
    private final int num;

    Printer(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.printf("%s inicio: %d%n", Thread.currentThread().getName(),num );
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s finalizou: %n", Thread.currentThread().getName());

    }
}//class


public class Executorstest01 {
    public static void main(String[] args) {
        //System.out.println(Runtime.getRuntime().availableProcessors());
        //ExecutorService executorService = Executors.newFixedThreadPool(2);
        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newCachedThreadPool();

        executorService.execute(new Printer(1));
        executorService.execute(new Printer(2));
        executorService.execute(new Printer(3));
        executorService.execute(new Printer(4));
        executorService.shutdown();
        System.out.println("Programa Finalizado");

    }//main
}//class
/*
O método newCachedThreadPool() da classe Executors Cria
um pool de threads que cria novos threads conforme necessário,
mas reutilizará threads construídos anteriormente quando
estiverem disponíveis.

 */