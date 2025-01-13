package dio.estruturas-de-dados.collections-java;

import java.util.ArrayList;
import java.util.List;

public class ListaImplementation {
    public static void main(String[] args) {
        List<Carro> listCarro = new ArrayList<>();

        // Adicionando elementos à lista
        listCarro.add(new Carro("Ford"));
        listCarro.add(new Carro("Chevrolet"));
        listCarro.add(new Carro("Fiat"));
        listCarro.add(new Carro("Peugeot"));

        // 1. Verificando se a lista contém um elemento específico
        System.out.println("A lista contém um carro Ford? " + listCarro.contains(new Carro("Ford")));

        // 2. Obtendo um elemento pelo índice
        System.out.println("Carro na posição 2: " + listCarro.get(2));

        // 3. Obtendo o índice de um elemento específico
        System.out.println("Índice do carro Fiat: " + listCarro.indexOf(new Carro("Fiat")));

        // 4. Removendo um elemento pelo índice
        System.out.println("Removendo carro na posição 2: " + listCarro.remove(2));

        // 5. Exibindo a lista completa
        System.out.println("Lista após remoção: " + listCarro);

        // 6. Adicionando um elemento em uma posição específica
        listCarro.add(1, new Carro("Volkswagen"));
        System.out.println("Lista após adicionar Volkswagen na posição 1: " + listCarro);

        // 7. Substituindo um elemento em uma posição específica
        listCarro.set(0, new Carro("Honda"));
        System.out.println("Lista após substituir o primeiro carro por Honda: " + listCarro);

        // 8. Verificando o tamanho da lista
        System.out.println("Tamanho da lista: " + listCarro.size());

        // 9. Limpando todos os elementos da lista
        listCarro.clear();
        System.out.println("Lista após clear(): " + listCarro);

        // 10. Verificando se a lista está vazia
        System.out.println("A lista está vazia? " + listCarro.isEmpty());
    }
}
