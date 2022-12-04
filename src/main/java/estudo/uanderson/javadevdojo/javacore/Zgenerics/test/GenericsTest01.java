package estudo.uanderson.javadevdojo.javacore.Zgenerics.test;

import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Consumidor;

import java.util.ArrayList;
import java.util.List;

public class GenericsTest01 {
    public static void main(String[] args) {
   List<String> lista = new ArrayList<>();

   lista.add("Uanderson");
   lista.add("Ferreira");

        for (String s : lista) {
            System.out.println(s);
        }
        System.out.println("------------------");

        add(lista, new Consumidor("Oliveira"));

//utilizamos Object pois o method add criado possui argurmentos que pode
// não ser do tipo da Lista definida. Caso contrário geraria uma Exception "ClassCastException"


        for (Object s : lista) {
            System.out.println(s);
        }

    }//main

    private static void add(List lista, Consumidor consumidor){
        lista.add(consumidor);

    }
    //aula 184

}//class

  /*
  Obs:
  O CONCEITO TYPE ERASURE -> SIGNIFICA APAGA O TIPO DEPOIS QUE O CODIGO É COMPILADO.

  FORMA ANTIGA DE SER CRIAR UMA LISTA ->  List lista = new ArrayList();

  NO ENTANTO, AINDA É A FORMA COMO O JAVA INTERPRETA UMA LISTA, POIS O
  CONCEITO TYPE ERASURE -> SIGNIFICA APAGA O TIPO DEPOIS QUE O CODIGO É COMPILADO.
  E POR MAIS QUE SE USE O GENERICS EM TEMPO DE EXECUÇÃO, AO REALIZAR A COMPILAÇÃO O TIPO DOS
  ELEMENTOS ACEITOS NA LISTA SÃO APAGADOS, A FIM DE MANTER A COMPATIBILIDADE.

  O GENERICS APENAS FORÇA O COMPILADOR A NÃO ACEITAR
  ELEMENTOS DE TIPOS DIFERENTES DO QUE FOI DEFINIDO ENTRE OS < > FAZENDO COM QUE,
  O PROGRAMADOR DEFINA UMA LISTA SOMENTE DE 1 TIPO. EX: STRING, DOUBLE, CONSUMIDOR....


       List lista = new ArrayList();

       lista.add("Uanderson");
       lista.add(155L);
       lista.add(new Consumidor("Maria"));

        for (Object o : lista) {
            if (o instanceof String){
                System.out.println(o);
            }
            if (o instanceof Long){
                System.out.println(o);
            }
            if (o instanceof Consumidor){
                Consumidor c = (Consumidor) o;
                System.out.println(c);
            }
        }
   */