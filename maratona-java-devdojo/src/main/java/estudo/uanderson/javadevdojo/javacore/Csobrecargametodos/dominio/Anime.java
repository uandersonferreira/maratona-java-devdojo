package estudo.uanderson.javadevdojo.javacore.Csobrecargametodos.dominio;

public class Anime {
    private String nome;
    private String tipo;
    private int episodios;
    private String genero;


 public void init(String nome, String tipo, int episodios){
     this.nome = nome;
     this.tipo = tipo;
     this.episodios = episodios;
 }

 public void init(String nome, String tipo, int episodios, String genero){
//     this.nome = nome;
//     this.tipo = tipo;
//     this.episodios = episodios;
     this.init(nome, tipo,episodios);
     this.genero = genero;
 }//método init sobrecarregado.

    public void imprime(){
        System.out.println(this.nome);
        System.out.println(this.tipo);
        System.out.println(this.episodios);
        System.out.println(this.genero);
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public int getEpisodios() {
        return episodios;
    }

    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }
}//class
