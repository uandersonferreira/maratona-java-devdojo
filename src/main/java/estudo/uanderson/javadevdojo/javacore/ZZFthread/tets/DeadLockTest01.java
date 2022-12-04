package estudo.uanderson.javadevdojo.javacore.ZZFthread.tets;

public class DeadLockTest01 {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Runnable runnable1 = () -> {
            synchronized (lock1){
                System.out.println("Thread 1: Segurando lock 1");
                System.out.println("Thread 1: esperando lock 2");
                synchronized (lock2){
                    System.out.println("Thread 1: Segurando lock 2");
                }//2° synchronized
            }//1° synchronized
        };//Runnable
        Runnable runnable2 = () -> {
            synchronized (lock1){
                System.out.println("Thread 2: Segurando lock 2");
                System.out.println("Thread 2: esperando lock 1");
                synchronized (lock2){
                    System.out.println("Thread 2: Segurando lock 1");
                }//2° synchronized
            }//1° synchronized
        };//Runnable

        new Thread(runnable1).start();
        new Thread(runnable2).start();
    }//main
}//class
/*
DeadLock é quando temos mais de uma Thread, onde cada uma acessa
um objeto diferente é por algum motivo essas Thread, além do seu
acesso ao objeto, necessita acessar o objeto da outra Thread,
mas como está sendo usado o Synchronized, ao tentar acessar esse
outro objeto irá ficar em estado de espera, pois só é possível
1 acesso por vez ao mesmo objeto, sendo assim, a execução das
Threads nunca serão terminadas.

A -> Objeto1 & Precisa Acessa também Objeto2
B -> Objeto2 & Precisa Acessa também Objeto1

Mas A é B estão ocupados os respectivos objetos, é e permitido
somente 1 Acesso por vez.

OBS:
Para resolver um DeadLock basta que
A ordem do acesso Sicronização dos objetos de A,
 seja a mesma do acesso dos Objetos de B;

Como feito o exemplo do código acima!



 */