package estudo.uanderson.javadevdojo.javacore.ZZFthread.tets;

import estudo.uanderson.javadevdojo.javacore.ZZFthread.domain.Account;

public class ThreadAccountTest01 implements Runnable {
    private final Account account = new Account();

    public static void main(String[] args) {
    ThreadAccountTest01 threadAccountTest01 = new ThreadAccountTest01();
    Thread t1 =  new Thread(threadAccountTest01, "Hestia");
    Thread t2 =  new Thread(threadAccountTest01, "Bell Cranel");

    t1.start();
    t2.start();

    }//main

    @Override
    public void run() {
        for (int i = 0; i < 5 ; i++) {
            withdrawal(10);
            if (account.getBalance() < 0){
                System.out.println("DEU RUIM");
            }
        }//for
    }//method

//    private static synchronized void print(){
//        // synchronized a classe, mas não é muito comum
//        synchronized (ThreadAccountTest01.class){
//
//        }
//    }
    private void withdrawal(int amount){
        System.out.println(getThreadName()+"### Fora  synchronized ");
        synchronized (account) {
            System.out.println(getThreadName()+"*** dentro  synchronized ");
            if (account.getBalance() >= amount) {
                System.out.println(getThreadName() + " indo sacar dinheiro");
                account.withdrawal(amount);
                System.out.println(getThreadName() + " Saque completo, Valor atual em conta: " + account.getBalance());

            } else {
                System.out.println("Saldo Insulficiente para " + getThreadName() + " efetuar o saque " + account.getBalance());
            }
        }//synchronized
    }//method withdrawal

    private String getThreadName() {
        return Thread.currentThread().getName();
    }

}//class
/*
Sicronismo de threads ao acessar o mesmo objeto!
pode gerar erros. Por isso usar se uma palavra reservado do java
para bloquear o acesso de um trade até que encerre a trade atual.
" synchronized " , podendo vim na declaração do method ou no
bloco de declaração do código, nesta caso a várial criada, recomendasse
que seja do tipo final(uma constante).

 -> Basicamente quando queremos uma sicronização atômica
 1 por vez .




 */