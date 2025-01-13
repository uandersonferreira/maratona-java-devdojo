import java.util.*;

public class Ch02TwoSum2 {
    public static void main(String[] args){
        int[] numbers = new int[] {-2,3,7,4,8};
        int target = 7;
        int[] result = getTwoSum(numbers, target);
        System.out.println(result[0] + " | " + result[1]);
    }

    public static int[] getTwoSum(int[] numbers, int target){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    
}//class

