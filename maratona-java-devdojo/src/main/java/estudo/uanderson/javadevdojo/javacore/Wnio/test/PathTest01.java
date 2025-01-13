package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest01 {
    public static void main(String[] args) {
        //formas de se passar o caminho de um arquivo validas no paths
        Path p1 = Paths.get("/home/uanderson/Documentos/GitHub/JAVA/Java-DevDojo/file.txt");
        Path p2 = Paths.get("/home/uanderson/Documentos/GitHub/JAVA/Java-DevDojo","file.txt");
        Path p3 = Paths.get("/home","uanderson/Documentos/GitHub/JAVA/Java-DevDojo","file.txt");
        Path p4 = Paths.get("/home","uanderson","Documentos","GitHub","JAVA","Java-DevDojo","file.txt");

        System.out.println("Nome do arquivo pego: "+p1.getFileName());
        System.out.println("Nome do arquivo pego: "+p2.getFileName());
        System.out.println("Nome do arquivo pego: "+p3.getFileName());
        System.out.println("Nome do arquivo pego: "+p4.getFileName());
        System.out.println("--------------------------------------");
        System.out.println("Nome do arquivo pego: "+p1.getFileName());
        System.out.println("Tranformando o arquivo em um file: "+p1.getFileName().toFile());
        System.out.println("Tranformando o arquivo em um file e depois em um path: "+p1.getFileName().toFile().toPath());//para poder trabalhar com as class do pacote nio é necessário um path é não um file


    }//main
}//class
