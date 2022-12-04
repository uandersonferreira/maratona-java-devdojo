package estudo.uanderson.javadevdojo.javacore.Oexeception.runtime.test;

public class RunTimeExceptionTest03 {
    public static void main(String[] args) {
        abreConexao();
    }//main

    private static String abreConexao(){
        try {
            System.out.println("Abrindo o arquivo");
            System.out.println("Escrevendo dados no arquivo");
            throw new RuntimeException();
        }catch (Exception e){
           e.printStackTrace();

        }finally {
            System.out.println("Fechando recurso liberado pelo SO");
            System.out.println("Comprovando que o bloco finaly sempre será executado");
        }
        return null;
    }//method

    private static void abreConexao2(){
        try {
            System.out.println("Abrindo o arquivo");
            System.out.println("Escrevendo dados no arquivo");
            throw new RuntimeException();
        }finally {
            System.out.println("Fechando recurso liberado pelo SO");
            System.out.println("Comprovando que o bloco finaly sempre será executado");
        }
    }

}//class

/*
-O bloco Finaly sempre será executado.

 -try/finaly é uma declaração válida
 -já so o try não


 */