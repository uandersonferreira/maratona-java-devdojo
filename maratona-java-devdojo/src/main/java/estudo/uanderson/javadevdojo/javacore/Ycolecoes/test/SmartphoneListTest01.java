package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneListTest01 {
    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC1", "IPHONE");
        Smartphone s2 = new Smartphone("2BFG2", "PIXEL");
        Smartphone s3 = new Smartphone("4GHL5", "SAMSUNG");
        List<Smartphone> smartphones = new ArrayList<>();
        smartphones.add(s1);
        smartphones.add(s2);
        smartphones.add(s3);

        //Collections.sort(smartphones);//dar erro pois o java não consegue definir por qual atributo de referencia irá usar para ordenar


       // smartphones.clear();//apagar tudo que está contido na lista, sem perder a referência em memória.
        for (Smartphone smartphone : smartphones) {
            System.out.println(smartphone);
        }
        Smartphone s4 = new Smartphone("4GHL5", "SAMSUNG");
        System.out.println("isExist: "+smartphones.contains(s4));//verificar ser existe algum objeto igual na lista
        //por debaixo dos panos está usando o metodo equals() sobreescrito na class Smartphone;
        int indexOfSmartphone = smartphones.indexOf(s4);
        System.out.println("indexOfSmartphone: "+indexOfSmartphone);//se o object existir retorna seu index na list, caso contrário retorna -1(não existe na lista)
        System.out.println("Object Encontrado: "+smartphones.get(indexOfSmartphone));// se tentar pegar um objeto que não existe gera a exception IndexOutOfBoundsException


    }
}
