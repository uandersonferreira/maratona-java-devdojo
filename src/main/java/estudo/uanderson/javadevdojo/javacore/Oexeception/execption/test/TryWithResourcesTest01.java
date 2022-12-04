package estudo.uanderson.javadevdojo.javacore.Oexeception.execption.test;

import estudo.uanderson.javadevdojo.javacore.Oexeception.execption.dominio.Leitor1;
import estudo.uanderson.javadevdojo.javacore.Oexeception.execption.dominio.Leitor2;

import java.io.*;

public class TryWithResourcesTest01 {
    public static void main(String[] args) {
       lerArquivo();
    }//main

    public static void lerArquivo(){
        try (Leitor1 leitor1 = new Leitor1();
             Leitor2 leitor2 = new Leitor2()) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }//lerArquivo
    /*
   O Java quando ler o Try com recursos irá se encarregar de fechar o arquivo,
    assim que terminar sua leitura.

    OBSERVAÇÃO: só podemos colocar objetos ou váriaveis de referência,
    dentro do () do try, que implementem a interface Closeable ou AutoCloseable,
    devido ao poliformismo.

    -As váriaveis de referencia ou objetos, serão fechadas(os)
     na ordem inversa que foram abertas/lidas/declaradas.
     */



    public  static  void lerArquivo2(){
        Reader reader = null;
        try{
            reader = new BufferedReader(new FileReader("testeWithResources2.txt"));

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}//class
