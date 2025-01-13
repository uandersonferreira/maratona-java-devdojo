package estudo.uanderson.javadevdojo.javacore.Qstring.test;

public class StringBuilderTest01 {
    public static void main(String[] args) {
        String nome = "Uanderson Ferreira";
        nome.concat(" de Oliveira");//no pool de string foi criado um valor em memória com a referencia para a string "Uanderson Ferreira de Oliveira", no entanto não está tendo
        //nenhuma váriavel criada recebendo esse valor.  String nomeConcatenado = nome.concat(" de Oliveira");
        System.out.println("String: "+nome);//por isso que está sendo impresso somente "Uanderson Ferreira"

        StringBuilder sb = new StringBuilder("Uanderson Ferreira");//por padrão a capacidade de armazrnamento é 16, mas vai se adequando conforme a necessidade.
        sb.append("de Oliveira");//append é como se fosse o concat, ele é sobrecarregado, aceita string, int,flot...
        System.out.println("StringBuilder: "+sb);

        //ficar ligado no retorno dos metódos

    }//main
}//class
