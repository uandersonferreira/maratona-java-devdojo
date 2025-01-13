package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListaArrayConversaoTest01 {
    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);

        Integer[] listToArray = numeros.toArray(new Integer[0]);// desempenho mais rápido
       // Integer[] listToArray = numeros.toArray(new Integer[numeros.size()]);
        System.out.println(Arrays.toString(listToArray));
        System.out.println("-------------------------------------");

        Integer[] numerosArray = new Integer[3];
        numerosArray[0] = 1;
        numerosArray[1] = 2;
        numerosArray[2] = 3;

        List<Integer> arrayToList = Arrays.asList(numerosArray);
        arrayToList.set(0,12);
        System.out.println("numerosArray: "+Arrays.toString(numerosArray));
        System.out.println("arrayToList:  "+arrayToList);
        System.out.println("-------------------------");

        //Forma de ser add um elemento na list sem quer de erro utilizando
        // o method asList();
        List<Integer> numerosList = new ArrayList<>(Arrays.asList(numerosArray));
        numerosList.add(15);
        System.out.println("numerosList:  "+numerosList);

        //Criar um arrayList em uma unica linha
        System.out.println("\n------Criar um arrayList em uma unica linha-----");
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Arrays.asList: "+integers);
        List<String> strings = List.of("1", "2", "2", "3");//method utilizado a partir do java 11
        System.out.println("List.of: "+strings);


    }
}
/*
o method asList() da class Arrays, cria um link com o array original, que
está sendo convertido em uma Lista.

E ao tentar add um elemnto na lista, utilizando o asList();
   List<Integer> arrayToList = Arrays.asList(numerosArray);
        arrayToList.set(0,12);
        arrayToList.add(15);

 Deve-se tomar cuidado pois irá gerar um erro "UnsupportedOperationException",
 poís não é permitido a alteração.


 */