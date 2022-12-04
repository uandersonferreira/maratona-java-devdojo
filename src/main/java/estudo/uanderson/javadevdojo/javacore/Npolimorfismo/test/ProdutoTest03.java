package estudo.uanderson.javadevdojo.javacore.Npolimorfismo.test;

import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Computador;
import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Produto;
import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Tomate;
import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.servico.CalculadoraImposto;

public class ProdutoTest03 {
    public static void main(String[] args) {
        Produto produto = new Computador("Rizen", 3000);

        Tomate tomate = new Tomate("Tomate Americano", 10);
        tomate.setDataDeValidade("12/05/2022");

        CalculadoraImposto.calcularImposto(tomate);
        System.out.println("----------------------------");
        CalculadoraImposto.calcularImposto(produto);
    }
}
