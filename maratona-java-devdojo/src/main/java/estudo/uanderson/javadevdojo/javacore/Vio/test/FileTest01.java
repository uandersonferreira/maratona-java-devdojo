package estudo.uanderson.javadevdojo.javacore.Vio.test;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;

//comando : alt + enter
public class FileTest01 {
    public static void main(String[] args) {

        File file = new File("file.txt");
        try {

            boolean isCreated = file.createNewFile();// lança uma exeção do tipo  throws IOException, por isso necessita
                                                    // do tratamento com o try/catch

            System.out.println("Criado: "+isCreated);
            System.out.println("Path/Caminho: "+ file.getPath());
            System.out.println("Parth Absolute:"+ file.getAbsolutePath());
            System.out.println("Se é um diretório:"+ file.isDirectory());
            System.out.println("Se é um arquivo:"+ file.isFile());
            System.out.println("Se está oculto:"+ file.isHidden());
            System.out.println("Ùltima modificação:"+ Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()).toLocalDateTime());


            boolean exists = file.exists();//verifica se o arquivo existe
            if (exists){
                System.out.println("Deletado: "+file.delete());
            }//if

        } catch (IOException e) {
            e.printStackTrace();
        }

    }//main
}//class
