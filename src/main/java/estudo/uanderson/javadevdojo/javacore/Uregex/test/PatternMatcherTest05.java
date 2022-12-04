package estudo.uanderson.javadevdojo.javacore.Uregex.test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest05 {
    public static void main(String[] args) {
        // META CARACTERES:
        // \d = Todos os Dígitos/Números
        // \D - Tudo o que não for Dígito/Número
        // \s = Espaço em Branco \t \n \f \r (representam espaços em branco)
        // \S = Todos os caracteres excluindo os em brancos
        // \w = a-zA-Z é dígitos, _(underscore)
        // \W = Tudo o que não for incluso no \w
        // [] = Range vai tem o comportamento da porta lógica OR. Ex: String regex = "[abc]"; a | b | c- procure por a ou b ou c num determinado texto
        //     QUANTIFICADORES
        // ? Zero ou uma ocorrência
        // * Zero ou mais ocorrências
        // + Uma ou mais ocorrências
        // (n,m) de n até m (1,5)- de 1 até 5 occorrências
        // () Agrupamento
        // | ou/OR
        // $ fim da linha
        // .  1.3 = 123, 133, 1@3, 1A3

        //https://regexr.com/ site estudar um pouco mais sobre as exxpressoẽs regulares
        

        //Obs:Quanfor for necessãrio usar um caracter de Texto que também é um meta caracter, basta utilizar um caracter de scape -> \\caracter(\\*)
        String regex = "([a-zA-Z0-9\\._-])+@([a-zA-Z])+(\\.([a-zA-Z])+)+";
        String texto = "luffy@hotmail.com,  123jotaro@gmail.com, #@!zoro@mail.br, teste@gmail.com.br, sakura@mail ";

        System.out.println(Arrays.toString(texto.split(",")));
        System.out.println("---------------------");
        System.out.println("Email Válido: ");
        System.out.println("zoro@mail.br".matches(regex));
        System.out.println("Email Array: "+texto.split(",")[3].trim());
        System.out.println("-----------------------");

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);
        System.out.println("Texto:  "+texto);
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