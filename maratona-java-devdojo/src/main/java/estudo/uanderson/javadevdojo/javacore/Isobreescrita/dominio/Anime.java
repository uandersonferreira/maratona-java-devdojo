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
    -> O nome do método deve ser exatamente o mesmo do método da superclasse que está sendo sobrescrito.
    -> A quantidade e o tipo de parâmetros devem ser os mesmos (para que seja uma sobrescrita, e não uma sobrecarga).
    -> O tipo de retorno deve ser exatamente o mesmo ou uma subclasse do tipo original (covariância de retorno).
    -> E o modificador de acesso nunca pode ser mais restritivo do que o definido na classe que estamos
    herdando o método, ou seja, não podemos tirar os privilégios de um metodo herdado, mas podemos dar.      Por exemplo:
      - Um método `public` na superclasse não pode ser sobrescrito como `protected` ou `private`.
      - Um método `protected` na superclasse não pode ser sobrescrito como `private`.
    -> É opcional usar a anotação `@Override`, mas ela é altamente recomendada.
      - Garante que o método realmente sobrescreve um método da superclasse.
      - Ajuda a identificar erros de digitação ou inconsistências.

    Observação: Métodos marcados como `final`, `static` ou `private`  não podem ser sobrescritos.
    

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

