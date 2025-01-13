package br.com.uanderson.collectionsjava;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImplementation {
    public static void main(String[] args) {
        Queue<Carro> queueCarros = new LinkedList<>();

        // 1. Adicionando elementos à fila
        queueCarros.add(new Carro("Ford"));
        queueCarros.add(new Carro("Chevrolet"));
        queueCarros.add(new Carro("Fiat"));

        // 2. Adicionando um elemento e verificando se foi inserido com sucesso
        System.out.println("Adicionando Peugeot: " + queueCarros.add(new Carro("Peugeot")));

        // 3. Exibindo a fila completa
        System.out.println("Fila atual: " + queueCarros);

        // 4. Adicionando um elemento usando offer()
        System.out.println("Adicionando Renault com offer(): " + queueCarros.offer(new Carro("Renault")));
        System.out.println("Fila após offer(): " + queueCarros);

        // 5. Consultando o primeiro elemento da fila sem removê-lo
        System.out.println("Primeiro elemento (peek): " + queueCarros.peek());
        System.out.println("Fila após peek(): " + queueCarros);

        // 6. Removendo o primeiro elemento da fila
        System.out.println("Removendo o primeiro elemento (poll): " + queueCarros.poll());
        System.out.println("Fila após poll(): " + queueCarros);

        // 7. Verificando se a fila está vazia
        System.out.println("A fila está vazia? " + queueCarros.isEmpty());

        // 8. Removendo todos os elementos da fila
        while (!queueCarros.isEmpty()) {
            System.out.println("Removendo: " + queueCarros.poll());
        }
        System.out.println("Fila após remover todos os elementos: " + queueCarros);

        // 9. Tentando remover um elemento de uma fila vazia
        System.out.println("Tentando remover de uma fila vazia: " + queueCarros.poll());
    }
}


