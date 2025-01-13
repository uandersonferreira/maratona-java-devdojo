package dio.estruturas-de-dados.pilha.teste02;

public class Main {
    public static void main(String[] args) {

        /* Com a implementação do generics, passamos a restringir tornando mais seguro, pois agora 
         * ao adicionar novos elementos numa Fila, só será aceito os elementos do mesmo Tipo, não permitindo
         * elementos de tipos variados, como estava na primeira refatoração com o Object.
         * Basicamente é o que já temos com as List, Map, Set... do java, mas com um implementação própria   * nossa.
         */

        Fila<String> minhaFila = new Fila<>();

        minhaFila.enqueue("Primeiro");
        minhaFila.enqueue("Segundo");
        minhaFila.enqueue("Terceiro");
        minhaFila.enqueue("Quarto");
       //minhaFila.enqueue(1); // Não é mais aceito

    
        System.out.println(minhaFila);
        
        System.out.println(minhaFila.dequeue());
       
        System.out.println(minhaFila);
        
        minhaFila.enqueue("Último");

        System.out.println(minhaFila);

        System.out.println(minhaFila.first());
        
        System.out.println(minhaFila);
        


    }
}
