package estudo.uanderson.javadevdojo.javacore.Vio.test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");

        try( FileReader fr = new FileReader(file)) {
//           char[] vetorChar = new char[50];
//            int size = fr.read(vetorChar);//o read(), retorna a quantidade de caracteres que leu
//            System.out.println("Tamanho Vetor: "+size);
//
//            for (char c: vetorChar) {
//                System.out.print(c);
//            }

            System.out.println("Imprimindo todo o conteúdo do arquivo: \n");
            int i;
            while ((i = fr.read()) != -1){//o read(), durante a leitura, quando chega no
                                          // final do arquivo ele retorna -1, sendo assim, sabemos que acabou o contéudo para ser lido

                System.out.print((char)i);//cast de int para char. consulta a tabela ASCII é
                                          // associa o número a letra que o n° representa!
            }

        } catch (IOException e) {
            e.printStackTrace();

        }

    }//main
}//class
//aula 141 286