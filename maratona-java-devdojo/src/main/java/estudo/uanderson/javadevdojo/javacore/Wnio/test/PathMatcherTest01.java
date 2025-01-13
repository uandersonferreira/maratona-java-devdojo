package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class PathMatcherTest01 {
    public static void main(String[] args) {
        Path path1 = Paths.get("pasta/subpasta/file.bkp");
        Path path2 = Paths.get("pasta/subpasta/file.txt");
        Path path3 = Paths.get("pasta/subpasta/file.java");

        matches(path1, "glob:*.bkp");//não considera os diretorios
        matches(path1, "glob:**.bkp");// considera os diretorios
        matches(path1, "glob:**/*.bkp");// considera os diretorios
        matches(path2, "glob:**/*.{bkp, txt,java}");//não pode ter espaços, se não, não irá funcionar.
        matches(path2, "glob:**/*.{bkp,txt,java}");//têm que ser tudo junto e como é mais de uma extensão aceita agrupa-se por meio das chaves {}.
        matches(path1, "glob:**/*.???");//Não importa o diretorio/e nem o nome, mas a extensão têm que ter 3 letras
        matches(path2, "glob:**/*.???");//Não importa o diretorio/e nem o nome, mas a extensão têm que ter 3 letras
        matches(path3, "glob:**/*.???");//Não importa o diretorio/e nem o nome, mas a extensão têm que ter 3 letras
        matches(path3, "glob:**/file.????");//Não importa o diretorio/mas sim o nome do arquivo sim é a extensão têm que ter 3 letras.


    }

    private static void matches(Path path, String glob){
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher(glob);
        System.out.println(glob + " -> "+matcher.matches(path));
    }
}
