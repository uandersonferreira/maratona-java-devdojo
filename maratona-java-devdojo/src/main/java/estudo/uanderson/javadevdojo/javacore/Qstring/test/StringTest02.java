package estudo.uanderson.javadevdojo.javacore.Qstring.test;

public class StringTest02 {
    public static void main(String[] args) {
        String nome = "Uanderson";
        String nome2 = "  Uanderson  ";
        String numeros = "012345";

        System.out.println(nome.charAt(0));//retorna o 1° caracter, sendo que começa com 0,1,2..n
        System.out.println(nome.length());//retorna um inteiro representando o tamanho da string, lembrando que por de baixo dos panos é um array de string é o index vai de 0 a tamanho da string -1(0 até 8 (9-1) )
        System.out.println(nome.replace("a","@"));//substitui um caracter da string por outro caracter
        System.out.println(nome.toLowerCase());//tudo em minusculo
        System.out.println(nome.toUpperCase());//tudo em maisculo

        System.out.println(numeros.substring(0,3));//retorna uma string de uma posição inicial até uma determinada posição, sendo essa última posição ela mesma - 1;
        System.out.println(numeros.substring(0,numeros.length()));//retorna a string inteira
        System.out.println(numeros.substring(3,numeros.length()));//retorna a string inteira partindo da posição 3

        System.out.println(nome2);//sem o trim
        System.out.println(nome2.trim());//remove os valores em branco do começo e no fim da String
    }
}
