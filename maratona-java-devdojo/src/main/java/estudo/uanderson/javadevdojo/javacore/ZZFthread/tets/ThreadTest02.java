package estudo.uanderson.javadevdojo.javacore.ZZFthread.tets;

class ThreadExampleRunnable2 implements Runnable{
    private final String c;
    public  ThreadExampleRunnable2(String c){
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
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Thread.yield();//Deixa a thread em execução temporariamente inativa
        }//for
    }//method
}//class ThreadExampleRunnable2


public class ThreadTest02 {
    public static void main(String[] args) throws InterruptedException {
      Thread t1 =  new Thread(new ThreadExampleRunnable2("KA"), "T1");
      Thread t2 =  new Thread(new ThreadExampleRunnable2("ME"), "T2");

      t1.start();
      t1.join();//espera a thread se processada para poder iniciar outra.
      t2.start();


    }//main


}//class

/*
-> METHODS DE UM THREAD :

    Thread(...) – construtor da classe. Permite que seja instanciado um objeto do tipo Thread;

    void run() – Deve conter o código que se deseja executar, quando a thread estiver ativa;

    void start() – Inicia a thread. Ou seja, efetiva a chamada do método run();

    static void yield() – Deixa a thread em execução temporariamente inativa e, quando possível, promove outra thread de mesma prioridade ou maior;

    void stop() – encerra a thread;

    static void sleep(long tempo) – deixa thread corrente inativa por no mínimo tempo milisegundos e promove outra thread. Note que este método é de classe e, consequentemente, uma thread não pode fazer outra thread dormir por um tempo;

    void suspend() – Coloca a thread no final da fila de sua prioridade e a deixa inativa (método deprecado);

    void resume() – Habilita novamente a execução da thread. Este método deve ser executado por outra thread, já que a thread suspensa não está sendo executada (método deprecado);

    void interrupt() – envia o pedido de interrupção de execução de uma thread;

    static boolena interrupted() – Verifica se a thread atual está interrompida;

    void join() – Aguarda outra thread para encerrar;

    boolean isAlive() – retorna true caso uma thread estiver no estado executável ou bloqueado. Nos demais retorna false;

    void setPriority(int prioridade) – Define a prioridade de execução de uma thread. Os valores de prioridade estão entre 1 e 10;

    int getPriority() – verifica a prioridade de execução de uma thread;

    synchronized – mecanismo que permite ao programador controlar threads, para que as mesmas possam compartilhar a mesma base de dados sem causar conflitos;

    void wait() – Interrompe a thread corrente e coloca a mesma na fila de espera (do objeto compartilhado) e aguarda que a mesma seja notificada. Este método somente pode ser chamado dentro de um método de sincronizado;

    void notify() – Notifica a próxima thread, aguardando na fila;

    void notifyAll() – Notifica todas as threads.

//Inner Class
 Thread t1 = new Thread(new Runnable() {
     @Override
     public void run() {

     }
 });
=------------
    Thread t1 = new Thread(() -> {
          //Lógica/código
        });
        t1.start();
-----------------
        Runnable example = () -> {
            System.out.println("\nThread: "+Thread.currentThread().getName());
            for (int i = 0; i < 500; i++) {
                System.out.print("Algo");
                if (i % 100 == 0){
                    System.out.println();
                }
            }//for
        };
        new Thread(example);


 */