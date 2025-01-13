package estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.test;

import estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.dominio.Calculadora;

public class CalculadoraTest05 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        int[] numeros = {1,2,3,4,5};

        calculadora.somaArray(numeros);
        calculadora.somaVarArgs(1,2,3,4,5,6,7,8,9);// se passar tanto a referência do Array, quanto os proprios valores mesmo.

    }
}

/*

Regras e Restrições
Somente um Varargs por Método:

Um método pode ter apenas um parâmetro varargs.
Ele deve ser o último parâmetro na lista:

    public void metodoComVarargs(String nome, int... numeros) { }
    Incompatibilidade com Tipos Diferentes:

Todos os argumentos precisam ser do mesmo tipo (ou compatíveis por promoção de tipos).
Ambiguidade com Sobrecarga:

Métodos sobrecarregados com varargs podem levar a ambiguidades. Por exemplo:

public void metodo(int a, int b) { }
public void metodo(int... numeros) { }
Uma chamada como metodo(1, 2) pode causar conflito


 */
