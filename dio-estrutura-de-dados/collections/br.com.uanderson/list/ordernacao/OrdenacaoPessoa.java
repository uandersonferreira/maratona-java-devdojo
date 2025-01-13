package dio.br.com.uanderson.list.ordernacao;

import java.util.*;

public class OrdenacaoPessoa {
    
    private List<Pessoa> pessoaList;
    
    public OrdenacaoPessoa(){
        this.pessoaList = new ArrayList<>();
    }
    
    public List<Pessoa> getPessoaList(){
        return pessoaList;
    }
    
    public void adicionarPessoa(String nome, int idade, double altura){
        pessoaList.add(new Pessoa(nome, idade, altura));
    }
    
   
   public List<Pessoa> ordenarPorIdade(){
       List<Pessoa> pessoasPorIdade = new ArrayList<>(pessoaList);//deplicando a lista, sem ordenação
       Collections.sort(pessoasPorIdade);//Orderna levando em conta o compareTo do Comparable
       return pessoasPorIdade;
   }
   
   
   public List<Pessoa> ordenarPorAltura(){
       List<Pessoa> pessoasPorAltura = new ArrayList<>(pessoaList);//deplicando a lista, sem ordenação
       Collections.sort(pessoasPorAltura, new ComparatorPorAltura());//Orderna levando em conta o compare da class ComparatorPorAltura que implementa Comparator 
       return pessoasPorAltura;
   }
   
   public static void main(String[] args){
       OrdenacaoPessoa ordenacaoPessoa = new OrdenacaoPessoa();
       
       ordenacaoPessoa.adicionarPessoa("Nome 1", 20, 1.56);
       ordenacaoPessoa.adicionarPessoa("Nome 2", 30, 1.80);
       ordenacaoPessoa.adicionarPessoa("Nome 3", 25, 1.70);
       ordenacaoPessoa.adicionarPessoa("Nome 4", 17, 1.56);

       System.out.println("====== Sem ordenação ===== \n");
       
       System.out.println(ordenacaoPessoa.pessoaList);

       System.out.println("\n ====== Com ordenação Por Idade ===== \n");

       System.out.println(ordenacaoPessoa.ordenarPorIdade());
       
       System.out.println("\n ====== Com ordenação Por Altura ===== \n");

       System.out.println(ordenacaoPessoa.ordenarPorAltura());

   }
   
   
    
}//class



