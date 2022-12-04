package estudo.uanderson.javadevdojo.javacore.ZZDoptional.test;

import java.util.List;
import java.util.Optional;

public class OptionalTest01 {
    public static void main(String[] args) {
        Optional<String> optional1 = Optional.of("Uanderson Fodão!");
        //Optional<String> optional2 = Optional.of(null);//irá gerar um NullPointException, pois precisamos passar uma string ou informar que será passado um valor 'null'.
        Optional<String> optional3 = Optional.ofNullable(null);// Informando que será passado um valor Null
        Optional<String> optional4 = Optional.empty();// Informando que será criado um optional vazio

        System.out.println(optional1);
        System.out.println(optional3);
        System.out.println(optional4);
        System.out.println("-----------------------------");

        Optional<String> nameOptional = findName("Uanderson");
        String empty = nameOptional.orElse("Não encontrado!");
        System.out.println(empty);

        nameOptional.ifPresent(s -> System.out.println(s.toUpperCase()));

    }//main

    private static Optional<String> findName(String name){
        List<String> list = List.of("Uanderson", "DevDojo Boladão");
        int index = list.indexOf(name);
        //-1 Caso não encontre nada
        //Ou o index(posição na lista) do elemento que se está procurando

        if (index != -1){
            return Optional.of(list.get(index));
        }
        return Optional.empty();
    }//method findName


//    private static String findName(String name){
//        List<String> list = List.of("Uanderson", "DevDojo Boladão");
//        int index = list.indexOf(name);
//        //-1 Caso não encontre nada
//        //Ou o index(posição na lista) do elemento que se está procurando
//
//        if (index != -1){
//            return list.get(index);
//        }
//        return null;
//    }//method findName

}//class

/*
Optional é uma class que tenta evitar um nullPointException
Pois ao invés de retornar null, retorna-se uma Optional.

OBS: não é recoemndavél a criação de atributos e nem a passagem de paramentros,
do tipo Optional. pois não é uma class serializada, por isso é mais indicada quando
que ser retornar algo diferente de null.

 - Optional<String> name;
 - public void name(Optional<Integer> num){
  }


 */