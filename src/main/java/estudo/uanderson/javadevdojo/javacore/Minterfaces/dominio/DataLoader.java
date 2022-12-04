package estudo.uanderson.javadevdojo.javacore.Minterfaces.dominio;

public interface DataLoader {
    public static final int MAX_DATE_SIZE = 10;
    public abstract  void load();
   public default void checkPermission(){
       System.out.println("Fazendo checagem de permissões");
   };

   public static void retrieveMaxDataSize(){
       System.out.println("Dentro do retrieveMaxDataSize da interface ");
   }

    /*
    POR PADRÃO NO JAVA TODOS OS MÉTODOS DE UMA INTERFACE, SÃO
    PUBLIC E ABSTRACT.

    -INTERFACE É VISTA COMO UM CONSTRATO ESTABELECIDO ENTRE AS CLASSSE
    QUE DEVE SER RESPEITADO.

    -QUANDO ADICIONAMOS MÉTODOS A INTERFACES, DEVEMOS IMPLEMENTAR ESSE
    NOVO MÉTODO EM TODAS AS CLASSES QUE UTLIZIAM/IMPLENTAM A INTERFACE.
    NO ENTANTO, ESSA PRÁTICA QUANDO SE TRATA DE SCALABILIDADE, NÃO
    É A MAIS ADEQUADA, PORTANDO, SEMPRE QUE SE PRECISAR CRIAR NOVOS
    MÉTODOS NAS INTERFACES, DEVE-SE UTILIZAR MÉTODOS CONCRETAS COM A
    DECLARAÇÃO DEFAULT a partir do java8+:
    EX:   default void checkPermission(){

   };

   -NÃO PODEMOS CRIAR OBJETOS DE INTERFACES.

   -QUANDO ESTAMOS SOBREESCREVENDO MÉTODOS DE UM INTERFACE NÃO
   PODEMOS COLOCAR UM MODIFICADOR DE ACESSO MAIS RESTRITIVO,
  DO QUE, O MODIFICADOR QUE ESTÁ NA SUPERCLASSE.

  //private -> default -> protected -> public
   -Do mais restritivo para o mais liberal

   -POR PADRÃO TODOS OS ATRIBUTOS SÃO UMA CONSTANTE.
   EX:     public static final int MAX_DATE_SIZE = 10;
   E É REDUNDANTE COLOCAR : public static final

   METODOS STATIC NUNCA SERÃO SOBREESCRITOS, POIS PERTENCEM A
   CLASSE, NESTE CASO A INTERFACE.
     */

}//class
