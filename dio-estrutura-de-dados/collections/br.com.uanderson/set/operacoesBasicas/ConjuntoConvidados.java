package dio.br.com.uanderson.set.operacoesBasicas;

import java.util.*;

class Convidado {
    
    private String nome;
    private int codigoConvite;
    
    public Convidado(String nome, int codigoConvite){
        this.nome = nome;
        this.codigoConvite = codigoConvite;
    }
    
    public String getNome(){
        return this.nome;
    }
    
    public int getCodigoConvite(){
        return this.codigoConvite;
    }
    
    @Override
    public String toString(){
        return "Convidado {" +
                "nome= " + nome + '\'' +
                ", codigoConvite= " + codigoConvite + 
                '}';
    }
    
    // Permite diferenciar os objetos do tipo Convidado (determina se são iguais ou não)
    // O que os torna iguais ou diferentes ? (atributos)
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Convidado convidado)) return false;
        return getCodigoConvite() == convidado.getCodigoConvite();
        
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(getCodigoConvite());
    }
    
}//class



public class ConjuntoConvidados{
    
    private Set<Convidado> convidadoSet;
    
    public ConjuntoConvidados(){
        this.convidadoSet = new HashSet<>();
    }
    
    public void adicionarConvidado(String nome, int codigoConvite){
        convidadoSet.add(new Convidado(nome, codigoConvite));
    }
    
    public void removerConvidadoPorCodigoConvite(int codigoConvite){
        //codigoConvite é único
        Convidado convidadoParaRemover = null;
        for(Convidado c : convidadoSet){
            if(c.getCodigoConvite() == codigoConvite){
                convidadoParaRemover = c;
                break; // paramos o loop, pois já encontramos o elemento é não existe duplicadas no Set.
            }
        }//for
        
        convidadoSet.remove(convidadoParaRemover);
        
    }//method
    
    public int contarConvidados(){
        return convidadoSet.size();
    }
    
    public void exibirConvidados(){
        System.out.println(convidadoSet);
    }
    
    
    public static void main(String[] args){
        ConjuntoConvidados conjuntoConvidados = new ConjuntoConvidados();
        
        System.out.println("Existem [ " + conjuntoConvidados.contarConvidados() + " ] Convidado(s) dentro do Set de Convidados");
        
        conjuntoConvidados.adicionarConvidado("Convidado 1", 1234);
        conjuntoConvidados.adicionarConvidado("Convidado 2", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado 3", 1235);
        conjuntoConvidados.adicionarConvidado("Convidado 4", 1236);

        conjuntoConvidados.exibirConvidados();
        
        System.out.println("Existem [ " + conjuntoConvidados.contarConvidados() + " ] Convidado(s) dentro do Set de Convidados");

        conjuntoConvidados.removerConvidadoPorCodigoConvite(1234);
        
        System.out.println("Existem [ " + conjuntoConvidados.contarConvidados() + " ] Convidado(s) dentro do Set de Convidados");
        
        conjuntoConvidados.exibirConvidados();

        
        
    }//main
    
    
}//class
