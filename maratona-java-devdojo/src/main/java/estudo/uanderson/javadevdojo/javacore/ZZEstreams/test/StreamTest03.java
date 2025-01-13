package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest03 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Eleceed", 2.55),
            new LightNovel("The Challegen", 3.00),
            new LightNovel("Unordinary", 10.00),
            new LightNovel("Nano Machine", 2.99),
            new LightNovel("Fullmetal Alchemist", 2.55),
            new LightNovel("Martial Peark", 3.98),
            new LightNovel("Martial Peark", 3.98),
            new LightNovel("Martial God Asura", 4.00)
    ));

    public static void main(String[] args) {
        Stream<LightNovel> stream = lightNovels.stream();
        lightNovels.forEach(System.out::println);
      // long count = stream.filter(ln -> ln.getPrice() <= 4).count();
       // A ordem de declaração importa!
        long count2 = lightNovels.stream()
                .distinct()
                .filter(ln -> ln.getPrice() <= 4)
                .count();

        System.out.println("count2(): "+count2);

    }//main
}//class
/*
stream().forEach() - Operação Terminal/ acaba sendo um má prática
por está dispediçando processomente.
forEach() -> Somente um method da Interface Iterable/Forma recomendavél

OPERAÇÕES TERMINAIS -> Esse tipo de operação pode ser identificado pelo
 tipo de retorno do método, uma vez que uma operação terminal nunca
 retorna uma interface Stream, mas sim um resultado
 (List, String, Long, Integer, etc.) ou void.

 -> Quando fechamos uma stream não podemos trabalhar mais com ela,
 caso contrário irá gerar o seguinte erro:
 "stream has already been operated upon or closed"
 Neste caso devemos temos que pegar a origem da stream novamente.
 ex: lightNovels.stream();


-> ForEach Através do método forEach() é possível realizar
um loop sobre todos os elementos de uma stream e executar
algum tipo de processamento.

-> A operação distinct() retorna uma stream contendo apenas
elementos que são exclusivos, isto é, que não se repetem,
de acordo com a implementação do método equals().

-> Filter O método filter() é usado para filtrar elementos de
 uma stream de acordo com uma condição (predicado). Para isso,
 ele recebe como parâmetro um objeto que implementa a
 interface Predicate<T> (interface funcional que define uma
 função com valor de retorno igual a um boolean) e retorna
 uma nova stream contendo apenas os elementos que satisfazem à condição.

-> Count O método count() retorna a quantidade de elementos
 presentes em uma stream.

Referência: https://www.oracle.com/br/technical-resources/articles/java-stream-api.html
 */
