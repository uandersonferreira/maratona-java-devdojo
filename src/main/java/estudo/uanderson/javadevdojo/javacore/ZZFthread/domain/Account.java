package estudo.uanderson.javadevdojo.javacore.ZZFthread.domain;

public class Account {
    private int balance = 50;//saldo

    public void withdrawal(int amount){//sacar
        this.balance = this.balance - amount;
    }
    public int getBalance() {
        return balance;
    }

}//class
