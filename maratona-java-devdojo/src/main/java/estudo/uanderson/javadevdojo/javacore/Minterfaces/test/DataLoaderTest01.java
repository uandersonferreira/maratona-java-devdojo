package estudo.uanderson.javadevdojo.javacore.Minterfaces.test;

import estudo.uanderson.javadevdojo.javacore.Minterfaces.dominio.DataLoader;
import estudo.uanderson.javadevdojo.javacore.Minterfaces.dominio.Datebaseloader;
import estudo.uanderson.javadevdojo.javacore.Minterfaces.dominio.FileLoader;

public class DataLoaderTest01 {
    public static void main(String[] args) {
        Datebaseloader datebaseloader = new Datebaseloader();
        FileLoader fileLoader = new FileLoader();
        datebaseloader.load();
        fileLoader.load();

        datebaseloader.remove();
        fileLoader.remove();

        datebaseloader.checkPermission();
        fileLoader.checkPermission();

        //Lembrando por ser um  method static são chamados pelo nome da classe a quem pertencem.
       DataLoader.retrieveMaxDataSize();
       Datebaseloader.retrieveMaxDataSize();



    }//main
}//class
