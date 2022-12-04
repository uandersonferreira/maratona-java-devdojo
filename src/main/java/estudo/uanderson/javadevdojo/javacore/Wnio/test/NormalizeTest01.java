package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NormalizeTest01 {
    public static void main(String[] args) {
        String diretorio = "home/uanderson/dev";
        String arquivoTesteTxt = "../../arquivoTeste.txt";

        Path path1 = Paths.get(diretorio, arquivoTesteTxt);
        System.out.println(path1);
        System.out.println(path1.normalize());//não garante que o arquivo existe, somente normaliza

        Path path2 = Paths.get("/home/./uanderson/./dev/");//sintaxe válida no linux ./ indica o proprio diretório.
        System.out.println(path2);
        System.out.println(path2.normalize());

    }
}
