package estudo.uanderson.javadevdojo.javacore.Lclassesabstratas.dominio;

public abstract class Pessoa { // CLASSE A

    public abstract void imprime();

    /*
   REGRA: 
   - se tivemos uma classe abstrata A é uma outra classe B
    que estende/herda atributos e métodos da classe A,
    na classe B não é obrigatório implementar os metódos abstratos, mas as classes que herdam de B, obrigatóriamnete necessitam
    prove uma implementação para o(s) metodo(s) abstrato(s) da classe A.

    - Mas se caso a classe B, implementar os métodos abstratos da classe A, as subclasses de B não necessitam implementar os metodos, pois os metodos
    lhe são atribuidos diretamente, já que estão implementados em B.

   */



}//class
