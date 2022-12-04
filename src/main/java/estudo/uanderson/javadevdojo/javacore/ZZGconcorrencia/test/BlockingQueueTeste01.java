package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueTeste01 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);//define a capacidade de elementos permitidos na lista

        blockingQueue.put("Uanderson");//put() adiciona
        System.out.printf("%s added the value: %s%n", Thread.currentThread().getName(), blockingQueue.peek());// peek()método retorna, mas não não remover, a cabeça da fila.
        System.out.println("Trying to add another value");
        new Thread(new RemoverFromQueue(blockingQueue)).start();

        blockingQueue.put("Ferreira");
        System.out.printf("%s added the value: %s%n", Thread.currentThread().getName(), blockingQueue.peek());



    }//main

    static class RemoverFromQueue implements Runnable{
        private final BlockingQueue<String> blockingQueue;

        RemoverFromQueue(BlockingQueue<String> blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            System.out.printf("%s going to sleep for 5s: %n", Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.printf("%s remoing value from queue: %s%n", Thread.currentThread().getName(), blockingQueue.take());//take() remove
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }//class RemoverFromQueue

}//class
/*
BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(1);
1° -> Possuo um limente de valores que podemos armazenar/locolar
2° -> Se tentamos colocar algo além da capacidade de armazenamento
a thread irá ficar bloqueada, enquanto não for liberado espaço.

A classe ArrayBlockingQueue é uma fila de bloqueio limitada
apoiada por uma matriz. Por limitado, significa que o tamanho
da Fila é fixo. Uma vez criada, a capacidade não pode ser
alterada. As tentativas de colocar um elemento em uma fila
cheia resultarão no bloqueio da operação. Da mesma forma, as
tentativas de obter um elemento de uma fila vazia também
serão bloqueadas. O limite de ArrayBlockingQueue pode ser
alcançado inicialmente ignorando a capacidade como o parâmetro
no construtor de ArrayBlockingQueue. Esta fila ordena os
elementos FIFO (first-in-first-out) . Isso significa que o
chefe desta fila é o elemento mais antigo dos elementos presentes nesta fila.

A cauda dessa fila é o elemento mais novo dos elementos dessa
fila. Os elementos recém-inseridos são sempre inseridos no
final da fila e as operações de recuperação da fila obtêm
elementos no início da fila.

Resumo dos métodos :

-> boolean add(E e) - Insere o elemento especificado nesta fila
se for possível fazer imediatamente sem violar as restrições
de capacidade, retornando verdadeiro após o sucesso e jogando
um IllegalStateException se nenhum espaço estiver disponível no momento.

-> boolean 	contains(Object o) - Retorna true se esta fila contiver o elemento especificado.
int drainTo(Collection<? super E> c) - Remove todos os elementos disponíveis desta fila e
os adiciona para a coleção dada.

int drainTo(Collection<? super E> c, int maxElements)-Remove no máximo o número determinado
de elementos disponíveis de essa fila e os adiciona à coleção fornecida.

boolean offer(E e)- Insere o elemento especificado nesta fila se for possível fazer
imediatamente sem violar as restrições de capacidade, retornando true em caso de sucesso
e false se não houver espaço no momento acessível.

boolean offer(E e, long timeout, TimeUnit unit)- Insere o elemento especificado nesta fila,
esperando até o tempo de espera especificado, se necessário, para que o espaço fique disponível.

E 	poll(long timeout, TimeUnit unit)- Recupera e remove a cabeça desta fila, esperando até
o tempo de espera especificado, se necessário, para que um elemento fique disponível.

void put(E e) - Insere o elemento especificado nesta fila, aguardando se
necessário para que o espaço fique disponível.

int remainingCapacity() - Retorna o número de elementos adicionais que esta fila
pode idealmente (na ausência de restrições de memória ou recursos) aceitar sem
bloqueio ou Integer.MAX_VALUE se não houver limite.

boolean remove(Object o) - Remove uma única instância do elemento
especificado desta fila, se estiver presente.

E take()- Recupera e remove a cabeça desta fila, esperando
se necessário até que um elemento fique disponível.

E element() - Retrieves, but does not remove, the head of this queue.
E peek() - Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
link: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/BlockingQueue.html


 */