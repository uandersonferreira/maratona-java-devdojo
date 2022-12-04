package estudo.uanderson.javadevdojo.javacore.Oexeception.runtime.test;

public class RuntimeExceptionTest01 {// Unchecked

    public static void main(String[] args) {
        // Checked e Unchecked
        int nums[] = {1,2};
        System.out.println(nums[2]);
        /*
        Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 2 out of bounds for length 2
	at estudo.uanderson.javadevdojo.javacore.Oexeception.runtime.test.RuntimeExceptionTest01.main(RuntimeExceptionTest01.java:8)

       Erro de lógica de programação(desenvolvimento), pois não existe a posição
       2 do array nums que está sendo chamada.
         */


    }//main
}//class

/*
--Erro de programação e não precisa ser tratado para o programa rodar

    -Throwable -> é a super classe de todas as exceptions ou errors

    CHECKED- SÃO EXCEÇÕES CHECADAS, FILHAS/SUBCLASSES DA CLASSE EXCEPTION
    DIRETAMENTE E SE NÃO TRATADAS, LANÇAM ERROS EM TEMPO DE COMPILAÇÃO, OU
    SEJA O CÓDIGO NEM IRÁ SER COMPILADO. É OBRIGATÓRIO O TRATAMENTO

    UNCHECKED- SÃO EXCEÇÕES NÃO CHECADAS, FILHAS/SUBCLASSES DA CLASSE RunTimeException(que é filha de Exception)
    E QUANDO LANÇADAS, 99% DAS VEZES FOI POR CAUSA DE ERRO DE LÓGICA DO CÓDIGO
    QUE A PESSOA ESTÁ DESENVOLVENDO OU QUE NÃO REALIZOU UMA TRATATIVA NECESSÁRIA.
    -NÃO É OBRIGATÓRIO O TRATAMENTO, MAS É RECOMENDADO.
    -ACONTECEM EM TEMPO DE EXECUÇÃO/COMPILAÇÃO

 */
