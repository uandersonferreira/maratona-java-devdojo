public class FizzBuzz {
    public static void main(String args[]) {
        printFizzBuzz(100);
       
      }//main
      
        public static void printFizzBuzz(int n){
            for(int i = 1; i <= 100; i++){
                  if ( (i % 3 == 0) && (i % 5 == 0) ){
                      System.out.println("FizzBuzz");
                  }else if (i % 3 == 0){
                      System.out.println("Fizz");
                  }else if (i % 5 == 0){
                      System.out.println("Buzz");
                  }else{
                       System.out.println(i);
                  }
        
            }
    
        }//method
      
    }//class


    // https://www.youtube.com/watch?v=h36mQC3JFMo&list=PLqq-6Pq4lTTZgXnsBNQwCWdKR6O6Cgk1Z