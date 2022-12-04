package estudo.uanderson.javadevdojo.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest02 {
    public static void main(String[] args) {
        // META CARACTERES:
        // \d = Todos os Dígitos/Números
        // \D - Tudo o que não for Dígito/Número
        // \s = Espaço em Branco \t \n \f \r (representam espaços em branco)
        // \S = Todos os caracteres excluindo os em brancos
        // \w = a-zA-Z é dígitos, _(underscore)
        // \W = Tudo o que não for incluso no \w


        String regex = "\\W";
        String texto2 = "hhj2 1@gv-h_22";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto2);
        System.out.println("Texto:  "+texto2);
        System.out.println("Indice: 0123456789");
        System.out.println("Regex: "+regex);
        System.out.println("Posições Encontradas");

        while (matcher.find()){
            System.out.println(matcher.start()+" "+ matcher.group());
        }


    }
}
/*
//Pattern é como se fosse o padrão
//Matcher recebe a Pattern é realiza uma busca




 */