package estudo.uanderson.javadevdojo.javacore.Dconstrutor.test;

import estudo.uanderson.javadevdojo.javacore.Dconstrutor.dominio.Anime;

public class AnimeTest01 {
    public static void main(String[] args) {
        Anime anime = new Anime("Naruto Shippuden","TV",601,"Ação");

      //  anime.init("Naruto Shippuden","TV",601,"Ação");
        anime.imprime();


    }//main
}//class
