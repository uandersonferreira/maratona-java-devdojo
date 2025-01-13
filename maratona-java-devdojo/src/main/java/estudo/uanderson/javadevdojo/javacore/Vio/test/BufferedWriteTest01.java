package estudo.uanderson.javadevdojo.javacore.Vio.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriteTest01 {
    public static void main(String[] args) {
        File file = new File("file.txt");

        try(FileWriter fw = new FileWriter(file,true); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("Escrevendo dentro do arquivo file!");
            bw.newLine();//indica uma quebra de linha durante a escrita num arquivo, pois o \n não
                         // é algo que todos os sistemas compreende como quebra de linha
            bw.write("Escrevendo na próxima linha....");
            fw.flush();// esvazia o que está dentro do buffer

        } catch (IOException e) {
            e.printStackTrace();
        }

    }//main
}//class
/*
A  BufferedWriter recebe um objeto da FileWriter dentro de seu construtor, diferente da
FileWriter que recebe um objeto da class File. A class também aceita em seu construtor
expecificar o tamanho do buffer que será utilizado, durante a escrita.(8*1024).

A BufferedWriter encapsula a FileWrite, portanto faz uso do encapsulamento.

Essencialmente, um buffer é uma entidade intermediária entre duas ou mais outras entidades
 que produzem e consomem elementos. Internamente, um buffer contém uma área de memória que
é utilizada paraarmazenamento temporário de elementos que foram produzidos mas ainda não
foram consumidos.

Essa capacidade de um buffer MANTER TEMPORARIAMENTE PARTE dos DADOS PRODUZIDOS mas não
 consumidos torna-o um mecanismo adequado para compatibilizar a operação de ENTIDADES
 OPERANDO EM DIFERENTES VELOCIDADES. Além de oferecer transparentemente as mesmas
 funcionalidades de leitura e escrita de dados, um buffer normalmente oferece operações
 adicionais que permitem CONSULTAR se há DADOS DISPONIVEIS PARA LEITURA no BUFFER de
 ENTRADA ou para SOLICITAR que os dados presentes no BEFFER de SAÍDA sejam ENVIADOS
 imediatamente PARA o DISPOSITIVO DE SAÍDA.


 */