package estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.test;

import estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.dominio.Pessoa;

public class PessoaTeste01 {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa();

       // pessoa.nome="Uanderson";
        pessoa.setNome("Uanderson");
        pessoa.setIdade(19);

        //pessoa.imprime();

        System.out.println(pessoa.getNome());
        System.out.println(pessoa.getIdade());

    }//main

}//class

/*
Acoplamento é o quanto uma classe está conectada com a outra. Ou seja, o quanto
uma classe sabe/ tem acesso na outra classe.
Baixo acoplamento é bom, alto acoplamento é ruim.
Alta adesão é bom e baixa adesão é ruim.
 */