package estudo.uanderson.javadevdojo.javacore.ZZGconcorrencia.test;

import java.util.concurrent.*;

public class FutureTest01 {
    public static void main(String[] args)  {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Double> dollarRequest = executorService.submit(() -> {
            TimeUnit.SECONDS.sleep(5);
            return 4.25D;
        });


        System.out.println("doSomething: "+doSomething());
        Double dollarResponse = null;
        try {
            dollarResponse = dollarRequest.get(3, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
           e.printStackTrace();
        }finally {
            executorService.shutdown();
        }
        System.out.println("dollarRequest: "+dollarResponse);

    }//main

    private static long doSomething(){
        System.out.println(Thread.currentThread().getName());
       long sun = 0;
        for (int i = 0; i <1_000_000 ; i++) {
             sun += i;
        }

        return sun;
    }//method doingSomething

}//clas
/*
ExecutorService -> O Java ExecutorService é a interface que
nos permite executar tarefas em threads de forma assíncrona.
A interface Java ExecutorService está presente no pacote
java.util.concurrent. O ExecutorService ajuda na manutenção
de um pool de threads e atribui tarefas a eles. Ele também
fornece a facilidade de enfileirar tarefas até que haja um
encadeamento livre disponível se o número de tarefas for
maior que os encadeamentos disponíveis.

METHODS:
boolean awaitTermination(long timeout, TimeUnit unit):
Esse método bloqueia a entrada da tarefa em ExecutorService
até que todas as tarefas tenham sido concluídas após a
solicitação de desligamento, ou o tempo limite determinado
ocorra, ou o thread atual seja interrompido, o que
ocorrer primeiro

<T> List<Future<T>> 	invokeAll(Collection<? extends Callable<T>> tasks):
Executa as tarefas dadas, retornando uma lista de futuros segurando
os seus status e resultados quando todos estiverem concluídos.

<T> List<Future<T>> 	invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
Executa as tarefas dadas, retornando uma lista de futuros segurando
seu status e resultados quando tudo estiver completo ou o tempo
limite expirar, o que ocorrer primeiro.

<T> T 	invokeAny(Collection<? extends Callable<T>> tasks)
Executa as tarefas fornecidas, retornando o resultado de um que
foi concluído com sucesso (ou seja, sem jogar uma exceção), se houver.

<T> T 	invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit)
Executa as tarefas fornecidas, retornando o resultado de um que
foi concluído com sucesso (ou seja, sem jogar uma exceção), se houver,
antes que o tempo limite determinado termine.

boolean 	isShutdown()
Retorna verdadeiro se este executor foi desligado.

boolean 	isTerminated()
Retorna verdadeiro se todas as tarefas forem concluídas
após o desligamento.

void 	shutdown()
Inicia um desligamento ordenado no qual foi enviado anteriormente
tarefas são executadas, mas nenhuma nova tarefa será aceita.

List<Runnable> 	shutdownNow():
Tenta parar todas as tarefas em execução ativa, interrompe o
processamento de tarefas em espera e retorna uma lista das tarefas
que aguardavam execução.

<T> Future<T> 	submit(Callable<T> task):
Envia uma tarefa de retorno de valor para execução e retorna um Futuro
representando os resultados pendentes da tarefa.

Future<?> 	submit(Runnable task):
Envia uma tarefa executável para execução e retorna um Future representando essa tarefa.

<T> Future<T> 	submit(Runnable task, T result)
Envia uma tarefa executável para execução e retorna um Future representando essa tarefa.

Link:https://www.javatpoint.com/java-executorservice
-----------------------///-------------------------------------

Future -> Em Java , Future é uma interface que pertence ao
java.util.concurrent pacote . É usado para representar o
resultado de uma computação assíncrona. A interface fornece
os métodos para verificar se a computação foi concluída ou não,
para aguardar sua conclusão e para recuperar o resultado da
computação. Uma vez que a tarefa ou computação é concluída,
não se pode cancelar a computação.

boolean cancel(boolean mayInterruptIfRunning) - tenta cancelar
 a execução desta tarefa. Retorna false se a tarefa não puder
 ser cancelada, normalmente porque já foi concluído
 normalmente; verdade caso contrário

V get()-Aguarda, se necessário, a conclusão do cálculo e,
 em seguida, recupera seu resultado.

(Ler a máteria do link para esclarecimentos)
V get(long timeout, TimeUnit unit) - Aguarda, se necessário,
 no máximo o tempo determinado para o cálculo para
 concluir e, em seguida, recupera seu resultado,
 se disponível.Se Future não obtiver nenhum resultado dentro
 do tempo especificado, uma TimeoutException será lançada
 pelo Future. (Impede o bloqueio de uma atividade em execução)

boolean isCancelled()- para verificar se a tarefa assíncrona
representada por Future foi cancelada ou não. Retorna
verdadeiro se a tarefa for cancelada com sucesso, senão retorna falso

boolean isDone() -verificar se a tarefa assíncrona foi concluída ou não
Retorna verdadeiro se esta tarefa for concluída

Link: https://www.javatpoint.com/java-future-example

 */