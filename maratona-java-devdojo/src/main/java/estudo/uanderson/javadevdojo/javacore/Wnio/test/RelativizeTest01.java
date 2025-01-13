package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RelativizeTest01 {
    public static void main(String[] args) {
        Path dir = Paths.get("/home/uanderson");
        Path clazz = Paths.get("/home/uanderson/devdojo/olaMundo.java");
        Path pathToClazz = dir.relativize(clazz);
        System.out.println(pathToClazz);
        System.out.println("------------------------------");

        Path absoluto1 = Paths.get("/home/uanderson");
        Path absoluto2 = Paths.get("/usr/local");
        Path absoluto3 = Paths.get("/home/uanderson/devdojo/olaMundo");
        Path relativo1 = Paths.get("temp");
        Path relativo2 = Paths.get("temp/tem.201354");

        System.out.println("1 -> "+absoluto1.relativize(absoluto3));
        System.out.println("2 -> "+absoluto3.relativize(absoluto1));
        System.out.println("3 -> "+absoluto1.relativize(absoluto2));
        System.out.println("4 -> "+relativo1.relativize(relativo2));
        System.out.println("5 -> "+absoluto1.relativize(relativo1));

    }//main
}
/*
relativize() ensina como se chega em uma determinada localização e como voltar dela.
ex:
   System.out.println("1 -> "+absoluto1.relativize(absoluto3));

   como chegar no caminho absoluto3 partindo do caminho absoluto1

           Path absoluto1 = Paths.get("/home/uanderson");
           Path absoluto3 = Paths.get("/home/uanderson/devdojo/olaMundo");


ATENÇÃO: Ao se trabalhar com caminhos absolutos é relativos
deve-se tomar cuidado, pois ao se tentar procurar uma localização
partindo de um caminho absoluto para um relativo irá gerar um erro, pois
a localização do caminho relativo é desconhecida pelo sistema ou aplicação. Pois quando
chega na raiz/root tenta se achar o diretório, mas não é encontrado nada.
----> Exception Lançada: IllegalArgumentException: 'other' is different type of Path
Ex:
    System.out.println("5 -> "+absoluto1.relativize(relativo1));



 */