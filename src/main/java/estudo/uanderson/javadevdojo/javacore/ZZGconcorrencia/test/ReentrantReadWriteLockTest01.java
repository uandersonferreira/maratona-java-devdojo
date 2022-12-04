package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MapReadWrite{
    private final Map<String,String> map = new LinkedHashMap<>();
    private final ReentrantReadWriteLock readWriteLock;

    MapReadWrite(ReentrantReadWriteLock readWriteLock) {
        this.readWriteLock = readWriteLock;
    }
    public void put(String key, String value){
        readWriteLock.writeLock().lock();
        try{
            if (readWriteLock.isWriteLocked()){
                System.out.printf("%s obteve o WRITE lock%n", Thread.currentThread().getName());
            }
            map.put(key,value);
            Thread.sleep(500);

        } catch (InterruptedException e) {
             e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }//method
    public Set<String> allKeys(){
        readWriteLock.readLock().lock();
        try {
            return  map.keySet();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }//method allKeys
}//class

public class ReentrantReadWriteLockTest01 {
    public static void main(String[] args) {
        ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
        MapReadWrite mapReadWrite = new MapReadWrite(rwl);

        Runnable write = () -> {
            for (int i = 0; i < 20 ; i++) {
                mapReadWrite.put(String.valueOf(i), String.valueOf(i));
            }
        };

        Runnable reader = () -> {
            if (rwl.isWriteLocked()){
                System.out.println("WRITE LOCKED");
            }
            rwl.readLock().lock();
            System.out.println(Thread.currentThread().getName()+" FINALLY I GOT THE DAM LOCK");
            try {
                System.out.println(Thread.currentThread().getName()+" "+mapReadWrite.allKeys());

            }finally {
                rwl.readLock().unlock();
            }

        };

        Thread t1 = new Thread(write);
        Thread t2 = new Thread(reader);
        Thread t3 = new Thread(reader);
        t1.start();
        t2.start();
        t3.start();
    }//main
}//class

/*
-> Mais de uma thread pode obter o lock de leitura,
mas somenete uma thread pode obter o lock de escrita.
 */