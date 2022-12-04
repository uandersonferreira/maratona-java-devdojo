package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapTest01 {
    public static void main(String[] args) {
        //AS MESMA REGRAS DO Navigable COM SET VALEM POR NavigableMap
        NavigableMap<String, String> navigableMap = new TreeMap();
        navigableMap.put("A", "Letra A");
        navigableMap.put("D", "Letra D");
        navigableMap.put("B", "Letra B");
        navigableMap.put("C", "Letra C");
        navigableMap.put("E", "Letra E");

        for (Map.Entry<String, String> entry : navigableMap.entrySet()) {
            System.out.println(entry.getKey()+" -> "+entry.getValue());
        }
        //lower <  retorna o 1° elemento menor contido numa coleção em relação ao obj de comparação
        //floor <= retorna o 1° elemento menor ou igual contido numa coleção em relação ao obj de comparação
        //higher > retorna o 1° elemento maior contido numa coleção em relação ao obj de comparação
        //ceiling >=  retorna o 1° elemento maior ou igual contido numa coleção em relação ao obj de comparação

        System.out.println("===========================");
        System.out.println("TUDO ABAIXO DA KEY PASSADA: "+navigableMap.headMap("C"));// retorna tudo que estiver abaixo da key Passada
        System.out.println("TUDO ABAIXO DA KEY PASSADA INCLUINDO ELA MESMA:"+navigableMap.headMap("C", true));// retorna tudo que estiver abaixo da key Passada, incluindo ela também.
        System.out.println("lowerKey: "+navigableMap.lowerKey("C"));
        System.out.println("higherKey: "+navigableMap.higherKey("C"));
        System.out.println("floorKey: "+navigableMap.floorKey("C"));
        System.out.println("ceilingKey: "+navigableMap.ceilingKey("C"));


    }
}
