package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryStreamTest01 {
    public static void main(String[] args) {
        //FORMA MAIS SIMPLES DE LISTAR TODOS OS ARQUIVOS DE UM DIRETÓRIO
       // Path diretorio = Paths.get("./");
        Path diretorio = Paths.get(".");// . ou ./ para se referiri ao diretorio atual
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(diretorio)) {
            for (Path path : stream) {
                System.out.println(path.getFileName());
            }

        }catch (IOException e){
            e.printStackTrace();
        }

    }//main
}//class
/*
Irá listar os arquivos/pastas que estão contidos a partir
de um caminho/diretorio, inclusive os ocultos. No entanto,
não listar os arquivos dentro de outras pastas(sub-pastas).
 */