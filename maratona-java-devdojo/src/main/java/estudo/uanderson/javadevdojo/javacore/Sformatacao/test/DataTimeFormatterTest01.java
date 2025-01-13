package estudo.uanderson.javadevdojo.javacore.Sformatacao.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataTimeFormatterTest01 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();

        String s1 = date.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date.format(DateTimeFormatter.ISO_DATE);
        String s3 = date.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("--------Format---------");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        System.out.println("--------Parse---------");
        LocalDate parse1 = LocalDate.parse("20210219", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate parse2 = LocalDate.parse("2021-02-19", DateTimeFormatter.ISO_DATE);
        LocalDate parse3 = LocalDate.parse("2021-02-19", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println(parse1);
        System.out.println(parse2);
        System.out.println(parse3);

        LocalDateTime now = LocalDateTime.now();
        String s4 = now.format(DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(s4);
       LocalDateTime  parse4 = LocalDateTime.parse("2022-07-18T09:15:08.764991", DateTimeFormatter.ISO_DATE_TIME);
       System.out.println(parse4);

        //dd/MM/yyyy Brasil
        //MM/dd/yyyy USA
        //yyyy/MM/dd  Japão
        DateTimeFormatter formatterBR = DateTimeFormatter.ofPattern("dd 'de' MMMM 'de' yyyy");
        String  formatBR = LocalDate.now().format(formatterBR);
        System.out.println("formatBr: "+formatBR);

        LocalDate parseBR = LocalDate.parse("10 de julho de 2021", formatterBR);//o formato da data têm que seguir o definido em FormatterBR, se não dar erro.
        System.out.println(parseBR);

        DateTimeFormatter formatterIT = DateTimeFormatter.ofPattern("dd.MMMM.yyyy", Locale.ITALY);
        String formatIT = LocalDate.now().format(formatterIT);
        System.out.println(formatIT);
        LocalDate parseIT = LocalDate.parse("19.luglio.2022", formatterIT);
        System.out.println(parseIT);


    }
}
/*
 Quando se estar trabalhando com a formatação de datas
 precisa-se lembrar que:

 -formatter, está sendo transformado do seu objeto para
 uma String.
 -parse, está sendo transformado de uma String para um
 Objeto

 Observação: para ser fazer o parse, têm que seguir uma estrura identica
 a suportada pela ISO, como demonstrado nos exemplos:

       LocalDate parse1 = LocalDate.parse("20210219", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate parse2 = LocalDate.parse("2021-02-19", DateTimeFormatter.ISO_DATE);
        LocalDate parse3 = LocalDate.parse("2021-02-19", DateTimeFormatter.ISO_LOCAL_DATE);
 */