package estudo.uanderson.javadevdojo.javacore.Eblocosdeinicializacao.dominio;

public class Anime {
    // Os atributos de instância são criados e inicializados com valores padrão
    private String nome; // Valor padrão: null
    private int[] episodios; // Valor padrão: null (pois é uma referência)

    // Explicação sobre os passos de inicialização:
    // 1° - É alocado espaço em memória para o objeto.
    // 2° - Cada atributo de classe é criado e inicializado com valores padrão (ou valores pré-definidos).
    //     a. Tipos primitivos:
    //        - byte, short, int, long: 0
    //        - float, double: 0.0
    //        - char: '\u0000' (valor Unicode para o caractere nulo)
    //        - boolean: false
    //     b. Tipos de referência (objetos, arrays, etc.):
    //        - null
    // 3° - Bloco de inicialização é executado.
    // 4° - Construtor é executado.

    // Bloco de inicialização:
    // Este é um bloco de inicialização de instância, ou seja, será executado toda vez que
    // uma instância desta classe for criada. Exemplo: `Anime anime = new Anime();`.
    {
        System.out.println("Dentro do bloco de inicialização!");

        episodios = new int[100];

        for (int i = 0; i < episodios.length ; i++) {
            episodios[i] = i+1;
        }

    }//bloco de inicialização


    public Anime(String nome) {
        this.nome = nome;
    }//construtor

    public Anime() {

        for (int episodio: this.episodios){
            System.out.print(episodio + " ");
        }

        System.out.println();

    }//construtor


    public String getNome() {
        return nome;
    }

    public int[] getEpisodios() {
        return episodios;
    }
}//class
