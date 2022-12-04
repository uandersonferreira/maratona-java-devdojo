package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import estudo.uanderson.javadevdojo.javacore.ZZFthread.domain.Members;
import estudo.uanderson.javadevdojo.javacore.ZZFthread.service.EmailDeliveryService;

import javax.swing.*;

public class EmailDeliveryTeste01 {
    public static void main(String[] args) {
        Members members = new Members();

        Thread jiraya = new Thread(new EmailDeliveryService(members), "Jiraya");
        Thread kakashi = new Thread(new EmailDeliveryService(members), "Kakashi");

        jiraya.start();
        kakashi.start();
        while (true){
            String email = JOptionPane.showInputDialog("Entre com seu email:  ");
            if (email == null || email.isEmpty()){
                members.closed();
                break;
            }//if
            members.addMembersEmail(email);
        }//while

    }//main
}//class
