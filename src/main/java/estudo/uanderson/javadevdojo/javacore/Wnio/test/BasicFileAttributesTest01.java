package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class BasicFileAttributesTest01 {
    //MANIPULANDO ATRIBUTOS DE UM ARQUIVO (TIPO DATA DE MODIFICAÇÃO)
    public static void main(String[] args) {
        //BasicFileAttributes (é uma interface mais generica )
        //DosFileAttibutes (voltada para Windows)(é uma interface)
        //PosixFileAttributes (voltada para Linux)(é uma interface)

        LocalDateTime dateTime = LocalDateTime.now().minusDays(10);
        File file = new File("pasta_uanderson/novo.txt");
        try {

            boolean isCreated = file.createNewFile();
            boolean last = file.setLastModified(dateTime.toInstant(ZoneOffset.UTC).toEpochMilli());

            Path path = Paths.get("pasta_uanderson/new.txt");
            Path file1 = Files.createFile(path);
            FileTime fileTime = FileTime.from(dateTime.toInstant(ZoneOffset.UTC));
            Files.setLastModifiedTime(path, fileTime);

            System.out.println(Files.isWritable(path));
            System.out.println(Files.isReadable(path));
            System.out.println(Files.isExecutable(path));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }//main
}
