import java.util.*;

public class ScannerMain {
    public static void main(String[] args) {
    
    Scanner in = new Scanner(System.in);
    
    boolean boolVal;
    byte byteVal;
    char charVal;
    short shortVal;
    int intVal;
    long longVal;
    float floatVal;
    double doubleVal;
    
    System.out.print("Please enter a boolean value: ");
    boolVal = in.nextBoolean();
    
    System.out.print("Please enter a byte value: ");
    byteVal = in.nextByte();
    
    System.out.print("Please enter a char value: ");
    charVal = in.next().charAt(0);
    
    System.out.print("Please enter a short value: ");
    shortVal = in.nextShort();
    
    System.out.print("Please enter a int value: ");
    intVal = in.nextInt();
    
    System.out.print("Please enter a long value: ");
    longVal = in.nextLong();
    
    System.out.print("Please enter a float value: ");
    floatVal = in.nextFloat();
    
    System.out.print("Please enter a double value: ");
    doubleVal = in.nextDouble();
    
    in.close();
    
    System.out.println("boolean value: "+ boolVal);
    System.out.println("byte value: "+ byteVal);
    System.out.println("char value: "+ charVal);
    System.out.println("short value: "+ shortVal);
    System.out.println("int value: "+ intVal);
    System.out.println("long value: "+ longVal);
    System.out.println("float value: "+ floatVal);
    System.out.println("double value: "+ doubleVal);

  }
}