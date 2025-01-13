package estudo.uanderson.javadevdojo.javacore.Npolimorfismo.servico;

import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Produto;
import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Tomate;

public class CalculadoraImposto {

    public static void  calcularImposto(Produto produto){
        System.out.println("Relatório de Imposto");
        double imposto = produto.calcularImposto();
        System.out.println("Produto: "+ produto.getNome());
        System.out.println("Valor: "+ produto.getValor());
        System.out.println("Imposto a ser pago: "+imposto);

        if (produto instanceof Tomate){
            Tomate tomate = (Tomate) produto;
            System.out.println(tomate.getDataDeValidade());

            //Alternativa->
            // System.out.println(((Tomate) produto).getDataDeValidade());
        }
    }//method





    /*
    QUANDO NÃO  ESTAMOS ACESSANDO NENHUM ATRIBUTO DE CLASSE
    PODEMOS TRANFORMAR OS EM ESTATICOS (STATIC). PORTANDO NÃO É
    NECESSÁRIO CRIAR UM OBJETO DA CLASSE PARA ACESSAR OS MÉTODOS
    NA MAIN.

    NESTE EXEMPLO FOI APLICADO O POLIFORMISMO DOWNCAST PAI PARA O FILHO

     */
}//class
