package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter{
    private int count;
    private AtomicInteger atomicInteger = new AtomicInteger();//Implementada em situações onde precisamos
    //fazer contagem de forma atômica

    private Lock lock = new ReentrantLock(true);
    void increment(){
        lock.lock();//obtendo/pegando o lock
        try {
            count++;
            atomicInteger.incrementAndGet();
        }finally {//finally sempre será executado
            lock.unlock();//liberando o lock
        }

    }//method

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }

    public int getCount() {
        return count;
    }
}

public class AtomicIntegerTest01 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable r = () -> {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.getCount());
        System.out.println(counter.getAtomicInteger());

    }//main
}//class
/*
Atomic -> Se o valor de uma variável continua mudando por vários threads,
pode haver uma chance de um problema de inconsistência de dados.
Podemos resolver esse problema usando uma variável atômica.
O problema de inconsistência de dados pode ser resolvido
quando os objetos dessas classes representam a variável
atômica de int, long, boolean e referência de objeto,
respectivamente.


 -> Devido à sua natureza sem bloqueio, ele é imune a riscos
 de simultaneidade, como deadlock e livelock.

 -> O desempenho é relativamente alto em comparação com
 a palavra-chave volátil e sincronizada

 -> Atomic também fornece o poder de implementar o algoritmo sem bloqueio.

-> é aplicável apenas a variáveis.

Existem diferentes tipos de variáveis atômicas disponíveis no pacote java.util.concurrent.atomic, incluindo:

    AtomicBoolean
    AtomicInteger
    AtomicIntegerArray
    AtomicIntegerFieldUpdater
    AtomicLong
    AtomicLongArray
    AtomicLongFieldUpdater
    AtomicReference

1° -> https://definirtec.com/atomico/
2° -> https://acervolima.com/diferenca-entre-atomico-volatil-e-sincronizado-em-java/


 */