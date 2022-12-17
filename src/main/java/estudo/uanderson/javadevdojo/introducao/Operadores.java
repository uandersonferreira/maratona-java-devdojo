package estudo.uanderson.javadevdojo.introducao;

public class Operadores {
    public static void main(String[] args) {
      int numero01 = 10;
      int numero02 = 20;
        System.out.println(numero01+numero02);
        /*
        Se definir valores inteiros o resulatdo será um número inteiro.
        ex:
        int num01 = 10;
        int num02 = 20;
        System.out.println(num01+num02);
        R= 0

        Mas e possível força a variável a atribuir um determinado valor
        System.out.println(num01+(double)num02);
        R= 0.5
        Tomar cuidado com a concatenação dentro do "sout".

        System.out.println("O valor da variável é: "+num01+num02);
        R=O valor da variável é: +num01+num02
         */
        // Resto(%)
        int resto = 21 % 7;
        System.out.println(resto);

        // maior(>),menor(<),menor ou igual(<=),maior ou igual(>=),igual(==), diferente(!=).
        boolean isDezMaiorQueVinte = 10 > 20;
        boolean isDezMenorQueVinte = 10 < 20;
        boolean isDezIgualeVinte = 10 == 20;
        boolean isDezIgualeDez = 10 == 10;
        boolean isDezDiferenteVinte = 10 != 20;

        System.out.println("isDezMaiorQueVinte: "+isDezMaiorQueVinte);
        System.out.println("isDezMenorQueVinte: "+isDezMenorQueVinte);
        System.out.println("isDezIgualeVinte: "+isDezIgualeVinte);
        System.out.println("isDezIgualeDez: "+isDezIgualeDez);
        System.out.println("isDezDiferenteVinte: "+isDezDiferenteVinte);

        //Não é possível comparar valores "incomparavéis", tipo Strings e Valores Númericos.

        //AND( && ), OR( || ), NOT( ! )

        int idade = 35;
        float salario = 4500F;
        boolean isDentroDaLeiMaiorQueTrinta = idade >= 30 && salario >= 4000;
        boolean isDentroDaLeiMenorQueTrinta = idade < 30 && salario >= 4000;

        System.out.println("isDentroDaLeiMaiorQueTrinta: "+isDentroDaLeiMaiorQueTrinta);
        System.out.println("isDentroDaLeiMenorQueTrinta: "+isDentroDaLeiMenorQueTrinta);

        double valorTotalContaCorrente = 500;
        double valorTotalContaPoupanca = 6000;
        float valorPlaytation = 5000;

        boolean isPlaystationCincoCompravel = valorTotalContaCorrente > valorPlaytation || valorTotalContaPoupanca > valorPlaytation;
        System.out.println("isPlaystationCincoCompravel: "+isPlaystationCincoCompravel);

        //OPERADORES DE ATRIBUIÇÃO
       // =, +=, -=, *=, /=, %=

      double bonus = 1000;
      //bonus = bonus + 1000;
      bonus += 1000;
      System.out.println(bonus);

      //++, --
      int contador = 0;
      contador += 1;// contador = contador + 1
      contador++; // primeiro executa depois imcrementa
      contador--;
      ++contador; // primeiro imcrementa depois executa
      --contador;

      System.out.println("Contador: "+contador);
      int contador2 = 0;
      System.out.println("Contador2: "+contador2++);
      System.out.println("Contador2: "+contador2);








    }
}
