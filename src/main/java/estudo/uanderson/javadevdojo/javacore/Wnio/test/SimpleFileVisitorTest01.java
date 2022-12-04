package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class ListJavaFiles extends SimpleFileVisitor<Path>{
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs){// O argumento file é por causa do generic definido na criação da class
       //Aqui definimos o comportamneto que queremos durante a navegação pelos diretorios
    if(file.getFileName().toString().endsWith(".java")){
        System.out.println(file.getFileName());//.toString() por debaixo dos panos ele já chama o toString();
    }
        return FileVisitResult.CONTINUE;

    }//visitFile
}//class ListJavaFiles

public class SimpleFileVisitorTest01 {
    public static void main(String[] args) {
        Path root = Paths.get(".");
        try {
            Files.walkFileTree(root, new ListJavaFiles());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

    }
}
/*
Files.walkFileTree() ->
   Ele precisa de um Path para iniciar a procura e um FileVisitor
para definir o comportamneto que queremos durante a navegação
dos diretórios.

A FileVisitResult possui algumas ações tais como:

  - CONTINUE -> continua lendo os arquivos até ler tudo, até arquivos ocultos
  - TERMINATE -> Para de ler quando chegar num determinado ponto se desejado ou simplismente Encerra a procura.

  - SKIP_SUBTREE -> Continue sem visitar as entradas neste diretório(Sub-pastas).
   Este resultado só é significativo quando retornado do preVisitDirectory método;
   por outro lado este tipo de resultado é o mesmo que retornar CONTINUE.

  - SKIP_SIBLINGS -> pula quem está no mesmo nível.
  Continue sem visitar os irmãos deste arquivo ou diretório.
  Se retornou do preVisitDirectorymétodo, as entradas no diretório
   também são pulou e o postVisitDirectory método não é invocado

Referência: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/FileVisitResult.html#SKIP_SIBLINGS
 */