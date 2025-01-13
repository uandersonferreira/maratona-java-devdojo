public class StringOperations{
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Uanderson";
        String str3 = "You are "+ str2;

    //display a welcome message to screen
    System.out.println("Welcome: " + str3);
    
    //display the length of a string
    System.out.println("length: "+str1.length());
    
    //display a substring of str1 beginning with character 0,
    //up to, but not including character 5
    System.out.println(str3.substring(0,5));
   
    //display a string value in toUpperCase
    System.out.println(str2.toUpperCase());

    //compare 2 strings para ver se elas são iguais ou      
    //identifique qual valor da string vem primeiro
    System.out.println(str1.compareTo(str2));
    //compare 2 strings para ver se elas são iguais 
    System.out.println(str1.equals(str2));

   

    }//main
}//class

//String str3; //uninitialized string (un - negação)