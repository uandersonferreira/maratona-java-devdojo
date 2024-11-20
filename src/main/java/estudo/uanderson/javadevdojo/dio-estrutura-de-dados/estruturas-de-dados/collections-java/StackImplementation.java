package dio.estruturas-de-dados.equals-hash-code;

import java.util.Stack;

public class StackImplementation {
    public static void main(String[] args) {
        Stack<Carro> stackCarros = new Stack<>();

        // 1. Adicionando elementos à pilha
        stackCarros.push(new Carro("Ford"));
        stackCarros.push(new Carro("Chevrolet"));
        stackCarros.push(new Carro("Fiat"));

        // 2. Exibindo a pilha completa
        System.out.println("Pilha atual: " + stackCarros);
        
        // 3. Removendo o elemento do topo da pilha
        System.out.println("\nRemovendo do Topo: " + stackCarros.pop());
        System.out.println("Pilha após pop(): " + stackCarros);
        
        // 4. Lendo o elemento no topo sem removê-lo
        System.out.println("\nElemento no topo (peek): " + stackCarros.peek());
        System.out.println("Pilha após peek(): " + stackCarros);
        
        // 5. Verificando se a pilha está vazia
        System.out.println("\nA pilha está vazia? " + stackCarros.empty());

        // 6. Adicionando mais elementos
        stackCarros.push(new Carro("Volkswagen"));
        stackCarros.push(new Carro("Peugeot"));
        System.out.println("\nPilha após adicionar Volkswagen e Peugeot: " + stackCarros);

        // 7. Verificando a posição de um elemento na pilha
        System.out.println("\nPosição do carro Volkswagen na pilha: " + stackCarros.search(new Carro("Volkswagen")));

        // 8. Removendo todos os elementos da pilha
        while (!stackCarros.empty()) {
            System.out.println("Removendo: " + stackCarros.pop());
        }
        System.out.println("Pilha após remover todos os elementos: " + stackCarros);

        // 9. Tentando acessar o topo de uma pilha vazia
        try {
            System.out.println("Tentando acessar o topo de uma pilha vazia: " + stackCarros.peek());
        } catch (Exception e) {
            System.out.println("Erro ao acessar o topo: " + e.getMessage());
        }
    }
}
