public class StringOperations02 {
    public static void main(String[] args) {
        String str1 = "apple";
        String str2 = "banana";
        String str3 = "apple";
        String str4 = "Apple";

        // Utilizando compareTo
        System.out.println("Comparando str1 e str2: " + str1.compareTo(str2)); // -1 (str1 < str2)
        System.out.println("Comparando str1 e str3: " + str1.compareTo(str3)); // 0  (str1 == str3)
        System.out.println("Comparando str1 e str4: " + str1.compareTo(str4)); // 32 (str1 > str4, devido à diferença de maiúsculas/minúsculas)

        // Utilizando equals
        System.out.println("Comparando str1 e str2: " + str1.equals(str2)); // false
        System.out.println("Comparando str1 e str3: " + str1.equals(str3)); // true
        System.out.println("Comparando str1 e str4: " + str1.equals(str4)); // false (diferença de maiúsculas/minúsculas)

   

    }//main
}//class
