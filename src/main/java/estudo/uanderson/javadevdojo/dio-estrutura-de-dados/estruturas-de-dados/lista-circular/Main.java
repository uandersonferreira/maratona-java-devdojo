package dio.estruturas-de-dados.lista-circular;

public class Main {
    public static void main(String[] args) {
        ListaCircular<String> minhaListaCircular = new ListaCircular();

        minhaListaCircular.add("c0");
        
        System.out.println(minhaListaCircular);
               
        minhaListaCircular.remove(0);

        System.out.println(minhaListaCircular);
        
         minhaListaCircular.add("c1");
         minhaListaCircular.add("c2");
         minhaListaCircular.add("c3");
         
       System.out.println(minhaListaCircular);
        
       System.out.println(minhaListaCircular.get(0)); // c1

       System.out.println(minhaListaCircular.get(1)); // c2
       
       System.out.println(minhaListaCircular.get(2)); // c3
 
       System.out.println(minhaListaCircular.get(3)); // entra em loop e começa novamente pela cauda é retorna c3
    
        /*
           Aqui percebemos o porque de uma lista circular, pois cada vez que chega na cabeça
           ele retorna para a cauda e começa tudo novamente.
        */
         
         
    }
}