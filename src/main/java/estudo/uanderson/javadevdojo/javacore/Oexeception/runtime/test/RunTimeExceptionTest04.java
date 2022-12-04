package estudo.uanderson.javadevdojo.javacore.Oexeception.runtime.test;

import java.io.FileNotFoundException;
import java.sql.SQLException;

public class RunTimeExceptionTest04 {
    public static void main(String[] args) {

        try{
            throw new RuntimeException();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("dentro do ArrayIndexOutOfBoundsException");
        }catch (IndexOutOfBoundsException e){
            System.out.println("dentro do IndexOutOfBoundsException");
        }catch (IllegalArgumentException e){
            System.out.println("dentro do IllegalArgumentException");
        }catch (RuntimeException e){
            System.out.println("dentro do RuntimeException");
        }

        try {
            talvezlanceException();
        }catch (SQLException | FileNotFoundException e){
            e.printStackTrace();
        }

    }//main

    private static void talvezlanceException() throws SQLException, FileNotFoundException{

    }


}//class

/*
REGRA:AO REALIZAR O TRATAMENTO DE MULTIPLAS EXCEÇÕES,
NÃO PODEMOS COLOCAR UMA EXEÇÃO MAIS GENERICA
ACIMA DE EXECEÇÕES MAIS ESPECIFICAS, SE NÃO SERÁ IGNORADO
TODAS EXCEÇÕES MAIS ESPECIFICAS, JÁ QUE A PRIMEIRA OPÇAO A SER LIDA
SERÁ A DA EXCEÇÃO MAIS GENERICA.
-EXCEÇÕES MAIS GENERICAS SEMPRE NO FINAL.

 */