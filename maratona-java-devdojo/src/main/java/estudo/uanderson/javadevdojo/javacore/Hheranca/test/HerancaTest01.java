package estudo.uanderson.javadevdojo.javacore.Hheranca.test;

import estudo.uanderson.javadevdojo.javacore.Hheranca.dominio.Endereco;
import estudo.uanderson.javadevdojo.javacore.Hheranca.dominio.Funcionario;
import estudo.uanderson.javadevdojo.javacore.Hheranca.dominio.Pessoa;

public class HerancaTest01 {
    public static void main(String[] args) {
        Endereco endereco = new Endereco();

        endereco.setRua("Rua 03");
        endereco.setCep("77060-342");

        Pessoa pessoa = new Pessoa("Uanderson");

        pessoa.setCpf("11111111111");
        pessoa.setEndereco(endereco);
        pessoa.imprime();
/*
Criando um objeto da sub-classe que extends atributos e métodos da superClasse(Person)
para realizar a chamada desses atributos utiliza o método set criado na superClasse

 */
        Funcionario funcionario = new Funcionario("João");

        funcionario.setCpf("22222222222");
        funcionario.setEndereco(endereco);


    }
}
