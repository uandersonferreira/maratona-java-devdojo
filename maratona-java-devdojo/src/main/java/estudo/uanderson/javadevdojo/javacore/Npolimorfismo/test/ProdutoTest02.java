package estudo.uanderson.javadevdojo.javacore.Npolimorfismo.test;

import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Computador;
import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Produto;
import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Tomate;

public class ProdutoTest02 {
    public static void main(String[] args) {
        Produto produto = new Computador("Rizen", 3000); //Upcasting
        System.out.println(produto.getNome());
        System.out.println(produto.getValor());
        System.out.println(produto.calcularImposto());
        System.out.println("----------------------------");

        Produto produto2 = new Tomate("Tomate Americano", 10); // Upcasting
        System.out.println(produto2.getNome());
        System.out.println(produto2.getValor());
        System.out.println(produto2.calcularImposto());

/*
Passamos a ter:
VARIÁVEL-DE-REFERÊNCIA nome_variavel = new OBJETO;
Produto produto = new Computador("Ryzen", 3000);

E não mais: OBJETO nome_variavel = new OBJETO;
Computador computador = new Computador("Ryzen", 3000);

Dessa forma, agora temos "muitas formas" de criar um mesmo objeto.

O que é Upcasting?
> Upcasting é quando você atribui um objeto de uma subclasse a uma referência de sua superclasse. Com isso, a referência perde acesso aos métodos e atributos específicos que não estão definidos na classe mais genérica (a superclasse), mas ainda mantém o comportamento da implementação real do objeto.

Exemplo:
Produto produto = new Computador("Ryzen", 3000);

Explicação:
- `Produto` é a superclasse.
- `Computador` é a subclasse.
- A variável de referência `produto` é do tipo `Produto`, mas aponta para um objeto `Computador`.

O que isso significa?
- A variável `produto` poderá acessar apenas os métodos e atributos definidos na classe `Produto`.
- Os métodos e atributos específicos da classe `Computador` não estarão acessíveis diretamente pela referência `produto`.

Por que usar Upcasting?
- Polimorfismo: Permite tratar objetos de diferentes subclasses de forma uniforme, através de referências da superclasse.
- Flexibilidade: Facilita a manutenção e expansão do código, pois você pode adicionar novas subclasses sem alterar o código que usa a superclasse.
*/

    }
}
