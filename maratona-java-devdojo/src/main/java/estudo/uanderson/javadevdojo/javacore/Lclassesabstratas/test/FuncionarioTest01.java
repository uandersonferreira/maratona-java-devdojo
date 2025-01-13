package estudo.uanderson.javadevdojo.javacore.Lclassesabstratas.test;

import estudo.uanderson.javadevdojo.javacore.Lclassesabstratas.dominio.Desenvolvedor;
import estudo.uanderson.javadevdojo.javacore.Lclassesabstratas.dominio.Gerente;

public class FuncionarioTest01 {
    public static void main(String[] args) {
        Gerente gerente = new Gerente("Maria", 2000);
        Desenvolvedor desenvolvedor = new Desenvolvedor("Uanderson", 5000);
        System.out.println(gerente);
        System.out.println(desenvolvedor);

        //Demonstrando o segundo caso da REGRA das classes abstratas
        gerente.imprime();
        desenvolvedor.imprime();

    }//main
}//class
