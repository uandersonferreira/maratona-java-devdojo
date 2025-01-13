public class UniqueNums{
    public static void main(String[] args) {
        int[] numbers = new int[5];
        int num = 0;
        int numValues = 0;
        boolean valid = true;
        Scanner in = new Scanner(System.in);

        while(numValues < numbers.length){
            do{
            valid = true;
            System.out.println("Please enter a unique number: ");
            num = in.nextInt();
            for(int i = 0; i < numValues; i++){
                if(numbers[i] == num){
                    System.out.println("Number already exists");
                    valid = false;
                    break;
            }
            }
            }while(!valid);

            numbers[numValues] = num;  
            numValues++;
        }



    }//main
}//class

/*
 * Claro! Aqui está a lista resumida com a sintaxe de cada uma das declarações de arrays em Java:

1. **Declaração com Tamanho Específico sem Inicialização**:
    ```java
    String[] myBouquet = new String[6];
    int[] numbers = new int[5];
    ```

2. **Declaração com Inicialização de Elementos**:
    ```java
    int[] numbers = {7, 24, 352, 2, 37};
    String[] flowers = {"Rose", "Lily", "Tulip", "Daisy"};
    ```

3. **Declaração e Inicialização com Tamanho Específico e Elementos**:
    ```java
    int[] numbers = new int[]{7, 24, 352, 2, 37};
    String[] flowers = new String[]{"Rose", "Lily", "Tulip", "Daisy"};
    ```

4. **Declaração de Arrays Multidimensionais**:
    - **Array Bidimensional (Matriz)**:
        ```java
        int[][] matrix = new int[3][3];
        int[][] predefinedMatrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        ```
    - **Array Tridimensional**:
        ```java
        int[][][] threeDArray = new int[3][3][3];
        int[][][] predefinedThreeDArray = {
            {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            },
            {
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18}
            },
            {
                {19, 20, 21},
                {22, 23, 24},
                {25, 26, 27}
            }
        };
        ```

5. **Declaração e Inicialização em Linhas Separadas**:
    ```java
    int[] numbers;
    numbers = new int[]{7, 24, 352, 2, 37};
    ```
 */