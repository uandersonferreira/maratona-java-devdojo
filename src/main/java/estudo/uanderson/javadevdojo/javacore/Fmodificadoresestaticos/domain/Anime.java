package estudo.uanderson.javadevdojo.javacore.Fmodificadoresestaticos.domain;

public class Anime {
    private String nome;
    private static int[] episodios;

    //0 - Bloco de Inicialização static é executado quando a JVM carregar a classe.
    //1°- È Alocado espaço em memória para o Objeto!
    //2°- Cada atributo de classe é criado e inicializado com valores default ou o quer dor pré-definidos.
    //3°- Bloco de Inicialização é executado
    //4° Construtor é executado

    //sterequé
    static {
        System.out.println("Dentro do bloco de inicialização estático 1");
        episodios = new int[100];

        for (int i = 0; i < episodios.length; i++) {
            episodios[i] = i + 1;
        }
    }//bloco de inicialização

 /*
 Obs. Os blocos de inicialização serão agora carregados apenas uma vez, ao se criar
 outras instâncias do Objeto. Ex: Anime anime = new Anime();
  E é permitido a criação de blocos de inicialização não estáticos junto, com os estáticos.
  */


    static {
        System.out.println("Dentro do bloco de inicialização estático 2");
    }//bloco de inicialização

    {
        System.out.println("Dentro do bloco de inicialização NÃO ESTÁTICO");
    }//bloco de inicialização

    static {
        System.out.println("Dentro do bloco de inicialização estático 3");
    }//bloco de inicialização


    public Anime(String nome) {
        this.nome = nome;
    }//construtor

    public Anime() {

        for (int episodio : Anime.episodios) {
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
