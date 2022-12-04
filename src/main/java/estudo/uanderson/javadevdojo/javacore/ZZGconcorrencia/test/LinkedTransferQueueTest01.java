package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueTest01 {
    public static void main(String[] args) throws InterruptedException {
        //(Junção das 3 listas, pois possue os methods de ambas em uma só)
        //ConcurrentLinkedQueue, SynchronousQueue, LinkedBlockingQueue

        TransferQueue<Object> transferQueue = new LinkedTransferQueue<>();
        System.out.println("add: "+transferQueue.add("Uanderson"));
        System.out.println("offer: "+transferQueue.offer("Uanderson"));
        System.out.println("offer + time: "+transferQueue.offer("Uanderson", 10,TimeUnit.SECONDS));
        transferQueue.put("Vieira");
        if (transferQueue.hasWaitingConsumer()){//verifica se têm algum consumido esperando
            transferQueue.transfer("Ferreira");
        }
        System.out.println("tryTransfer: "+transferQueue.tryTransfer("Oliveira"));
        System.out.println("tryTransfer + time: "+transferQueue.tryTransfer("Oliveira", 5,TimeUnit.SECONDS));
        System.out.println("element: "+ transferQueue.element());
        System.out.println("poll: "+ transferQueue.poll());
        System.out.println("remove: "+ transferQueue.remove());
        System.out.println("take: "+ transferQueue.take());
        System.out.println("remainingCapacity: "+transferQueue.remainingCapacity());

        for (Object o : transferQueue) {
            System.out.println("Lista: "+o);
        }


    }//main
}//class
/*
add()- Insere o elemento especificado no final desta fila.
se possível imediatamente, sem violar a capacidade de elementos.
retorna true, se conseguir adicionar é retorna uma Throwing an IllegalStateException
se não tiver espaço para colocar um novo elemento.
offer()- mesma coisa do add
offer(com tempo)- espera um tempo para poder adicionar o elemento na fila.
put()- tenta inserir, caso não seja possivel bloquia e esperar até possuir espaço na lista.

transfer()- Transfere o elemento para um consumidor em espera imediatamente, se possível.
Mais precisamente, transfere o elemento especificado imediatamente se já existe um consumidor
esperando para recebê-lo (em take()ou cronometrado poll), caso contrário, retornando falsesem
enfileirar o elemento. NullPointerException- se o elemento especificado for nulo
e InterruptedException- se interrompido enquanto espera, nesse caso o elemento não é deixado na fila

tryTransfer()- O mesmo que o transfer, só que não lança InterruptedException.
retorna true ou false.

tryTransfer(com time) - espera até que o elemento seja recebido por um consumidor,
 retornando false se o tempo de espera especificado expirar antes que o elemento possa ser transferido.

element()- exibe o 1° elemento da fila, mas não o remove e
lança uma exception se a lista/fila estive vazia.

peek()- pega o 1° elemento e não lança expection nenhuma.

poll()- pega e remove o 1° elemento da fila/lista e retorna null
 se a lista/fila estiver vazia.

remove()- é parecido com o pool, mas lança uma excpetion caso a lista seja vazia.

 take()- pega/recupera o 1° valor e também remove-o da lista é fica esperando/bloqueado até
 que seja adicioando um novo elemento na lista.
 lança: InterruptedException- se interrompido enquanto espera

link: https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/LinkedTransferQueue.html








 Como a fila é ilimitada, este método nunca lançará IllegalStateExceptionou retornar false.

 */