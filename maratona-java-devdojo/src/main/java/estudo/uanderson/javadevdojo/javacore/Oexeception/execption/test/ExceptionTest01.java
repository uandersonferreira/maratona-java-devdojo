package estudo.uanderson.javadevdojo.javacore.Oexeception.execption.test;

import java.io.File;
import java.io.IOException;

public class ExceptionTest01 {
    public static void main(String[] args) {
        criarNovoArquivo();

    }//main

    /**
     * @throws RuntimeException caso não seja possível criar o file
     */
    private static void criarNovoArquivo(){
        File file = new File("arquivo\\teste.txt");

        try {
            boolean isCreate = file.createNewFile();
            System.out.println("Arquivo criado: "+isCreate);
        } catch (IOException e) {
            e.printStackTrace();
            //AVISO DE ERRO-NUNCA DEIXAR EM BRANCO
           throw new RuntimeException("Deu erro ao criar o arquivo"); // lancar uma RuntimeException  e não força o tratamento com o ( throws IOException) para quem chama, deixando opcional o tratamento. Mas lembre-se, toda exeção deve ser tratada, então se não informamos a FLAG da Runtime (Não é obrigatória) DEVEMOS informar na DOC do java que pode lançar um erro.
        
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
     PARENTES. (quando eu quero mostrar no console e retorna o erro para quem está chamando)
     Ex:
  public static void criarNovoArquivo() throws IOException{
        File file = new File("arquivo\\teste.txt");

        try {
            boolean isCreate = file.createNewFile();
            System.out.println("Arquivo criado: "+isCreate);
        } catch (IOException e) {
            e.printStackTrace();
            throws e; //Já existe a execption, então não precisa do 'new' para criar uma
            // throw new RuntimeException("Deu erro ao criar o arquivo"); //ou podemos lancar uma RuntimeException  e não força o tratamento com o ( throws IOException) para quem chama, deixando opcional. 
        }
    }//method
     */

}//class
