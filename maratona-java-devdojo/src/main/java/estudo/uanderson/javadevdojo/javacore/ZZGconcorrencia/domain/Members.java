package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.domain;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members {
    //UTILIZANDO LOCK AO INVÉS DE SYNCHRONIZED
    private final Queue<String> emailsQueue = new ArrayBlockingQueue<>(10);
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();//responsalvel por trabalhar com as condições do Lock
    private boolean open = true;

    public boolean isOpen() {
        return this.open;
    }

    public int pendingEmails() {
        lock.lock();
        try {
            return emailsQueue.size();
        } finally {
            lock.unlock();
        }

    }//pendingEmails

    public void addMembersEmail(String email) {
        lock.lock();
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " Adcionou email na lista");
            this.emailsQueue.add(email);
            //TODO voltar quando a thread estiver esperando
            this.condition.signalAll();
        } finally {
            lock.unlock();
        }

    }//addMembersEmail

    public String retriveEmail() {
        System.out.println(Thread.currentThread().getName() + " checking if there are emails");
        //Se não tiver -> não é para para, mas sim entra em modo de espera
        lock.lock();
        try {
            while (this.emailsQueue.size() == 0) {
                if (!open) {
                    return null;
                }else {
                    try {
                        this.emailsQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " Não tem email disponível na lista, entarndo em modo de espera");
            }//while
            return this.emailsQueue.poll();

        } finally {
            lock.unlock();
        }

    }//retriveEmail

    public void closed() {
        this.open = false;
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " Notificando todos, que não estamos mais pegando emails");
             condition.signalAll();
        }finally {
            lock.unlock();
        }

    }


}//class
/*
ctrl + alt + L (selecionar o código primeiro ctrl+ A)

-> O método newCondition() é usado para obter uma nova instância
Condition que está vinculada a esta instância Lock.

Nota: O newCondition() lança UnsupportedOperationExeption quando
a implementação de bloqueio não dá suporte a condições.

-- Modificador e tipo 	Método e Descrição:

-> Tipo void await() - Faz com que o thread atual espere até que seja sinalizado ou interrompido .
-> boolean await(long time, TimeUnit unit) - Faz com que o thread atual espere até que seja sinalizado ou interrompido, ou o tempo de espera especificado termina.
-> long awaitNanos(long nanosTimeout) - Faz com que o thread atual espere até que seja sinalizado ou interrompido, ou o tempo de espera especificado termina.
-> void awaitUninterruptibly() - Faz com que o thread atual espere até que seja sinalizado.
-> boolean awaitUntil(Date deadline)- Faz com que o thread atual espere até que seja sinalizado ou interrompido, ou o prazo especificado expirar.
-> void signal() - Desperta uma thread em espera.
-> void signalAll()- Ativa/Despertar todos os threads em espera

link:https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/Condition.html


 */