package estudo.uanderson.javadevdojo.javacore.Eblocosdeinicializacao.dominio;

public class Anime {
    private String nome;
    private int[] episodios;

    //1°- È Alocado espaço em memória para o Objeto!
    //2°- Cada atributo de classe é criado e inicializado com valores default ou o quer dor pré-definidos.
    //3°- Bloco de Inicialização é executado
    //4° Construtor é executado


    //De instância, pois se refere a classe que está, sendo instanciada, portanto irá se criado
    //toda vez que se criar uma nova instância desse classe. ex: Anime anime = new Anime();
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
