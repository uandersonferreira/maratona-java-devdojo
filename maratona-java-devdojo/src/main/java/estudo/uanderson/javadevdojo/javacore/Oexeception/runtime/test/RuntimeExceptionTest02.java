package estudo.uanderson.javadevdojo.javacore.Oexeception.runtime.test;

public class RuntimeExceptionTest02 {
    public static void main(String[] args) {
       // System.out.println(divisao(5, 3));

        try{
            divisao(5, 3);
        }catch(RuntimeException ex){
            ex.printStackTrace();
        }

        System.out.println("Código finalizado!"); //essa linha é executada, pois estamos tratando na main a exceção lançada no method divisao, caso não fazemos a tratativa essa linha nunca iria ser executada.

        /*
        Irá gerar a seguinte Exception:
        Exception in thread "main" java.lang.ArithmeticException: / by zero
	at estudo.uanderson.javadevdojo.javacore.Oexeception.runtime.test.RuntimeExceptionTest02.divisao(RuntimeExceptionTest02.java:9)
	at estudo.uanderson.javadevdojo.javacore.Oexeception.runtime.test.RuntimeExceptionTest02.main(RuntimeExceptionTest02.java:5)

    Quando temos exeções unchecked :
   - PARA O JAVA NÃO É OBRIGATÓRIO TRATAR, MAS É RECOMENDADO!
   - PODEMOS USAR A FLAG NO METHOD INDICANDO QUE ELE PODE LANÇAR A EXEÇÃO, EMBORA NÃO SEJA MUITO COMUN
   EX: private  double method() throws IllegalArgumentException{ }
   - Normalmente, informamos na doc do java essas informações

         */
    }//main

    
    /**
     * @param n1 Não pode ser zero
     * @param n2 Não pode ser zero
     * @return divisão de n1 por n2
     * @throws IllegalArgumentException caso n1 ou n2 seja zero
     */

    private static double divisao(double n1, double n2) throws IllegalArgumentException{
      if (n2 == 0 || n1 ==0){
          throw new IllegalArgumentException("Argumento ilegal, não pode ser 0");
      }
      return n1/n2;
    }

    /*
    E POSSÍVEL DELEGAR A RESPONSABILIDADE DE TRATAMENTO DAS EXCEÇÕES
    DE UM METODO POR EXEMPLO PARA QUEM FOR CHAMAR O MÉTODO, BASTA COLOCAR:
    throws + NOME DA EXCEÇÃO APÓS OS PARAMETROS DO METODO. VALE RESSALTAR QUE SE CASO FOR LANÇADAS AS EXCEÇÕES PRA
    MAIN O TRATAMENTO DEVE SER FEITO, POIS SE LANÇADA PARA FRENTE A JVM IRÁ PARAR.
    E EXCEPTION RUNTIMEEXCEPTION NÃO OBRIGA QUEM CHAMA A TRATAR, JA IOEXCEPTION OBRIGA IMPLEMENTAR O TRATAMENTO
    QUANDO LANÇADAS PRA FRENTE.
    EX:
     private static double divisao(double n1, double n2) throws IllegalArgumentException{//NÃO IRÁ OBRIGAR A TRATAR
     private static double divisao(double n1, double n2) throws IOException {//OBRIGA A REALIZAR O TRATAMENTO

     DICA: QUANDO LANÇAR PRA FRENTE OU NÃO A EXCEÇÃO?

    1°- SE O METÓDO FOR PRIVADO É RECOMENDANDO TRATAR COM TRY/CATCH, POIS
    TEORICAMENTE NINGUÉM PODERÁ TER ACESSO A ELE.

    2°- SE O MÉTODO FOR PUBLICO PODE LANÇAR A EXCEÇÃO QUE QUEM ESTÁ CHAMANDO
     PODERÁ REALIZAR O TRATAMENTO DA FORMA QUE PREFERIR.

     3°- CASO QUEIRA REALIZAR O TRAMENTO E LANÇAR A EXEÇÃO PRA FRENTE, RECOMENDA-SE
     REALIZAR UM TRATAMENTO HIBRIDO, ONDE IRÁ SER FEITO O TRY/CATCH E LANÇADO A EXCEÇÃO
     PARA FRENTE COM O THROWS NO CATCH E THROWS IOEXCEPTION, APÓS O
     PARENTES.
     Ex:
  public static void criarNovoArquivo() throws IOException{
        File file = new File("arquivo\\teste.txt");

        try {
            boolean isCreate = file.createNewFile();
            System.out.println("Arquivo criado: "+isCreate);
        } catch (IOException e) {
            e.printStackTrace();
            throws e;
        }
    }//method

     */



}//class
