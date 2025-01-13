package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributesTest01 {
    public static void main(String[] args) throws IOException {
        //BasicFileAttributes (é uma interface mais generica )
        //DosFileAttibutes (voltada para Windows)(é uma interface)
        //PosixFileAttributes (voltada para Linux)(é uma interface)

        Path path = Paths.get("pasta/teste.txt");

        if (Files.notExists(path)) Files.createFile(path);

        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println(dosFileAttributes.isHidden());
        System.out.println(dosFileAttributes.isReadOnly());
        System.out.println("---------------");

        //para realizar alterações
        DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        fileAttributeView.setHidden(true);//setando o arquivo para ser oculto
        fileAttributeView.setReadOnly(true);

        //Atualizando/lendo o arquivo
        System.out.println(fileAttributeView.readAttributes().isHidden());//atualizando as confi do arquivo
        System.out.println(fileAttributeView.readAttributes().isReadOnly());

//        Files.setAttribute(path,"dos:hidden",true);
//        Files.setAttribute(path,"dos:readonly",true);
//        //tornando novamente visivel
//        Files.setAttribute(path,"dos:hidden",false);
//        Files.setAttribute(path,"dos:readonly",false);



    }
}
/*
fileAttributeView
Toda class ou method que finalizar com "View" é destinada ou destinado para realizar
alterações de valores de um arquivo.
Ex:
    DosFileAttributeView fileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);

 */
