package estudo.uanderson.javadevdojo.javacore.Oexeception.execption.dominio;

public class LoginInvalidException extends Exception {
    public LoginInvalidException() {
        super("Login Inválido!");
    }

    public LoginInvalidException(String message) {
        super(message);
    }
    //CRIANDO UMA EXCEPTION PERSONALIZADA
}

