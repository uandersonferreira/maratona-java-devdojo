package estudo.uanderson.javadevdojo.javacore.Ycolecoes.test;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapTest01 {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();//Necessita de uma K -> key(Chave), V -> value (Valor);
        //LinkedHashMap mantém a ordem de inserção, HasMap não mantém.
        map.put("keyTeclado","teclado");
        map.put("keyMouse", "mouse");
        map.put("keyVc", "você");
        map.putIfAbsent("keyVc2", "você é lindo");//só vai add caso não exista e será ordenado de acordo com, o hasCode.
        System.out.println(map);

        //PODEMOS TER 2 TIPOS DE INTERAÇÃO NO MAP
        //1° KEY: map.keySet() Pela chave ser única, retorna um Set, de acordo, com o tipo da chave definida.
        //2° VALUES: map.values() retorna o tipo mais generico uma Collections, baseado no tipo do values definido
        System.out.println("-----CHAVE -> VALOR-------------");
        for (String key : map.keySet()) {
            System.out.println(key +" -> "+map.get(key) );
        }
        System.out.println("--------VALOR----------");

        for (String value : map.values()) {
            System.out.println(value);
        }
        System.out.println("--------CHAVE VALOR 2° FORMA----------");
        for (Map.Entry<String, String> mapEntry : map.entrySet()) {
            System.out.println(mapEntry.getKey()+ "-> "+mapEntry.getValue());
        }


    }//main
}//class

/*

        Ao tentar inserir um elemento com a mesma Key(Chave)
        utilizando o map,ele irá sobreescrever o Value do elemento já existente
        pelo que é inserido.
        Ex:
        map.put("keyTeclado","teclado");
        map.put("keyMouse", "mouse");
        map.put("keyVc", "você");
        map.put("keyVc", "você é lindo");

        Saída 1 Antes de Add: {keyMouse=mouse, keyTeclado=teclado, keyVc=você}
        Saída 2: {keyMouse=mouse, keyTeclado=teclado, keyVc=você é lindo}


         */