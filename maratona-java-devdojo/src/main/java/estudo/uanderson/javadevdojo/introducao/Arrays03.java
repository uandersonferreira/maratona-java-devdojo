package estudo.uanderson.javadevdojo.introducao;

public class Arrays03 {
    public static void main(String[] args) {
        //formas de inicializar um array multidimencional

        int[] arrayDeTresPosicoes = {1,2,3};

        int[][] arrayInt = new int[3][];

        arrayInt[0] = new int[2];//Por padrão os valores alocados nestes dois espaços é 0.
        arrayInt[1] = arrayDeTresPosicoes;
        arrayInt[2] = new int[]{1,2,3,4,5,6};

        for (int[] arrayBase : arrayInt) {// cria uma referencia para ter acesso ao arrayInt
            for (int num : arrayBase) {//
                System.out.print(num + " ");
            }
        }
        System.out.println("\n==================================================");
        // Outra forma de se innicializar um array multidimencional

        String[][] arrayDeString = {{"*","*"},{"*","*","*"},{"*","*","*","*","*","*"}};

        for (String[] arrayBase : arrayDeString) {// cria uma referencia para ter acesso ao arrayInt
            System.out.println("\n-----");
            for (String string : arrayBase) {//
                System.out.print(string + "  ");
            }
        }

        int[][] arrayInt2 = { {0,0}, {1,2,3}, {1,2,3,4,5,6} }; 
        /* 
        BASE VAI SER 3 {},{},{} e a referência para os arrays, vai ser a quantidade de 
        elementos que cada {} possui no caso vai ser um array de: 2|3|6 posições.

        */



    }//main
}//class
