package estudo.uanderson.javadevdojo.javacore.ZZFthread.domain;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {
    private final Queue<String> emailsQueue = new ArrayBlockingQueue<>(10);
    private boolean open = true;

    public boolean isOpen(){
        return this.open;
    }
    public int pendingEmails(){
        synchronized (emailsQueue){
            return emailsQueue.size();
        }
    }//pendingEmails

    public void addMembersEmail(String email){
        synchronized (this.emailsQueue){
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName+ " Adcionou email na lista");
            this.emailsQueue.add(email);
            //TODO voltar quando a thread estiver esperando
            this.emailsQueue.notifyAll();
        }
    }//addMembersEmail

    public String retriveEmail(){
        System.out.println(Thread.currentThread().getName()+" checking if there are emails");
        //Se não tiver -> não é para para, mas sim entra em modo de espera
        synchronized (this.emailsQueue){
            while (this.emailsQueue.size() == 0){
                if (!open) return null;
                System.out.println(Thread.currentThread().getName()+ " Não tem email disponível na lista, entarndo em modo de espera");
                try {
                    this.emailsQueue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }//while
            return this.emailsQueue.poll();
        }
    }//retriveEmail

    public void closed(){
        this.open = false;
        synchronized (this.emailsQueue){
            System.out.println(Thread.currentThread().getName()+" Notificando todos, que não estamos mais pegando emails");
            this.emailsQueue.notifyAll();
        }
    }



}//class
