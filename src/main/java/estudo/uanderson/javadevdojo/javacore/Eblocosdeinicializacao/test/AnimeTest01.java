package estudo.uanderson.javadevdojo.javacore.Eblocosdeinicializacao.test;

import estudo.uanderson.javadevdojo.javacore.Eblocosdeinicializacao.dominio.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime = new Anime("One piece");

        //alt + enter Para criar um foreach mais rápido!
        for (int episodio : anime.getEpisodios()) {
            System.out.print(episodio + " ");
        }



    }//main
}//class
