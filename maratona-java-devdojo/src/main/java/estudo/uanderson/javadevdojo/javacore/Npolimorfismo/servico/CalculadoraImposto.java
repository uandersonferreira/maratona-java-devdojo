package estudo.uanderson.javadevdojo.javacore.Npolimorfismo.servico;

import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Produto;
import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.dominio.Tomate;

public class CalculadoraImposto {
    /*
    QUANDO NÃO  ESTAMOS ACESSANDO NENHUM ATRIBUTO DE CLASSE NOS MÉTODOS
    PODEMOS TRANFORMA-LOS EM ESTATICOS (STATIC). PORTANDO, NÃO É
    NECESSÁRIO CRIAR UM OBJETO DA CLASSE PARA ACESSAR OS MÉTODOS
    NA MAIN.

    NESTE EXEMPLO FOI APLICADO O POLIFORMISMO DOWNCASTING -> PAI PARA O FILHO
     */  

    public static void  calcularImposto(Produto produto){
        System.out.println("Relatório de Imposto");
        double imposto = produto.calcularImposto();
        System.out.println("Produto: "+ produto.getNome());
        System.out.println("Valor: "+ produto.getValor());
        System.out.println("Imposto a ser pago: "+imposto);

        //Regra: printar data de validade caso o objeto seja um Tomate
        if (produto instanceof Tomate){ 
            
            Tomate tomate = (Tomate) produto; //Downcasting

            System.out.println(tomate.getDataDeValidade());
            /* 
            - Verifica a linha de herança, pois o cast so pode de filho para pai ou de pai para filho, de filho para filho não.
            
           -  OBJETO nome_variavel = (OBJETO) VARIÁVEL-DE-REFERÊNCIA-SUPERCLASS;

            Alternativa->
            System.out.println(((Tomate) produto).getDataDeValidade());

            */
        }
    }//method
   
}//class
