package estudo.uanderson.javadevdojo.javacore.Vio.test;

import java.io.File;
import java.io.IOException;

public class FileTest02 {
    public static void main(String[] args) throws IOException {
        File fileDiretorio  = new File("pasta");

        boolean isDiretorioCreated = fileDiretorio.mkdir();
        System.out.println("Diretório criado: "+isDiretorioCreated);

        File fileArquivoDiretorio = new File(fileDiretorio,"arquivo.txt");
        boolean isFileCreated = fileArquivoDiretorio.createNewFile();
        System.out.println("Arquivo criado dentro do Diretório: "+isFileCreated);

        File fileRenamed = new File(fileDiretorio,"arquivo_renomeado.txt");
        boolean isRenamed = fileArquivoDiretorio.renameTo(fileRenamed);
        System.out.println("Arquivo renomeado: "+ isRenamed);

        File diretorioRenamed = new File("pasta_uanderson");
        boolean isDiretorioRenamed = fileDiretorio.renameTo(diretorioRenamed);
        System.out.println("Diretório pasta Renomeado: "+isDiretorioRenamed);

    }
}
/*
Ao se criar arquivos dentro de um diretório, podemos tanto passar o caminho
absoluto do diretório, quanto criar uma instancia/objeto do diretório é passar
para a instância/objeto do arquivo que será criado.
Ex:
              File fileDiretorio  = new File("pasta");// instancia/objeto do diretório

    1°- File fileArquivoDiretorio = new File("/home/uanderson/Documentos/GitHub/JAVA/Java-DevDojo/pasta//arquivo.txt");//instância/objeto do arquivo
    2°- File fileArquivoDiretorio = new File(fileDiretorio,"arquivo.txt"); //instância/objeto do arquivo

Para renomera um arquivo, cria-se um no arquivo, portanto é necessário informar
o diretório que o arquivo que deseja renomear pertence, se não, o arquivo será
renomeado, mas irá sair daquele diretório e não, é isso que desejamos.
ex:
        File fileDiretorio  = new File("pasta");

        File fileRenamed = new File("arquivo_renomeado.txt");// forma errada
        File fileRenamed = new File(fileDiretorio,"arquivo_renomeado.txt");// forma correta




 */