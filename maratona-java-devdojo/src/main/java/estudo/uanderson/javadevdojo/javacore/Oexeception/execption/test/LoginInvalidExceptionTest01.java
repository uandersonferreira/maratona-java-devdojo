package estudo.uanderson.javadevdojo.javacore.Oexeception.execption.test;

import estudo.uanderson.javadevdojo.javacore.Oexeception.execption.dominio.LoginInvalidException;

import java.util.Scanner;

public class LoginInvalidExceptionTest01 {
    public static void main(String[] args) {
        try {
            logar();
        } catch (LoginInvalidException e) {
            e.printStackTrace();
        }
    }

    public static void logar() throws LoginInvalidException {
        Scanner scaner = new Scanner(System.in);

        String userNameDB = "Uanderson";
        String senhadB = "pão de queijo";

        System.out.print("Informe o Usuário: ");
        String usernameDigitado = scaner.nextLine();
        System.out.print("Informe a sua Senha: ");
        String senhaDigitada = scaner.nextLine();

        if (!userNameDB.equals(usernameDigitado) || !senhadB.equals(senhaDigitada)){
            throw new LoginInvalidException("Usuário ou senha Inválidos");
        }
        //UTILIZANDO A EXCEPTION PERSONALIZADA CRIADA.

        System.out.println("Usuário Logado com Sucesso!");

    }
}
