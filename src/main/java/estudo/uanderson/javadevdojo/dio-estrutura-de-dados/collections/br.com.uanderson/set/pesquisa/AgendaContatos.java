package dio.br.com.uanderson.set.pesquisa;

import java.util.*;

class Contato {
    
    private String nome;
    private int numero;
    
    public Contato(String nome, int numero){
        this.nome = nome;
        this.numero = numero;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public void setNumero(int numero){
        this.numero = numero;
    }
    
    @Override
    public String toString(){
        return "{ " + nome + ", " + numero + " }" ;
    }
    
    // Permite diferenciar os objetos do tipo Contato (determina se são iguais ou não)
    // O que os torna iguais ou diferentes ? (atributos)
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Contato contato)) return false;
        return getNome() == contato.getNome();
        
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(getNome());
    }
    
}//class



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

