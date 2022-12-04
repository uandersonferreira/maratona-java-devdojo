package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

public class BasicFileAttributesTest02 {
    //MANIPULANDO ATRIBUTOS DE UM ARQUIVO (TIPO DATA DE MODIFICAÇÃO)
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta_uanderson/new.txt");
        //BasicFileAttributesView, DosFileAttibutesView, PosixFileAttributesView
        BasicFileAttributes basicFileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

        FileTime creationTime = basicFileAttributes.creationTime();
        FileTime lastModifiedTime = basicFileAttributes.lastModifiedTime();
        FileTime lastAccessTime = basicFileAttributes.lastAccessTime();

        System.out.println("creationTime: "+creationTime);
        System.out.println("lastModifiedTime: "+lastModifiedTime);
        System.out.println("lastAccessTime: "+lastAccessTime);
        System.out.println("---------------------------------");

        BasicFileAttributeView fileAttributeView = Files.getFileAttributeView(path, BasicFileAttributeView.class);

        FileTime newCreationTime = FileTime.fromMillis(System.currentTimeMillis());//pegando a hora atual do systema baseado no zulo time/UTC
        fileAttributeView.setTimes(lastModifiedTime,newCreationTime,creationTime);//setando o horário atual para o lastAccessTime do arquivo.

        //após realizar alguma alteração no arquivo é necessário realizar
        //uma nova leitura do mesmo, para se saber o que foi alterado, se não, não irá funcionar.
        //Conforme exemplo abixo:
        creationTime = fileAttributeView.readAttributes().creationTime();//retorna um basicFileAttributes
        lastModifiedTime = fileAttributeView.readAttributes().lastModifiedTime();//retorna um basicFileAttributes
        lastAccessTime = fileAttributeView.readAttributes().lastAccessTime();//retorna um basicFileAttributes

        System.out.println("creationTime: "+creationTime);
        System.out.println("lastModifiedTime: "+lastModifiedTime);
        System.out.println("lastAccessTime: "+lastAccessTime);

    }//main
}
/*
Classes com o final "View", disponibilizam methods que permitem
realizar alterações.
Ex: BasicFileAttributesView, DosFileAttibutesView, PosixFileAttributesView


Pré-compilado:

1° criar um path(caminho do arquivo)
2° Cria uma Objeto da class BasicFileAttributeView e passe como
argumento o path criado é a classe que permite alterações que deseja utilizar(path, BasicFileAttributeView.class)
3° Pegue um horário através da class FileTime
4° Através da referencia da classe BasicFileAttributeView criada, sete
aos horário que deseja, por meio, do method setTime disponivel;
 5° atualize os valores do arquivo, atraves dos objetos criados da class FileTime
      creationTime = fileAttributeView.readAttributes().creationTime();//retorna um basicFileAttributes

 Qualquer coisa reveja a aula 150 :)


 */