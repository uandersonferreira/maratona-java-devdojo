package estudo.uanderson.javadevdojo.introducao;

public class Arrays01 {
    public static void main(String[] args) {
        int[] idades = new int[3]; //Por default os valores das posições são zeros "0"
        //  Array são do type reference (Objeto em memória) e não primitivos
        idades[0] = 18;
        idades[1] = 19;
        idades[2] = 20;

//        System.out.println(idades[0]);
//        System.out.println(idades[1]);
//        System.out.println(idades[2]);
//        System.out.println(idades[3]); //gera uma exception ArrayIndexOutOfBoundsException pois a posição não existe

        for (int i: idades) {
            System.out.println(i);
        }

                // byte, short, int, long, float e double os valores iniciais do array é 0
        // char: ' \ u000' (espaço em branco)
        // boolean: false
        //Type reference (Objeto) -> String: null

        String[] nomes = new String[3];
        nomes[0] = "Goku";
        nomes[1] = "Kurosaki";
        nomes[2] = "Luffy";

        //O tamanho do array, não pode mudar dinamicamente
        //i < nomes.length(); pois começa em 0 
        // i = 0; tamanho = 3 => goku
        // i = 1; tamanho = 3 => Kurosaki
        // i = 2; tamanho = 3 => Luffy (Para aqui, pois no proximo o i = 3 e nosso array não têm indice 3 )
        // i = 3; tamanho = 3 => daria exception caso tentassemos acessar
        for(int i = 0; i < nomes.length; i++){
            System.out.println(nomes[i]);
        }

        //FORMAS DE INICIALIZAR UM ARRAY
        int[] numeros = new int[3];
        int[] numeros2 = {1,2,3,4,5};
        int[] numeros3 = new int[]{1,2,3,4,5}; //calcula o tamanho baseando-se nos valores dentro de { }

        for(int i = 0; i < numeros3.length; i++ ){
            System.out.println(numeros3[i]);
        }

        //int num = 0; //Gera erro, pois estamos criando outra de mesmo nome dento do for
        for(int num : numeros3){
            System.out.println(num);
            //O foreach possui internamente um indice/ponteiro que controla as posições a serem pecorridas
        }

        int num = 0; //permite a declaração de variavel com o mesmo nome, mas após o foreach


     }//main
}//class

