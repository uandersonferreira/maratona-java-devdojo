package estudo.uanderson.javadevdojo.javacore.Uregex.test;

import java.util.Scanner;

public class ScannerTest01 {
    public static void main(String[] args) {
        String texto = "Levi,Eren,Mikasa,true,200";
        String[] nomes = texto.split(",");//token delimitador utilizando String

        System.out.println("UTILIZANDO STRING: ");
        for (String nome : nomes) {
            System.out.print(nome.trim()+" ");//para remover os espaços em branco
        }
        System.out.println("\n-------------------------------");

        Scanner scanner = new Scanner(texto);
        scanner.useDelimiter(",");//por padrão o delimitar do scanner é o espaço em branco por isso é necessário apontar qual del. queremos.

        System.out.println("UTILIZANDO SCANNER: ");
        while (scanner.hasNext()){
           // System.out.print(scanner.next().trim()+" ");

            //Pegando os valores de acordo com o tipo de cada um no texto, com a class Scanner
            if (scanner.hasNextInt()){
                int num = scanner.nextInt();
                System.out.println("Int: "+num);
            } else if (scanner.hasNextBoolean()) {
            boolean boleano = scanner.nextBoolean();
            System.out.println("Boolean: "+boleano);
        }else {
            System.out.println(scanner.next());
        }
        }//while

        System.out.println("\n------------------------------- ");


    }//main

}
