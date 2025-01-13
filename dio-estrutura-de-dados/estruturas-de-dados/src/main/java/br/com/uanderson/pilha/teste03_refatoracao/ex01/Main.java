package br.com.uanderson.pilha.teste03_refatoracao.ex01;

public class Main {
    public static void main(String[] args) {
        Fila minhaFila = new Fila();

        minhaFila.enqueue("Primeiro");
        minhaFila.enqueue("Segundo");
        minhaFila.enqueue("Terceiro");
        minhaFila.enqueue("Quarto");
        minhaFila.enqueue(100); 
        minhaFila.enqueue(true);
        //Dessa forma que está, aceita qualquer tipo de Object, isso pode gerar alguns erros principalmente por causa de se está lidando com uma Fila de aceita diferentes tipos de dados.

        System.out.println(minhaFila);
        
        System.out.println(minhaFila.dequeue());
       
        System.out.println(minhaFila);
        
        minhaFila.enqueue("Último");

        System.out.println(minhaFila);

        System.out.println(minhaFila.first());
        
        System.out.println(minhaFila);
        


    }
}
