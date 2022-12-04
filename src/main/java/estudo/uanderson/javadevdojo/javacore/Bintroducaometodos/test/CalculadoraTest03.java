package estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.test;

import estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.dominio.Calculadora;

public class CalculadoraTest03 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

     double result = calculadora.divideDoisNumeros(20,10);

        System.out.println(result);//ou poderia imprimir direto.
        System.out.println(calculadora.divideDoisNumeros(20,10));
        System.out.println("----------------------");

        calculadora.imprimeDivideDoisNumeros(35,0);
    }

    /*
    Obs: se tentamos imprimir uma chamada de método do tipo void dentro de um println
    não irá funcionar, pois o método println necessida de algo(valor) para imprimir.
    ex:
            System.out.println(calculadora.imprimeDivideDoisNumeros(35,0));

     */
}
