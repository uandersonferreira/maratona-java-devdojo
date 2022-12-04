package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;

public class PosixFileAttributesTest01 {
    public static void main(String[] args) {
        Path path = Paths.get("/home/uanderson/dev/file.txt");
        try {
            PosixFileAttributes posixFileAttributes = Files.readAttributes(path, PosixFileAttributes.class);
            System.out.println(posixFileAttributes.permissions());
            System.out.println("----------------------------");
            //ALTERANDO AS PERMISSÕES: [GROUP_WRITE, GROUP_READ, OWNER_WRITE, OTHERS_READ, OWNER_READ]

            PosixFileAttributeView fileAttributeView = Files.getFileAttributeView(path, PosixFileAttributeView.class);
            Set<PosixFilePermission> posixFilePermissions = PosixFilePermissions.fromString("rw-rw-rw-");//definindo uma estrutura de permissões linux
            fileAttributeView.setPermissions(posixFilePermissions);//atribuindo a estrutura de permissão ao objeto da class PosixFileAttributeView
            System.out.println(fileAttributeView.readAttributes().permissions());// atualizando as permissoes

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }//main
}//class
/*
sudo apt install default-jdk --> para instalar o java padrão caso não o tenha já intalado.

Apenas uma demonstração do exemplo no sistema, após execução da aplicação:

Antes:
uanderson@uanderson-Linux-mint:~/dev$ ll
total 12
drwxrwxr-x  2 uanderson uanderson 4096 jul 31 23:18 ./
drwxr-xr-x 45 uanderson uanderson 4096 jul 31 23:09 ../
-rw-rw-r--  1 uanderson uanderson    2 jul 31 23:19 file.txt

Depois:
uanderson@uanderson-Linux-mint:~/dev$ ll
total 12
drwxrwxr-x  2 uanderson uanderson 4096 jul 31 23:18 ./
drwxr-xr-x 45 uanderson uanderson 4096 jul 31 23:09 ../
-rw-rw-rw-  1 uanderson uanderson    2 jul 31 23:19 file.txt
uanderson@uanderson-Linux-mint:~/dev$

 */