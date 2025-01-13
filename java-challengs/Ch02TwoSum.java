import java.util.*;

public class Ch02TwoSum {
    public static void main(String[] args){
        int[] numbers = new int[] {-2,3,7,4,8};
        int target = 7;
        int[] result = getTwoSum(numbers, target);
        System.out.println(result[0] + " | " + result[1]);
    }

    public static int[] getTwoSum(int[] numbers, int target){
        Map<Integer, Integer> visitedNumbers = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            int delta = target - numbers[i]; //  7 - (-2) = 9
            if(visitedNumbers.containsKey(delta)){ // contains 9 ? false
                return new int[] {i, visitedNumbers.get(delta)}; // 3, 
            }
            visitedNumbers.put(numbers[i], i); // {-2: 0} -> Isto significa que o número -2 foi visto no índice 0.
        }
        return new int[] {-1, -1};
    }

    /*
     
        Iteração 4 (i = 3):
        Número atual (numbers[3]): 4
        Diferenca: delta = target - numbers[3] = 7 - 4 = 3
        Verificação no mapa: 3 está em numerosVisitados com índice 1.
        Retorna os índices:
        Índices retornados: [3, 1]
     */
    
}//class

