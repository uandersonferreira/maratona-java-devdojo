package estudo.uanderson.javadevdojo.javacore.Zgenerics.test;

import estudo.uanderson.javadevdojo.javacore.Ycolecoes.domain.Manga;
import estudo.uanderson.javadevdojo.javacore.Zgenerics.domain.Barco;

import java.util.List;

public class MetodoGenericoTest01 {
    public static void main(String[] args) {

        criarArrayComUmObjeto(new Barco("Lancha Marota"));

     List<Barco> lanchaMarota = criarArrayComUmObjeto2(new Barco("Lancha Marota"));
        System.out.println("2° Ex: "+lanchaMarota);

        List<Manga> mangas = criarArrayComUmObjeto3(new Manga(5L, "Boruto", 35.25));
        System.out.println("3° Ex: "+mangas);


    }//main

    private static <T> void criarArrayComUmObjeto(T typeObject){
        List<T> list = List.of(typeObject);
        System.out.println("1° Ex: "+list);
    }

    private static <T> List<T> criarArrayComUmObjeto2(T typeObject){
        return List.of(typeObject);
    }

  private static <T extends Comparable> List<T> criarArrayComUmObjeto3(T typeObject){
        return List.of(typeObject);
    }

}//class


//-----------------------///------------------///----------------
//casso a class não implemenete o comparable um erro é gerado, no caso a classe barco não implementa o Comparable, mas o
// objetivo era demonstrar como fazer um metodo generico que extende de uma classe.
