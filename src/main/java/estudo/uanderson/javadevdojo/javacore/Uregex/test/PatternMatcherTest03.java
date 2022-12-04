package estudo.uanderson.javadevdojo.javacore.Uregex.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest03 {
    public static void main(String[] args) {
        // META CARACTERES:
        // \d = Todos os Dígitos/Números
        // \D - Tudo o que não for Dígito/Número
        // \s = Espaço em Branco \t \n \f \r (representam espaços em branco)
        // \S = Todos os caracteres excluindo os em brancos
        // \w = a-zA-Z é dígitos, _(underscore)
        // \W = Tudo o que não for incluso no \w
        // [] = Range vai tem o comportamento da porta lógica OR. Ex: String regex = "[abc]"; a | b | c- procure por a ou b ou c num determinado texto

        String regex = "0[xX][0-9a-fA-F]";
        String texto2 = "12 0X 0X 0xFFABC 0x109 0x1";

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

Quando se está construindo uma expressao regular, é desejar
procurar por um intervalo de numéros ou letras, basta
seguir a seguinte sintaxe:
 Ao invés de abcdefg utilizar-se a-g
             ABCDEFG utilizar-se A-G
             0123456 --------> 0-6



 */