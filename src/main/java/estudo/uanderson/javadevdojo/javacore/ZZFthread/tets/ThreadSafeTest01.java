package estudo.uanderson.javadevdojo.javacore.ZZFthread.tets;

import java.util.ArrayList;
import java.util.List;

class ThreadSafeNames{
    private final List<String> names = new ArrayList<>();

    public synchronized void add(String name){
        names.add(name);
    }

    public synchronized void removeFirst(){
        if (names.size() > 0){
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }
}//class ThreadSafeNames

public class ThreadSafeTest01 {
    public static void main(String[] args) {
        ThreadSafeNames threadSafeNames = new ThreadSafeNames();
        threadSafeNames.add("Uanderson");

        //Runnable r = () -> {
        // threadSafeNames.removeFirst();
        //};

        Runnable r = threadSafeNames::removeFirst;
        new Thread(r).start();
        new Thread(r).start();
    }//main
}//class


/*
Ao criar classes thread safe temos que garantir que os methods
criados também são sicronizados(synchronized).
Ex:    public synchronized void removeFirst(){
        if (names.size() > 0){
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }

    Senão poderá gerar o seguinte erro:

Resultado:

Thread-0
Uanderson
Thread-1
Exception in thread "Thread-1" java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
	at java.base/java.util.Objects.checkIndex(Objects.java:372)
	at java.base/java.util.ArrayList.remove(ArrayList.java:536)
	at java.base/java.util.Collections$SynchronizedList.remove(Collections.java:2435)
	at estudo.uanderson.javadevdojo.javacore.ZZFthread.tets.ThreadSafeNames.removeFirst(ThreadSafeTest01.java:17)
	at java.base/java.lang.Thread.run(Thread.java:829)

 */