package dio.br.com.uanderson.set.pesquisa;

import java.util.*;


public class AgendaContatos{
    
    private Set<Contato> contatoSet;
    
    public AgendaContatos(){
        this.contatoSet = new HashSet<>();
    }
    
    
    public void adicionarContato(String nome, int numero){
        contatoSet.add(new Contato(nome, numero));
    }
    
    public void exibirContatos(){
        System.out.println(contatoSet);
    }
    
    public Set<Contato> pesquisarPorNome(String nome){
        Set<Contato> contatosPorNome = new HashSet<>();
        
        for(Contato c : contatoSet){
            if(c.getNome().startsWith(nome)) { //buscar todos os contatos que começãm por uma sequência uander , uanderson, uanderson 123, ...
                contatosPorNome.add(c);
            }
        }
        
        return contatosPorNome;
    }
    
    public Contato atualizarNumeroContato(String nome, int numero){
        Contato contatoAtualizado = null;
        
        for(Contato c : contatoSet){
            if(c.getNome().equalsIgnoreCase(nome)){
                c.setNumero(numero);
                contatoAtualizado = c;
                break; //Interrompe, pois Não existe nenhum outro contato com o memso nome
            }
        }
        
        return contatoAtualizado;
    }
    
    
    

    public static void main(String[] args){
         AgendaContatos agendaContatos = new AgendaContatos();
         
         agendaContatos.exibirContatos();
         
         agendaContatos.adicionarContato("Camila", 123456);
         agendaContatos.adicionarContato("Camila", 5665);
         agendaContatos.adicionarContato("Camila Cavalcante", 11111111);
         agendaContatos.adicionarContato("Camila DIO", 6555548);
         agendaContatos.adicionarContato("Maria Silva", 11111111);
         
         agendaContatos.exibirContatos();
         
         System.out.println(agendaContatos.pesquisarPorNome("Camila"));

        System.out.println("Contato atualizado: " + agendaContatos.atualizarNumeroContato("Maria Silva", 555555555));        
    
        agendaContatos.exibirContatos();
        
    }//main
    
    
}//class

