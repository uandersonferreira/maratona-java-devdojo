package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ResolveTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("home/uanderson");//caminho relativo
        Path arquivo = Paths.get("dev/arquivoTest.txt");
        //resolve irá unir dois caminhos separados(paths)
        Path resolve = dir.resolve(arquivo);
        System.out.println(resolve);

        Path absoluto = Paths.get("/home/uanderson");
        Path relativo = Paths.get("dev");
        Path file = Paths.get("file.txt");

        System.out.println("---------Absoluto--------------");
        System.out.println("1 "+absoluto.resolve(relativo));
        System.out.println("2 "+absoluto.resolve(file));
        System.out.println("---------Relativo--------------");
        System.out.println("3 "+relativo.resolve(absoluto));//não é correto add de um caminho relativo para absoluto,pois não há nada para ser resolver pois já é absoluto
        System.out.println("4 "+relativo.resolve(file));
        System.out.println("---------File--------------");
        System.out.println("5 "+file.resolve(absoluto));//Aqui há mesma coisa
        System.out.println("6 "+file.resolve(relativo));


    }//main
}

/*
"home/uanderson" - Quando não colocamos a 1a "/" inicial estamos
dizendo, que antes disso(diretório), o Sistema operacional,
aplicação têm que considerar  o caminho anterior, como sendo a
localização do diretório.
   Já se coloca a "/" no inicio  "/home/uanderson", está dizendo que deve
pegar do a localização a partir do root/raiz do sistema/aplicação.
(aula 148)

 */