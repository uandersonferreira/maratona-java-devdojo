package estudo.uanderson.javadevdojo.introducao;

public class EstruturasCondicionais02 {
    public static void main(String[] args) {
       /*
       1°-Idade <15 categoria infantil
       2°- Idade >= 15 e idade < 18 categoria juvenil
       3°-Idade >= 18 categoria adulto
        */
        int idade = 17;

        if (idade < 15) {
            System.out.println("Categoria Infantil");
            //categoria = "Categoria Infantil";
        } else if (idade >= 15 && idade < 18) {
            System.out.println("Categoria Juvenil");
            //categoria = "Categoria Juvenil";
        } else {
            System.out.println("Categoria Adulto");
            //categoria = "Categoria Adulto";
        }
        // System.out.println(categoria);
    }
}
