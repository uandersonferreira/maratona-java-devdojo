package estudo.uanderson.javadevdojo.javacore.Npolimorfismo.test;

import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Computador;
import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Televisao;
import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Tomate;
import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.servico.CalculadoraImposto;

public class ProdutoTest01 {
    public static void main(String[] args) {
        Computador computador = new Computador("NUC10i7", 5000);
        Tomate tomate = new Tomate("TomateX", 9);
        Televisao tv = new Televisao("Samsung 50\"",2500 );

        CalculadoraImposto.calcularImposto(computador);

        System.out.println("---------------------------");

        CalculadoraImposto.calcularImposto(tomate);

        System.out.println("---------------------------");

        CalculadoraImposto.calcularImposto(tv);

    }//main
}//class
