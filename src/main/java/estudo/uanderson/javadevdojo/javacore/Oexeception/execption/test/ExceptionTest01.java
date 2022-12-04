package estudo.uanderson.javadevdojo.javacore.Oexeception.execption.test;

import java.io.File;
import java.io.IOException;

public class ExceptionTest01 {
    public static void main(String[] args) {
        criarNovoArquivo();

    }//main

    private static void criarNovoArquivo(){
        File file = new File("arquivo\\teste.txt");

        try {
            boolean isCreate = file.createNewFile();
            System.out.println("Arquivo criado: "+isCreate);
        } catch (IOException e) {
            e.printStackTrace();
            //AVISO DE ERRO-NUNCA DEIXAR EM BRANCO
        }
    }//method

    /*
    -NO TRATAMENTO DE EXCEÇÕES RECOMENDA-SE
    O TRATAMENTO DAS EXCEÇÕES MAIS ESPECIFÍCAS(FILHAS/SUBCLASSE)
     AO CONTRÁRIO DAS MAIS GENERICAS(SUPERCLASSE/PAI)


          DICA: QUANDO LANÇAR PRA FRENTE OU NÃO A EXCEÇÃO?

    1°- SE O METÓDO FOR PRIVADO É RECOMENDANDO TRATAR COM TRY/CATCH, POIS
    TEORICAMENTE NINGUÉM PODERÁ TER ACESSO A ELE.

    2°- SE O MÉTODO FOR PUBLICO PODE LANÇAR A EXCEÇÃO QUE QUEM ESTÁ CHAMANDO
     PODERÁ REALIZAR O TRATAMENTO DA FORMA QUE PREFERIR.

     3°- CASO QUEIRA REALIZAR O TRAMENTO E LANÇAR A EXEÇÃO PRA FRENTE, RECOMENDA-SE
     REALIZAR UM TRATAMENTO HIBRIDO, ONDE IRÁ SER FEITO O TRY/CATCH E LANÇADO A EXCEÇÃO
     PARA FRENTE COM O THROWS NO CATCH E THROWS IOEXCEPTION, APÓS O
     PARENTES.
     Ex:
  public static void criarNovoArquivo() throws IOException{
        File file = new File("arquivo\\teste.txt");

        try {
            boolean isCreate = file.createNewFile();
            System.out.println("Arquivo criado: "+isCreate);
        } catch (IOException e) {
            e.printStackTrace();
            throws e;
        }
    }//method
     */

}//class
