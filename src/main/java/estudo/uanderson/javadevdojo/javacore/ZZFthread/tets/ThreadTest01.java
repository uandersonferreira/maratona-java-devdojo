package estudo.uanderson.javadevdojo.javacore.ZZFthread.tets;

class ThreadExample extends  Thread{
    private final char c;
    public  ThreadExample(char c){
        this.c = c;
    }
    @Override
    public void run() {
        System.out.println("\nThread: "+Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
        }
    }//method
}//class ThreadExample

class ThreadExampleRunnable implements Runnable{
    private final char c;
    public  ThreadExampleRunnable(char c){
        this.c = c;
    }
    @Override
    public void run() {
        System.out.println("\nThread: "+Thread.currentThread().getName());
        for (int i = 0; i < 500; i++) {
            System.out.print(c);
            if (i % 100 == 0){
                System.out.println();
            }
            try {
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//for
    }//method
}//class ThreadExampleRunnable


public class ThreadTest01 {
    public static void main(String[] args) {
  /*      ThreadExample t1 = new ThreadExample('A');
        ThreadExample t2 = new ThreadExample('B');
        ThreadExample t3 = new ThreadExample('C');
        ThreadExample t4 = new ThreadExample('D');
        t1.start();
        t2.start();
        t3.start();
        t4.start();
*/
        Thread t1 = new Thread(new ThreadExampleRunnable('A'), "T1A");
        Thread t2 = new Thread(new ThreadExampleRunnable('B'), "T2B");
        Thread t3 = new Thread(new ThreadExampleRunnable('C'), "T3C");
        Thread t4 = new Thread(new ThreadExampleRunnable('D'), "T4D");

        t4.setPriority(Thread.MAX_PRIORITY);//não é garantido que terá realmente a prioridade
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("#########"+Thread.currentThread().getName());

        //t4.start();//Só podemos dar start() uma única vez numa
        // thread senão gera um IllegalThreadStateException


    }//main


}//class

/*
Forma de se trabalhar com Threads :
 1° - extends a class Thread
 2° - implements Runnable (Forma mais Indicada)


Threads Demon - User
O java encerra o programa quando todas as threads do tipo
user são terminadas.
Threads daemon são threads de baixa prioridade que sempre
rodam em segundo plano e threads de usuário são threads de
 alta prioridade que sempre rodam em primeiro plano.
 O Thread de Usuário ou Não-Daemon são projetados para
 realizar tarefas específicas ou complexas, enquanto os
 threads daemon são usados para executar tarefas de suporte
(fonte: https://acervolima.com/diferenca-entre-threads-de-daemon-e-threads-de-usuario-em-java/)



-> quando um programa chama o método start(), uma nova
 thread é criada e o método run() é executado. Mas se
 chamarmos diretamente o método run(), nenhuma nova
 thread será criada e o método run() será executado como
 uma chamada de método normal na própria thread de chamada
  atual (nenhum multi-thread ocorrerá).
  (Fonte: https://acervolima.com/diferenca-entre-thread-start-e-thread-run-em-java/)

ESTADOS DE UMA THREAD
-> https://www.devmedia.com.br/utilizando-threads-parte-1/4459





 */