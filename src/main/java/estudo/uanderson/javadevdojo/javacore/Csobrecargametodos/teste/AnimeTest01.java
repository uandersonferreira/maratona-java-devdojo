package estudo.uanderson.javadevdojo.javacore.Csobrecargametodos.teste;

import estudo.uanderson.javadevdojo.javacore.Csobrecargametodos.dominio.Anime;

public class AnimeTest01{
    public static void main(String[] args) {
        Anime anime = new Anime();

        anime.init("Naruto Shippuden","TV",601,"Ação");
        anime.imprime();


    }//main
}//class
