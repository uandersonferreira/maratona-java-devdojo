package estudo.uanderson.javadevdojo.javacore.Sformatacao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormat01 {
    public static void main(String[] args) {
        String pattern = "'Brasil' dd 'de' MMMM 'de' yyyy";//mascara/modelo

        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        System.out.println(sdf.format(new Date()));

        try {
            System.out.println( sdf.parse("Brasil 21 de junho de 2022"));//retorna um date
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
}
/*
Parei aula 119

"yyyy.MM.dd G 'at' HH:mm:ss z"

Na formatação de datas utilizamos aspas simples( 'at' ), para
tudo aquilo que queremos que o SimpleDateFormat ignore na hora de
fazer a converção de dadas.

        String pattern = "'Brasil' dd 'de' MMMM 'de' yyyy";//mascara/modelo

Documentação: https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/text/SimpleDateFormat.html

 E lembrando que ao se tentar fazer um parse, deve ser utilizar
 a string conforme o modelo/mascara  passada para o SimpleDateFormat
        -modelo/mascara ->  "'Brasil' dd 'de' MMMM 'de' yyyy";

         try {
            sdf.parse("Brasil 21 de junho de 2022");
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
 */