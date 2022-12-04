package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;



public class PathTest02 {
    public static void main(String[] args) {
        //------------CRIAÇÃO DIRETÓRIOS/PASTA---------------
        Path pastaPath = Paths.get("pasta");

            try {
                if (Files.notExists(pastaPath)) {
                    Path pastaDirectory = Files.createDirectory(pastaPath);
                }

            } catch (IOException e) {
                e.printStackTrace(); //imprime todo o erro caso ocorra
            }
            //-------------------CRIAÇÃO SUB DIRETÓRIOS/PASTAS---------------------------------//

        Path subPastaPath = Paths.get("pasta/subpasta/subsubpasta");
        try {
            Path subPastaDirectory = Files.createDirectories(subPastaPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //-----------------CRIAÇÃO ARQUIVOS-------------------------------

        Path filePath = Paths.get(subPastaPath.toString(), "file.txt");
        try {
            if (Files.notExists(filePath)){
                Path filePathCreated = Files.createFile(filePath);//gera um erro caso o arquivo já exista, nesta realizar a vericação antes.
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //--------COPIANDO UM ARQUIVO DENTRO DE UM DIRETÓRIO/PASTA---------------

        Path origem = filePath;
        Path destino = Paths.get(filePath.getParent().toString(), "file_renamed.txt");
        try {
            Path copy = Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);
            if (Files.exists(copy)){
                System.out.println("Arquivo Copiado com sucesso!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }//main
}
/*


        Path pastaPath = Paths.get(" ");
Se deixado como vazio, o java intepreta que estamos pegando o diretorio
onde o programa está sendo executado.

Ao se usar o Files.createDirectory(); para criar um diretorio/pasta, somente é permitido se
for somenete 1 nivel de diretório, caso contrário não -> pasta/subPasta/subSubPasta(gera uma exception).
E caso já exita o diretório/pasta o method irá lancar uma  IOException "FileAlreadyExistsException".
ex:
        Path pastaDirectory = Files.createDirectory(pastaPath);

Neste caso, para contornar essa situação é necessário realizar uma
verificação antes de pedir para se criar um novo diretório/pasta.
        Path pastaPath = Paths.get("pasta");

            try {
                if (Files.notExists(pastaPath)) {
                    Path pastaDirectory = Files.createDirectory(pastaPath);
                }else {
                    System.out.println("Diretório já Existente!");
                }

            } catch (IOException e) {
                e.printStackTrace(); //imprime todo o erro caso ocorra
                throw new RuntimeException(e);
            }


Já quando se utiliza o  Files.createDirectories(); pode ser criar diretórios/pasta
dentro de subPasta em mais de 1 nível -> pasta/subPasta/subSubPasta que não irá
gerar um exception. E caso as subPastas não existirem irá automáticamente
criar-lás.

        Path subPastaPath = Paths.get("pasta/subpasta/subsubpasta");
        try {
            Path subPastaDirectory = Files.createDirectories(subPastaPath);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }






 */