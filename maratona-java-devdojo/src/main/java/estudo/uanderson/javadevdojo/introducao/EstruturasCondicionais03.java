package estudo.uanderson.javadevdojo.introducao;

public class EstruturasCondicionais03 {
    public static void main(String[] args) {
        //OPERADOR TERNÁRIO- (Condição) ?verdadeiro : falso
        // Doar caso o salario seja maior que 5000.

        double salario = 6000;
        String mensagemDoar = "Eu vou doar R$500 reais, pro DevDojo.";
        String mensagemNaoDoar = "Eu não posso doar ainda, pro DevDojo.";
        //(Condição) ?verdadeiro : falso
        String resultado = salario > 5000 ? mensagemDoar : mensagemNaoDoar;

        System.out.println(resultado);


    }
}
