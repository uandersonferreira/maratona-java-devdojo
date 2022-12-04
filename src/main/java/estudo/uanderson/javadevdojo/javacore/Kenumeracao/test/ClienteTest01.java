package estudo.uanderson.javadevdojo.javacore.Kenumeracao.test;

import estudo.uanderson.javadevdojo.javacore.Kenumeracao.dominio.Cliente;
import estudo.uanderson.javadevdojo.javacore.Kenumeracao.dominio.TipoCliente;
import estudo.uanderson.javadevdojo.javacore.Kenumeracao.dominio.TipoPagamento;

public class ClienteTest01 {
    public static void main(String[] args) {
        Cliente cliente1  = new Cliente("Uanderoson", TipoCliente.PESSOA_FISICA, TipoPagamento.DEBITO);
        Cliente cliente2  = new Cliente("Oliver", TipoCliente.PESSOA_JURIDICA, TipoPagamento.CREDITO );

        System.out.println(cliente1);
        System.out.println(cliente2);

        System.out.println(TipoPagamento.DEBITO.calcularDesconto(100));
        System.out.println(TipoPagamento.CREDITO.calcularDesconto(100));


        //Buscando o valor do atributo-utilizando o metodo valueof
        TipoCliente tipoCliente1 = TipoCliente.valueOf("PESSOA_FISICA");
        System.out.println(tipoCliente1.getNomeRelatorio());

        //Buscando o atributo pelo seu valor atráves do método criado
        TipoCliente tipoCliente2 = TipoCliente.tipoClientePorNomeRelatorio("Person Fisica");
        System.out.println(tipoCliente2);

    }//main
}//class
