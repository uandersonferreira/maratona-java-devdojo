package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.service;


import estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.domain.Members;

public class EmailDeliveryService implements Runnable {
    private final Members members;

    public EmailDeliveryService(Members members) {
        this.members = members;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName+ " Starting to deliver emails");
        while (members.isOpen() || members.pendingEmails() > 0){
            try {
                String retriveEmail = members.retriveEmail();
                if (retriveEmail == null) continue;
                System.out.println(threadName+ " enviando email para "+ retriveEmail);
                Thread.sleep(2000);
                System.out.println(threadName+ " enviou email com sucesso para "+ retriveEmail);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//while
        System.out.println("Todos os emails forma enviados com sucesso!");
    }//method run()
}
