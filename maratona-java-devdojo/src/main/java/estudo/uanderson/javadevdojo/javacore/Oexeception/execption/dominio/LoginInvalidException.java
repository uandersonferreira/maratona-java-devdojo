package estudo.uanderson.javadevdojo.javacore.Oexeception.execption.dominio;

public class LoginInvalidException extends Exception {
    
    public LoginInvalidException() {
        super("Login Inválido!");
    }

    public LoginInvalidException(String message) {
        super(message);
    }

    /* 
        CRIANDO UMA EXCEPTION PERSONALIZADA 

        -> nome + Exception no final (conversão java/boas práticas) 
        ex: LoginInvalidException

        -> Escolher se sera uma execeção do tipo checada (Tratamento obrigatório) ou
           não chegada ( tratamento é Opcional, mas recomendavél).

           - Exception ou RuntimeException (Lembrar da Hierarquia delas)

        -> Pode fornecer uma implementação default ou permitir que quem lancar a
        execeção forneça a mensagem de erro.
            - Basta sobrescrever o construtor chamando o method super que faz referência ao construtor da class Exception que estamos herdando/estendendo, no caso a class 'PAI'

     
     
    */
}

