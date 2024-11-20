package dio.estruturas-de-dados.pilha.teste02;

public class Main {
    public static void main(String[] args) {
        Fila minhaFila = new Fila();

        minhaFila.enqueue(new No("Primeiro"));
        minhaFila.enqueue(new No("Segundo"));
        minhaFila.enqueue(new No("Terceiro"));
        minhaFila.enqueue(new No("Quarto"));

        System.out.println(minhaFila);
        
        System.out.println(minhaFila.dequeue());
       
        System.out.println(minhaFila);
        
        minhaFila.enqueue(new No("ùltimo"));

        System.out.println(minhaFila);

        System.out.println(minhaFila.first());
        
        System.out.println(minhaFila);
        


    }
}
