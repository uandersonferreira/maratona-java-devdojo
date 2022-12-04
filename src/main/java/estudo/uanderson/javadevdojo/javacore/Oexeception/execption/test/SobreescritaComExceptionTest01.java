package estudo.uanderson.javadevdojo.javacore.Oexeception.execption.test;

import estudo.uanderson.javadevdojo.javacore.Oexeception.execption.dominio.Funcionario;
import estudo.uanderson.javadevdojo.javacore.Oexeception.execption.dominio.Pessoa;

public class SobreescritaComExceptionTest01 {
    public static void main(String[] args) {
        Pessoa  pessoa = new Pessoa();
        Funcionario funcionario = new Funcionario();

         funcionario.salvar();

    }
}
