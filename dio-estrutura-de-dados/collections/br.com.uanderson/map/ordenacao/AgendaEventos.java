package dio.br.com.uanderson.map.ordenacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AgendaEventos {

    private Map<LocalDate, Evento> eventosMap;

    public AgendaEventos() {
        this.eventosMap = new HashMap<>();
    }


    public void adicionarEvento(LocalDate data, String nome, String atracao){
        eventosMap.put(data, new Evento(nome, atracao));
    }

    public void exibirAgenda(){
        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);

        System.out.println(eventosTreeMap);

        /*
         * O TreeMap<> irá ordernar a lista, seguindo a ordem natural(crescente -> menor para o maior),      * levando em consideração o Objeto que representa a KEY, no nosso caso é o LocalDate que implementa * ChronoLocalDate é essa interface extends de Comparable<ChronoLocalDate>, portanto já 
         * têm uma implementação de compareTo(); 
         * 
         */
    }

    public void obterProximoEvento(){
        LocalDate dataAtual = LocalDate.now();
        LocalDate proximaData = null;
        Evento proximoEvento = null;

        Map<LocalDate, Evento> eventosTreeMap = new TreeMap<>(eventosMap);
        for(Map.Entry<LocalDate, Evento> entry : eventosTreeMap.entrySet()){
            if (entry.getKey().isEqual(dataAtual) || entry.getKey().isAfter(dataAtual) ) {
                proximaData = entry.getKey();
                proximoEvento = entry.getValue();

                System.out.println("O próximo evento: " + proximoEvento + " acontecerá na data " + proximaData);
                break;
            }
        }

   
        /*
         * Irá retornar o evento mais próximo de acontecer (futuramente) ou
         * que irá acontecer na data atual.
         * 
         */
    }

    public static void main(String[] args) {
        AgendaEventos agendaEventos = new AgendaEventos();


        agendaEventos.adicionarEvento(LocalDate.now().plusDays(5), "Evento 1", "Atração 1");
        agendaEventos.adicionarEvento(LocalDate.now().plusDays(1), "Evento 2", "Atração 2");
        agendaEventos.adicionarEvento(LocalDate.now(), "Evento 3", "Atração 3");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.APRIL, 12), "Evento 4", "Atração 4");
        agendaEventos.adicionarEvento(LocalDate.of(2024, Month.AUGUST, 5), "Evento 5", "Atração 5");


        //LocalDate.now().plusDays(1).plusMonths(1).plusHours(2); Para adicionar
        //LocalDate.now().minusDays(1).minusMonths(1).minusHours(2); Para subtrair 

        agendaEventos.exibirAgenda();

        agendaEventos.obterProximoEvento();
    }

    
}//class


