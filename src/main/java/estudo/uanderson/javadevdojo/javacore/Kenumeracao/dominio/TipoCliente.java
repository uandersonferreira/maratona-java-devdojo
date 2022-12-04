package estudo.uanderson.javadevdojo.javacore.Kenumeracao.dominio;

public enum TipoCliente {
     PESSOA_FISICA(1, "Person Fisica"),
     PESSOA_JURIDICA(2, "Person Jurídica");

   public final int VALOR;//garante que pessoa_fisica ou juridica tenha sempre a numeração definida associada a eles.
    public String nomeRelatorio;
     TipoCliente(int valor, String nomeRelatorio ) {
          this.VALOR = valor;
          this.nomeRelatorio = nomeRelatorio;
     }

     public static TipoCliente tipoClientePorNomeRelatorio(String nomeRelatorio){
         for (TipoCliente tipoCliente : values()) {
             if (tipoCliente.getNomeRelatorio().equals(nomeRelatorio)){
                 return tipoCliente;
             }
         }//for
         return null;

         /*
         Estamos Interando sobre os valores do Objeto TipoCliente(classe é um objeto)
         é comparando se o valor do tipocliente é igual ao valor que está sendo passado
         por paramentro.
          */
     }

    public String getNomeRelatorio() {
        return nomeRelatorio;
    }



    // OU
//    private int valor;
//    TipoCliente(int valor) {
//        this.valor = valor;
//    }
//
//    public int getValor() {
//        return valor;
//    }


    /*
Importante, resaltar que as constantes criadas, possuem um construtor
padrão, portanto ao querer adicionar paramentros para atribuir uma enumaração as opção,
devemos criar um novo construtor e passar os paramentros.
 */

    /*
    A CLASSE TIPOCLIENTE É UMA ENUMERAÇÃO(TIPO ESPECIAL DE CLASSE), ONDE
    TODOS OS ATRIBUTOS SE FOREM CRIADOS É CONSIDERADOS UMA CONSTANTE

    -E O TIPO DO ATRIBUTO CRIADO SERÁ SEMPRE O TIPO DA CLASSE.
    EX:
    PESSOA_FISICA É DO TIPO -> TipoCliente

    A enumeração é utilizada para forçar o usuário a inserir somente
    dados do tipo pre-definido na Classe TipoCliente. Sendo assim, quando realizamos
    uma gravação não será permitido outro tipo de dado a não ser os já criados eliminado
    possíveis erros.

    casos de uso:
    -caso queira que o usuário insira algum dia da semana, mês
    de modo geral é quando quersmos que escolham uma opção dentro de um
    várias opções possíves pertinentes ao que está sendo executado/desenvolvido.

     */
}
