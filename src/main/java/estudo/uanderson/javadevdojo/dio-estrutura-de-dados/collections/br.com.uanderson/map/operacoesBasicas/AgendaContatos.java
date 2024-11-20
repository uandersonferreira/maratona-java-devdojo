package dio.br.com.uanderson.map.operacoesBasicas;

import java.util.*;

public class AgendaContatos {
    
    private Map<String , Integer> agendaContatoMap;
    
    public AgendaContatos(){
        this.agendaContatoMap = new HashMap<>();
    }
    
    public void adicionarContato(String nome, Integer telefone){
        agendaContatoMap.put(nome, telefone); // o put serve tanto paar salvar, como para atualizar, caso seja chamado uma key já existente irá atualizar o value associado.
    }
    
    public void removerContato(String nome){
        if(!agendaContatoMap.isEmpty()){ // se vazio = true NEGA é virá FALSE
            agendaContatoMap.remove(nome);
        }
        /*
        Não é necessário interar sobre o MAP pois o nome é nossa Key é as 'chaves'
        são únicas dentro da estrutura.
        */
    }
    
    
    public void exibirContatos(){
        System.out.println(agendaContatoMap);
    }
    
    public Integer pesquisarPorNome(String nome){
        Integer numeroPorNome = null;
        
        if(!agendaContatoMap.isEmpty()){
            numeroPorNome = agendaContatoMap.get(nome);
        }
        
        return numeroPorNome;
    }

    
    public static void main(String[] args){
        AgendaContatos agendaContatos = new AgendaContatos();
        
         agendaContatos.adicionarContato("Camila", 123456);
         agendaContatos.adicionarContato("Camila", 5665);
         agendaContatos.adicionarContato("Camila Cavalcante", 11111111);
         agendaContatos.adicionarContato("Camila DIO", 6555548);
         agendaContatos.adicionarContato("Maria Silva", 11111111);
         
    
        agendaContatos.exibirContatos();
    
        agendaContatos.removerContato("Maria Silva");
        
        agendaContatos.exibirContatos();
        
        System.out.println("O número é: " + agendaContatos.pesquisarPorNome("Camila DIO"));
        

    }//main
    
    
}//class





















