package estudo.uanderson.javadevdojo.javacore.ZZEstreams.test;

import estudo.uanderson.javadevdojo.javacore.ZZEstreams.domain.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest02 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Eleceed", 2.55),
            new LightNovel("Unordinary", 1.99),
            new LightNovel("Nano Machine", 2.99),
            new LightNovel("Fullmetal Alchemist", 3.99),
            new LightNovel("Martial Peark", 3.98),
            new LightNovel("Martial God Asura", 4.00)
    ));

    public static void main(String[] args) {
        List<String> titles = lightNovels.stream()
                .sorted(Comparator.comparing(LightNovel::getTitle))
                .filter(lightNovel -> lightNovel.getPrice() <= 4)
                .limit(3)
                .map(lightNovel -> lightNovel.getTitle())
                .collect(Collectors.toList());

        System.out.println(titles);
    }//main
}//class
/*
OPERAÇÕES INTERMEDIÁRIAS -> Uma ação que retorno o
 próprio Stream. Encadea as ações.
-> Algumas das operações intermediárias mais utilizadas são:
  filter(), map(), sorted(), limit() e distinct()

OPERAÇÕES TERMINAIS -> Esse tipo de operação pode ser identificado pelo
 tipo de retorno do método, uma vez que uma operação terminal nunca
 retorna uma interface Stream, mas sim um resultado
 (List, String, Long, Integer, etc.) ou void.

-> operação sorted(). Esse método retorna uma nova stream contendo
 os elementos da stream original ordenados de acordo com algum critério.

-> Limit Já o método limit() é utilizado para limitar o número de elementos
 em uma stream. É uma operação conhecida como curto-circuito devido ao fato
  de não precisar processar todos os elementos.

-> O método collect() possibilita coletar os elementos de uma stream
na forma de coleções, convertendo uma stream para os tipos List, Set ou Map

-> Diante de algumas situações se faz necessário realizar
transformações em uma lista de dados. O método map() permite
realizar essas mudanças sem a necessidade de variáveis
intermediárias, apenas utilizando como argumento uma função
do tipo java.util.function.Function, que, assim como Predicate<T>,
também é uma interface funcional. Essa função toma cada elemento
de uma stream como parâmetro e retorna o elemento processado como
resposta. O resultado será uma nova stream contendo os elementos
mapeados a partir da stream original.

Referência: https://www.oracle.com/br/technical-resources/articles/java-stream-api.html

 */