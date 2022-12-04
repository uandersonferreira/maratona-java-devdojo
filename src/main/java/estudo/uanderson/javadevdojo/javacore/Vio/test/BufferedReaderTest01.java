package estudo.uanderson.javadevdojo.javacore.Vio.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");

        try(FileReader fr = new FileReader(file); BufferedReader br = new BufferedReader(fr)) {
            String linha;

            while ((linha = br.readLine() )!= null){
                System.out.println(linha);
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }//main
}//class
/*
Ao contrário da class FileRead que ler caracter por caracter utilizando o method
read(), é retornando -1 ao final do arquivo, a class BufferedRead ler linha por linha
é utiliza o method readLine(), que retorna "null" no final da leitura do arquivo.



 */