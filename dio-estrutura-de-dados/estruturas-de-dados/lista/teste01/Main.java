package dio.estruturas-de-dados.lista.teste01;

public class Main {
    public static void main(String[] args) {
        ListaEncadeada<String> minhaListaEncadeada = new ListaEncadeada();

        minhaListaEncadeada.add("test1");//0
        minhaListaEncadeada.add("test2");//1
        minhaListaEncadeada.add("test3");//2
        minhaListaEncadeada.add("test4");//3
        minhaListaEncadeada.add("test5");//4


        System.out.println(minhaListaEncadeada.get(0)); 
        System.out.println(minhaListaEncadeada.get(1));
        System.out.println(minhaListaEncadeada.get(2));
        System.out.println(minhaListaEncadeada.get(3));
        //System.out.println(minhaListaEncadeada.get(5)); lança o erro pois não existe o index 5
        
       System.out.println(minhaListaEncadeada);
       
       System.out.println(minhaListaEncadeada.remove(2));

       System.out.println(minhaListaEncadeada);
    }
}
