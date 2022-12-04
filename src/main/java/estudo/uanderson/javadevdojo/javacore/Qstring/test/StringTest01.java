package estudo.uanderson.javadevdojo.javacore.Qstring.test;

public class StringTest01 {
    public static void main(String[] args) {
        //string interning
        String nome = "Uanderson";
        String nome2 = "Uanderson";
        System.out.println(nome == nome2 );//estamos validando a referencia em memória, não as strings em si
// True, pois as váriaveis fazem referencia a mesma string criada no pool de string, pois não se duplica uma string já criada no pool de string"

        nome = nome.concat(" Ferreira"); //ou nome += "Ferreira";
        System.out.println(nome);
        System.out.println(nome == nome2);//false, pois estamos associando a váriavel nome = o resultado da concatenação
        //no pool é criado uma string- "Ferreira" e "Uanderson Ferreira"(resultado do concat)

        String nome3 = new String("Uanderson");
        //1 váriavel de referencia está sendo criada, 2 objeto do tipo string na área do heap, 3 uma string no pool de string

        System.out.println(nome2 == nome3);//false pois as váriaveis de objetos criadas, são alocadas fora do pool de string
        System.out.println(nome2 == nome3.intern());//true, pois estamos comparando a váriavel nome que faz referencia a string "Uanderson" no pool de string + a referencia da váriavel de objeto nome3, que também faz refencia a string "Uanderson" no pool de string

    }//main

}//class
/*
Strings são imuntáveis, é são criadas no pool de strings
na área do heap(pilha).

Strings literais, são criadas no pool de string: String nome = "Uanderson";

-Aula 109
 */