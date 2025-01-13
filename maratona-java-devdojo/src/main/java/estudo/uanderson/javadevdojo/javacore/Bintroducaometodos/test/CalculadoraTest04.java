package estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.test;

import estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.dominio.Calculadora;

public class CalculadoraTest04 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        int a = 1;
        int b = 2;

        calculadora.alterandoDoisNumeros(a,b);

        System.out.println("Dentro da classe CalculadoraTest04");
        System.out.println("Num1: "+a);
        System.out.println("Num2: "+b);

/*
Quando estamos, passando variáveis do tipo primitivo, sempre será
passado UMA CÓPIA do VALOR da variável, portanto o valor original nunca será alterado.
ex:     int a = 1;
        int b = 2;

        calculadora.alterandoDoisNumeros(a,b);

        Ou seja, quando chama o método alterandoDoisNumeros, as variáveis
        a e b, que deveriam alterar os valores, não alteram.

 */

    }
}

