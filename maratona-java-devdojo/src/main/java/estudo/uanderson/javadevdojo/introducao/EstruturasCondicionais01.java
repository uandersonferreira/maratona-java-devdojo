package estudo.uanderson.javadevdojo.introducao;

public class EstruturasCondicionais01 {
    public static void main(String[] args) {

        int idade = 15;
        boolean isAutorizadoComprarBebida = idade >= 18;

        if (isAutorizadoComprarBebida) {
            System.out.println("Autorizado a comprar bebidas alcólicas");
        }
        if (!isAutorizadoComprarBebida) {
           /*
           "!", op. de negação só pode se usado se a variável for do tipo
           booleana.
            */
            System.out.println("Não autorizado a Comprar bebidas alcólicas");

        }
        int ano = 2021;

        if (ano > 2010) {
            System.out.println("Ano maior que 2010");
        } else {
            System.out.println("Ano é menor do que 2010");
        }


        System.out.println("Fora do if");
    }
}
