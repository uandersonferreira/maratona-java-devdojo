package dio.br.com.uanderson.list.operacoesBasicas;

import java.util.*;

public class ListaTarefa{
    
    //Atributo
    private List<Tarefa> tarefaList;
    
    public ListaTarefa(){
        this.tarefaList = new ArrayList<>();
    }
    

    
    public void adicionarTarefa(String descricao){
        this.tarefaList.add(new Tarefa(descricao));
    }
    
    
    public void removerTarefa(String descricao){
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        
        for(Tarefa t : this.tarefaList){
            
            if(t.getDescricao().equalsIgnoreCase(descricao)){
               
                tarefasParaRemover.add(t);
                
            }//if
            
        }//for
        
        this.tarefaList.removeAll(tarefasParaRemover);
      
    }//method
    
    
    public int obterNumeroTotalTarefas(){
        return this.tarefaList.size();
    }
    
    public void obterDescricoesTarefas(){
        System.out.println(tarefaList);
    }
    
    
    
    public static void main(String[] args){
        
        ListaTarefa lista = new ListaTarefa();
        
       System.out.println("O número total de elementos na lista é: " + lista.obterNumeroTotalTarefas());
        
        lista.adicionarTarefa("Tarefa 1");
        lista.adicionarTarefa("Tarefa 1");
        lista.adicionarTarefa("Tarefa 2");

       System.out.println("O número total de elementos na lista é: " + lista.obterNumeroTotalTarefas());


        lista.removerTarefa("Tarefa 2");
        
       System.out.println("O número total de elementos na lista é: " + lista.obterNumeroTotalTarefas());

       lista.obterDescricoesTarefas();

    }
    

}//class ListaTarefa
    



