package estudo.uanderson.javadevdojo.javacore.Wnio.test;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamTest01 {
    public static void main(String[] args) {
        Path arquivoZip = Paths.get("pasta/arquivo.zip");//nome do arquizo que será gerado
        Path arquivosParaZipar = Paths.get("pasta/subpasta1/subsubpasta1");//caminho dos arquivos que queremos zipar
        zip(arquivoZip,arquivosParaZipar);
    }//main

    private static void zip(Path arquivoZip, Path arquivosParaZipar){
        try(ZipOutputStream zipStream = new ZipOutputStream(Files.newOutputStream(arquivoZip));
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(arquivosParaZipar)){

            for (Path file : directoryStream) {
                ZipEntry zipEntry = new ZipEntry(file.getFileName().toString());//preparando o arquivo para ser add
                zipStream.putNextEntry(zipEntry); // add o arquivo que está sendo preparado
               Files.copy(file, zipStream);
                zipStream.closeEntry();//estamos fechando a entrada de dados do ZipOutputStream
            }
            System.out.println("Arquivo Criado com Sucesso!");


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}//class


/*
Quando ver a palavra Output nas class signfica que estamos
mandando para algum lugar ( saída de dados).

E normalmente, estaremos trabalhando com dados de baixo nível,
do tipo binário.

A idea do zip é: copiar os arquivos que temos para um
arquivo zipado.


Obs: Method zip() -> Após preparar o arquivo e adicionar o arquivo é necessário
copiar o conteúdo dos arquivos, antes de fechar. Senão os arquivos serão
copiados para o arquivo zip, mas não teram os seus conteúdos copiados juntos.


 */
