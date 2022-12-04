package estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.dominio;

public class Calculadora {

    public void soma(){
        System.out.println("Soma: "+(20+10));
    }

    public void subtaiDoisNumeros(){
        System.out.println("Subtração: "+(20-10));
    }

    public void multiplaDoisNumeros(int num1, int num2){
        System.out.println("Multiplicação: "+(num1*num2));
    }

    public double divideDoisNumeros(double num1, double num2) {
        if (num1 == 0 || num2 == 0) {// ou num1 ou num2 diferente de 0(!=)
            return 0;
        } else {
            return num1 / num2;
        }
    }

    public void imprimeDivideDoisNumeros(double num1, double num2) {
        if (num1 == 0 || num2 == 0) {// ou num1 ou num2 diferente de 0(!=)
            System.out.println("Não existe divisão por zero!");
        } else {
            System.out.println( num1 / num2);
        }
    }//método

    public void alterandoDoisNumeros(int num1, int num2){
        num1 = 99;
        num2 = 33;

        System.out.println("Dentro do alterandoDoisNumeros:");
        System.out.println("Num1: "+num1);
        System.out.println("Num2: "+num2);
    }

    public void somaArray (int[] numeros){
        int soma= 0;
        for (int num: numeros) {
           soma += num;
        }
        System.out.println("Soma: "+soma);
    }//método

    public void somaVarArgs(int... numeros){// se for passar mais de um argumento para o método o varArgs tem que ser o último. pois o java não sabe quando ele deve parar, já está tranfromando tudo em um array.
        int soma= 0;
        for (int num: numeros) {
            soma += num;
        }
        System.out.println("Soma: "+soma);
    }



    /*
    __ Método sem retorno é representado pela palavra reservada: void.

   obs: Se o método possuir como argumento mais de 3, para boas
   práticas recomenda criar outros métodos menores.
     */
}//class
