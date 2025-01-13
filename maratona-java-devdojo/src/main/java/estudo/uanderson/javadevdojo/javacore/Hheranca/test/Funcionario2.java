package estudo.uanderson.javadevdojo.javacore.Hheranca.test;

import estudo.uanderson.javadevdojo.javacore.Hheranca.dominio.Pessoa;

public class Funcionario2 extends Pessoa {

    public Funcionario2(String nome) {
        super(nome);
    }



    public void imprime(){
        super.imprime();
        System.out.println("Demostrando que é possível realizar o acesso direto " +
                "ao atributo nome da super-classe Person.");

        this.nome = "Sasha";

        System.out.println(nome);
        super.imprime();

    }
}
