package estudo.uanderson.javadevdojo.javacore.Oexeception.execption.dominio;

import java.io.FileNotFoundException;

public class Pessoa {
    public void salvar() throws LoginInvalidException, FileNotFoundException {
        // Este método declara duas exceções verificadas:
        // - LoginInvalidException (exceção personalizada).
        // - FileNotFoundException (exceção padrão do Java).
        System.out.println("Salvando Pessoa");
    }
    
}//class
