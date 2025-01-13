package estudo.uanderson.javadevdojo.introducao;

public class Arrays02 {
    public static void main(String[] args) {

        //Arrays Multidimensionais
        //1° Array => 1,2,3,4,5... Meses
        //2° Array => 31, 28, 31, 30 Dias de um Mês

        //A BASE 1° parte do array precisamos definir o tamanho, mas a segunda parte não é obrigatório.
       // int[][] diasMes = new int[12][];

        /*
            new int[BASE][ARRAYS]

                        [-] [-] [-]  A base terá as ref. de memória de 3 arrays
                         0   1   2

            [0] [0] [0]   [0] [0] [0]  [0] [0] [0]  Os 3 arrays terá 3 posições
             0   1   2     1   2   3    1    2  3

             A lógica é a mesma caso aumente a quantidade de arrays. E teremos que percorrer cada um 
             deles usando um fori ou foreach 

         */

        int[][] dias = new int[3][3];

        dias[0][0] = 10;
        dias[0][1] = 20;
        dias[0][2] = 30;

        dias[1][0] = 40;
        dias[1][1] = 50;
        dias[1][2] = 60;

        dias[2][0] = 70;
        dias[2][1] = 80;
        dias[2][2] = 90;

        for (int i = 0; i < dias.length; i++) {
            for (int x = 0; x < dias[i].length; x++) { // Para acessar as posições do array
                System.out.print(" "+dias[i][x]);// para imprimir o array em suas 3 posições
            }//2° for

        }//for

        System.out.println("\n==========================================");
        //OUTRA FORMA DE IMPRIMIR OS VALORES DO ARRAY

        for (int[] arrayBase : dias) {
            for (int num : arrayBase) {
                System.out.print(" "+num);
            }//2° for

        }//1° for


    }//main
}//class
