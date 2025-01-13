package estudo.uanderson.javadevdojo.javacore.Isobreescrita.dominio;

public class Anime {
    String nome;

    public Anime(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "nome='" + nome + '\'' +
                '}';
    }
    /*
    Em uma sobreescrita de método:
    -o nome do método têm que ser o mesmo
    - A quantidade de paramentros passados têm que os mesmos
    -O tipo de retorno tem que ser extamente a classe ou alguma subclasse(covariância de retorno)
    - E o modificador de acesso nunca pode ser mais restritivo do que o definido na classe que estamos
    herdando o método, ou seja, não podemos tirar os privilégios de um metodo herdado, mas podemos dar.


     !ESTUDAR: PADRÕES DE PROJETO EM JAVA
     O Singleton é um padrão de projeto criacional, que garante
     que apenas um objeto desse tipo exista e forneça um único
     ponto de acesso a ele para qualquer outro código.
     */

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
