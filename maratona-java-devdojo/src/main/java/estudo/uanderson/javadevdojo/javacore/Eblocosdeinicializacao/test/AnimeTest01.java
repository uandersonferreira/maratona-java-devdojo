package estudo.uanderson.javadevdojo.javacore.Eblocosdeinicializacao.test;

import estudo.uanderson.javadevdojo.javacore.Eblocosdeinicializacao.dominio.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        // Criação de um objeto da classe Anime com o nome "One Piece".
        // Isso chama o construtor com argumento `Anime(String nome)`, que inicializa o atributo `nome`.
        Anime anime = new Anime("One Piece");

        // Criação de outro objeto da classe Anime, mas utilizando o construtor sem argumentos.
        // Este construtor (`Anime()`) não recebe parâmetros e apenas imprime os valores do array `episodios`,
        // que foi inicializado no bloco de inicialização da classe Anime.
        Anime anime2 = new Anime(); // Chama o construtor sem argumentos.

        // Laço de repetição `for-each` para iterar sobre os valores do array `episodios` do primeiro objeto `anime`.
        // A variável `episodio` assume, a cada iteração, o valor de um elemento do array retornado por `anime.getEpisodios()`.
        // O atalho Alt + Enter (no IntelliJ IDEA, por exemplo) pode ser usado para criar esse tipo de loop rapidamente.
        for (int episodio : anime.getEpisodios()) {
            System.out.print(episodio + " "); // Imprime cada valor do array na mesma linha, separado por espaços.
        }

        /*
        Fluxo completo do código:
        1. O objeto `anime` é criado com o nome "One Piece".
           - O bloco de inicialização é executado primeiro, inicializando o array `episodios` com valores de 1 a 100.
           - O construtor com o argumento `String nome` é executado, atribuindo "One Piece" ao atributo `nome`.

        2. O objeto `anime2` é criado usando o construtor sem argumentos.
           - O bloco de inicialização é executado, inicializando o array `episodios`.
           - O construtor sem argumentos é executado, iterando e imprimindo os valores do array `episodios` no console.

        3. O `for-each` percorre o array `episodios` do primeiro objeto `anime` e imprime seus valores no console.

        Resultado esperado no console:
        - Durante a criação de `anime`: "Dentro do bloco de inicialização!"
        - Durante a criação de `anime2`: "Dentro do bloco de inicialização!" seguido pelos valores de 1 a 100.
        - Durante o `for-each`: os valores de 1 a 100 na mesma linha, separados por espaços.
        */
    } // main
} // class



