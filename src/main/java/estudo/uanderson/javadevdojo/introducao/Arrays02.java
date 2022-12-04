package estudo.uanderson.javadevdojo.introducao;

public class Arrays02 {
    public static void main(String[] args) {

        //Arrays Multidimensionais

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
                System.out.println(dias[i][x]);// para imprimir o array em suas 3 posições
            }//2° for

        }//for
        System.out.println("==========================================");
        //OUTRA FORMA DE IMPRIMIR OS VALORES DO ARRAY

        for (int[] arrayBase : dias) {
            for (int num : arrayBase) {
                System.out.println(num);
            }//2° for

        }//1° for


    }//main
}//class
