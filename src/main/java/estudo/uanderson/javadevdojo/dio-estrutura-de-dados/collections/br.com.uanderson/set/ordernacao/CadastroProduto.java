package dio.br.com.uanderson.set.ordernacao;

import java.util.*;

class Produto implements Comparable<Produto>{
    
    private String nome;
    private long codigo;
    private double preco;
    private int quantidade;
    
    public Produto(long codigo, String nome, double preco, int quantidade){
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidade = quantidade;
    }
    
    public String getNome(){
        return nome;
    }
    
    public long getCodigo(){
        return codigo;
    }
    
    public double getPreco(){
        return preco;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    

    
    @Override
    public String toString(){
        return "{ " + nome + ", " + codigo + ", " + preco + ", " + quantidade + " }" ;
    }
    
    // Permite diferenciar os objetos do tipo Produto (determina se são iguais ou não)
    // O que os torna iguais ou diferentes ? (atributos)
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Produto produto)) return false;
        return getCodigo() == produto.getCodigo();
        
    }
    
    @Override
    public int hashCode(){
        return Objects.hash(getCodigo());
    }
    
    @Override
    public int compareTo(Produto p){
        return nome.compareToIgnoreCase(p.getNome());
    }
    
}//class


class ComparatorPorPreco implements Comparator<Produto> {
    
    @Override
    public int compare(Produto p1, Produto p2){
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}




public class CadastroProduto{
    
    private Set<Produto> produtoSet;
    
    public CadastroProduto (){
        this.produtoSet = new HashSet<>();
    }
    
    public void adicionarProdutos(long cod, String nome, double preco, int quantidade){
        produtoSet.add(new Produto(cod, nome, preco, quantidade ));
    }
    
    public Set<Produto> exibirProdutosPorNome(){
        Set<Produto> produtoPorNome = new TreeSet<>(produtoSet); //Permite ordenação
        //assim como o Collections.sort(); que trabalha com List<> paar permitir a ordenação.
        
        return produtoPorNome;
        
        /*
        
        new TreeSet<>(produtoSet); - Irá ordenar conforme o que foi definido no method 
        compareTo() na class Produto. 
        
        */
    }
    
    public Set<Produto> exibirProdutosPorPreco(){
        Set<Produto> produtosPorPreco = new TreeSet<>(new ComparatorPorPreco());
        produtosPorPreco.addAll(produtoSet);
        return produtosPorPreco;
    }
    
    

    public static void main(String[] args){
        CadastroProduto cadastroProdutos = new CadastroProduto();
        
        cadastroProdutos.adicionarProdutos(1L, "Produto 5", 15d, 5);
        cadastroProdutos.adicionarProdutos(2L, "Produto 0", 20d, 10);
        cadastroProdutos.adicionarProdutos(1L, "Produto 3", 10d, 2);
        cadastroProdutos.adicionarProdutos(4L, "Produto 9", 12d, 14);
        cadastroProdutos.adicionarProdutos(5L, "Produto 4", 2d, 3);

        
        System.out.println(cadastroProdutos.produtoSet);
        
        System.out.println(cadastroProdutos.exibirProdutosPorNome());
        
        System.out.println(cadastroProdutos.exibirProdutosPorPreco());

    }//main
    
    
}//class

