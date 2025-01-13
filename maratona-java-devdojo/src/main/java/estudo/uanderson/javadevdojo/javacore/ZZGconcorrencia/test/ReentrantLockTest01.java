package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import java.util.concurrent.locks.ReentrantLock;

class Worker implements Runnable{
    private String name;
    private ReentrantLock lock;

    public Worker(String name, ReentrantLock lock) {
        this.name = name;
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            System.out.printf("Thread %s entrou em uma sessão critica%n", name);
            System.out.printf("%d Threads esperando na fila %n", lock.getQueueLength());
            System.out.printf("Threads %s vai esperar 2s%n", name);
            Thread.sleep(2000);
            System.out.printf("Thread %s finalizou a espera%n", name);

        } catch (InterruptedException e) {
                e.printStackTrace();

        }finally {
                lock.unlock();
        }
    }//method

}//class

public class ReentrantLockTest01 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock(true);
        new Thread(new Worker("A", lock)).start();
        new Thread(new Worker("B", lock)).start();
        new Thread(new Worker("C", lock)).start();
        new Thread(new Worker("D", lock)).start();
        new Thread(new Worker("E", lock)).start();
        new Thread(new Worker("F", lock)).start();
        new Thread(new Worker("G", lock)).start();

    }//main
}//class
/*
Um bloqueio é adquirido através de lock() e liberado através unlock().
É importante envolver seu código em um try/finally bloco para
garantir o desbloqueio em caso de exceções. Para evitar o Deadlock


 - void lock() – Adquira o bloqueio se estiver disponível. Se o bloqueio não estiver disponível, um thread será bloqueado até que o bloqueio seja liberado.
 - void lockInterruptably() – Isso é semelhante ao lock() , mas permite que o thread bloqueado seja interrompido e retome a execução por meio de uma java.lang.InterruptedException .
 - boolean tryLock() – Esta é uma versão sem bloqueio do lock() . Ele tenta adquirir o bloqueio imediatamente, retorna true se o bloqueio for bem-sucedido.
 - boolean tryLock(long timeout, TimeUnit timeUnit) – Isso é semelhante a tryLock() , exceto que espera o tempo limite determinado antes de desistir de tentar adquirir o Lock .
 - void unlock() desbloqueia a Lock instância
 - O método isHeldByCurrentThread() da classe ReentrantLock verifica se o thread atual ocupa esse bloqueio.


   @Override
    public void run() {
        try {
            lock.tryLock(2, TimeUnit.SECONDS);
            if (lock.isHeldByCurrentThread()){
                System.out.printf("Thread %s pegou o Lock%n", name);
            }
            System.out.printf("Thread %s entrou em uma sessão critica%n", name);
            System.out.printf("%d Threads esperando na fila %n", lock.getQueueLength());
            System.out.printf("Threads %s vai esperar 2s%n", name);
            Thread.sleep(2000);
            System.out.printf("Thread %s finalizou a espera%n", name);

        } catch (InterruptedException e) {
                e.printStackTrace();

        }finally {
            if (lock.isHeldByCurrentThread()){// Verifica se a thread tem o bloqueio, se não
                // pode gerar um "IllegalMonitorStateException" caso não fosse verifocado
                lock.unlock();
            }
        }
    }//method

    Métodos ReentrantLock()

    lock(): Chamada para o método lock() incrementa a contagem de espera em 1 e dá o
    bloqueio para o encadeamento se o recurso compartilhado estiver inicialmente livre.

    unlock(): Chamada para o método unlock() diminui a contagem de espera em 1.
    Quando esta contagem chega a zero, o recurso é liberado.

    tryLock(): Se o recurso não for retido por nenhum outro
    encadeamento, a chamada para tryLock() retornará true e
    a contagem de retenções será incrementada em um. Se o
    recurso não estiver livre, o método retornará false e o
    encadeamento não será bloqueado, mas será encerrado.

    tryLock(long timeout, TimeUnit unit): De acordo com o método, o thread
    aguarda um determinado período de tempo conforme definido pelos argumentos
    do método para adquirir o bloqueio no recurso antes de sair.

    lockInterruptably(): Este método adquire o bloqueio se o recurso estiver
    livre enquanto permite que o encadeamento seja interrompido por algum outro
    encadeamento ao adquirir o recurso. Isso significa que, se o thread atual
    estiver aguardando o bloqueio, mas algum outro thread solicitar o bloqueio,
    o thread atual será interrompido e retornará imediatamente sem adquirir o bloqueio.

    getHoldCount(): Este método retorna a contagem do número de bloqueios mantidos no recurso.

    isHeldByCurrentThread(): Este método retorna true se o bloqueio no recurso for mantido pelo
     thread atual


 */