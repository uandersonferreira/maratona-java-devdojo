package estudo.uanderson.javadevdojo.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest01 {
    public static void main(String[] args) {
        String regex = "aba";
      //  String texto = "abaaba";
        String texto2 = "abababa";

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

Após a realização da busca é se encontrado o padrão desejado a
última posição do padrão não será mais contada, durante a busca
num Texto, como se pode ver no exemplo acima qundo se realiza a busca
do padrão "aba", no texto "abababa".
Posições Encontradas
-> abababa
   0123456

0 aba
4 aba
Ignorando completamente a posição 3


 */