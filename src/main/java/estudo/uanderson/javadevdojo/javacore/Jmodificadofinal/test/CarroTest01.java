package estudo.uanderson.javadevdojo.javacore.Jmodificadofinal.test;

import estudo.uanderson.javadevdojo.javacore.Jmodificadofinal.dominio.Carro;
import estudo.uanderson.javadevdojo.javacore.Jmodificadofinal.dominio.Ferrari;

public class CarroTest01 {
    public static void main(String[] args) {

        Carro carro = new Carro();
        System.out.println( Carro.VELOCIDADE_LIMITE);

        System.out.println(carro.COMPRADOR);
        //alterando o valor da váriavel
        carro.COMPRADOR.setNome("Kayden");
        System.out.println(carro.COMPRADOR);

        Ferrari ferrari = new Ferrari();
        ferrari.setNome("Ferrari 2022");
        ferrari.imprime();




        /*
        Quando temos váriaveis staticas(de classe) é sempre recomendado
        acessa-lás, utilizando o nome da classe é não através da váriavel
        de referencia do objeto da classe estanciado. Conforme, demonstrado acima.

         */

    }
}
