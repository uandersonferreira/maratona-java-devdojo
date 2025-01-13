package estudo.uanderson.javadevdojo.javacore.Oexeception.erro.test;

public class StakerOverflowTeste01 {//Error- de armazenamento de memória
    public static void main(String[] args) {
        recursividade();
    }//main


    public static void recursividade(){
        recursividade(); //fica se auto-chamando (o próprio método) até a memória acabar
    }
    /*
        Errors, não é possível recuperar em tempo de execução
     */
}//class

