package estudo.uanderson.javadevdojo.javacore.Vio.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteTest01 {
    public static void main(String[] args) {

        File file = new File("file.txt");

        try(FileWriter fw = new FileWriter(file,true)) {//o próprio try se encarrega de fechar o arquivo, por causa da implementação da Interface Closeable que possui

            // (file,append:true) true foi utilizado para pode acrescentar contéudo ao arquivo sem sobrescreve o que já existe
            //Quando se está escrevendo num arquivo com a fileWrite através do method write é não passa o true como
            //argumento para a FileWriter o contéudo será apagado/sobreposto.

            fw.write("Escrevendo dentro do arquivo file!!\nEscrevendo novamente, mas sem apagar o que já existia:)");
            // fw.close(); fecharia o arquivo após terminar a escrita, mas não é necessário sendo assim somente necessita por causa do
            // thy ccom rercursos  esvaziar o buffer
            fw.flush();// esvazia o que está dentro do buffer


        } catch (IOException e) {
            e.printStackTrace();
        }

    }//main
}//class
