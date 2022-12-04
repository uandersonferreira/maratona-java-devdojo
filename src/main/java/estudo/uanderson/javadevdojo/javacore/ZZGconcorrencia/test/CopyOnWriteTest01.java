package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;



import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;


public class CopyOnWriteTest01 {
    public static void main(String[] args) {
        List<Integer> list = new CopyOnWriteArrayList<>();
        //[1] insere
        //[1,2] insere é cria um novo objeto com esses valores
        //[1,2,3] insere
        //[1,2] deleta

        for (int i = 0; i < 2000 ; i++) {
            list.add(i);
        }

        Runnable runnableIterator = () -> {
            Iterator<Integer> iterator = list.iterator();
            try {
                TimeUnit.SECONDS.sleep(2);
                iterator.forEachRemaining(System.out::println);
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
            //mantém uma cópia para o valor original no momento da criação
        };

        Runnable runnableRemover = () -> {
            for (int i = 0; i < 500 ; i++) {
                System.out.printf("%s removed %d%n", Thread.currentThread().getName(), i);
            }
        };

        new Thread(runnableIterator,"Thread-1").start();
        new Thread(runnableIterator,"Thread-2").start();
        new Thread(runnableRemover,"Thread-3").start();


    }//main
}//class
/*
Final -> A palavra-chave final em Java serve para atribuir valores
constantes, ou seja, que a partir da sua declaração,seus valores não poderão mais serem alterados.

-> Classe imutavel é aquela onde os seus atributos não podem ser
alterados(a alteração somente é permitida se tiver a permissão), somente lidos.

final class Animal{
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}//class Aimal

CopyOnWriteArrayList ->

- Como o nome indica, CopyOnWriteArrayList cria uma cópia clonada do ArrayList subjacente,
para cada operação de atualização em um determinado ponto, ambos serão sincronizados
automaticamente, o que é feito pela JVM. Portanto, não há efeito para os encadeamentos
que estão executando a operação de leitura.

- Seu uso é caro porque, para cada operação de atualização, uma cópia clonada será criada.
Conseqüentemente, CopyOnWriteArrayList é a melhor escolha se nossa operação frequente for
operação de leitura.

- A estrutura de dados sublinhada é uma matriz que pode ser aumentada.
- É uma versão thread-safe de ArrayList.
- A inserção é preservada, duplicatas, nulos e objetos heterogêneos são permitidos.

-O principal ponto importante sobre CopyOnWriteArrayList é que o Iterator de
CopyOnWriteArrayList não pode executar a operação de remoção, caso contrário,
obteremos uma exceção de tempo de execução informando UnsupportedOperationException.
Os métodos add() e set() no iterador CopyOnWriteArrayList também lançam UnsupportedOperationException.
Além disso, o Iterator de CopyOnWriteArrayList nunca lançará ConcurrentModificationException

link: https://acervolima.com/copyonwritearraylist-em-java/




 */