package estudo.uanderson.javadevdojo.javacore.Hheranca.test;

import estudo.uanderson.javadevdojo.javacore.Hheranca.dominio.Funcionario;

public class HerancaTest02 {
    //0 - Bloco de Inicialização estático da super classe é executado quando a JVM carregar a super classe.
    //1°- Bloco de Inicialização estático da sub classe é executado quando a JVM carregar a sub classe
    //2°- È Alocado espaço em memória para o Objeto da super Classe
    //3°- Cada atributo de super classe é criado e inicializado com valores default ou o quer for passados da super classe.
    //4°- Bloco de Inicialização da superclasse é executado na ordem em que aparece.
    //5° Construtor da super classe é executado
    //6°- È Alocado espaço em memória para o Objeto da sub Classe
    //7°- Cada atributo da sub Classe é criado e inicializado com valores default ou o quer for passados.
    //8°- Bloco de Inicialização da sub Classe é executado na ordem em que aparece.
    //9° Construtor da sub Classe é executado
    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Jiraya");
    }
}
