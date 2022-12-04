package estudo.uanderson.javadevdojo.introducao;

public class EestruturasDeRepeticao01 {
    public static void main(String[] args) {
        //while, do while, for
        int contador = 0;

        while(contador < 10){
            System.out.println(contador);
            contador += 1; // contador = contador + 1
        }
        contador = 0;
        do{
            System.out.println("Dentro do do-while "+ ++contador);
        }while(contador < 10);


    }
}
