package estudo.uanderson.javadevdojo.javacore.Qstring.test;

public class StringTest01 {
    public static void main(String[] args) {
        //string interning
        String nome = "Uanderson"; //string constant pool
        String nome2 = "Uanderson";
        
        // Comparando valores de Strings
        System.out.println(nome.equals(nome2));

        // Comparando referências
        System.out.println(nome == nome2 );
        /* 
        - Estamos validando a referencia em memória, não as strings em si.
        - True: pois as váriaveis fazem referência a mesma string criada no 
          pool de string, pois não se duplica uma string já criada no pool de string, logo
          As variáveis apontam para a mesma instância no pool de strings

         */

        nome = nome.concat(" Ferreira"); //ou nome += "Ferreira";
        System.out.println(nome); // Resultado: "Uanderson Ferreira"
        System.out.println(nome == nome2);
        /*
        False: pois estamos associando a váriavel nome o resultado da concatenação
        que fica Uanderson Ferreira, logo no pool de string e criado uma nova String com o valor
        "Uanderson Ferreira" (resultado do concat) e então 'nome' deixa de aponta para a string "Uanderson".
        */

        String nome3 = new String("Uanderson");
        // 1. váriavel de referencia está sendo criada no heap
        // 2. Um objeto do tipo String e alocado na área do heap
        // 3. E depois e criado um literal "Uanderson" no pool de strings (se já não existir).

        System.out.println(nome2 == nome3);
        // False: pois as váriaveis de objetos criadas, são alocadas fora do pool de string
        // Logo: 'nome2' aponta para o pool de strings, enquanto 'nome3' aponta para o heap.


        System.out.println(nome2 == nome3.intern());
        /* 
         True: pois estamos comparando a váriavel nome2 que faz referencia a string "Uanderson" no pool de string + a referencia do valor da váriavel de objeto nome3, que também faz refencia a string "Uanderson" no pool de string
        
        - OBS: 'intern()' retorna a referência do literal no pool de strings.

        Explicação sobre intern():
         - Quando chamamos 'nome3.intern()', a JVM verifica se o conteúdo da String
           já está presente no pool. Caso esteja, retorna a referência do pool.

         */

    }//main

}//class
/*
Strings são imuntáveis, é são criadas no pool de strings
na área do heap(pilha).

Strings literais, são criadas no pool de string: String nome = "Uanderson";

 */