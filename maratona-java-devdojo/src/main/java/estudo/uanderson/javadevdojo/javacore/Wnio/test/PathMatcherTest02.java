package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

class FindAllTestJavaOrClass extends SimpleFileVisitor<Path>{
    private PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*{Test*}.{java,class}");// poderia ser um regex também aceita ambos
    //private PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*Test*.{java,class}"); //também é uma sintaxe válida
    //                                                                           não importa o diretório/algo que comece com qualquer tipo de letra
    //                                                                           mas que tenha Test no nome e não importa o que venha depois de teste
    //                                                                           é têm que ser .java ou .class.

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(pathMatcher.matches(file)){
            System.out.println(file.getFileName());
        }
        return FileVisitResult.CONTINUE;
    }

}//FindAllTestJavaOrClass

public class PathMatcherTest02 {
    public static void main(String[] args) {
        Path root = Paths.get(".");
        try {
            Files.walkFileTree(root, new FindAllTestJavaOrClass());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
