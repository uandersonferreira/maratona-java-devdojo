package estudo.uanderson.javadevdojo.javacore.Lclassesabstratas.dominio;

public abstract class Pessoa {

    public abstract void imprime();

    /*
   REGRA: se tivemos uma classe abstrata A é uma outra classe B
    que extendem/ herda atributos e metodos da classe A,
    na classe B não é obrigatorio implemnetar os metodos abstratos,
    mas as classes que herdam de B, obrigatóriamnete necessitam
    prove uma implementação para o(s) metodo(s) abstrato(s) da classe A.

    -Mas se caso a classe B, implemente os metodos abstratos da classe A,
    as subclasses de B, não necessitam implemnetar os metodos, pois os metodos
    le são atribuidos diretamente.



   */

}//class
