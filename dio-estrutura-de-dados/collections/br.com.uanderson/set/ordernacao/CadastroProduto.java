package dio.br.com.uanderson.set.ordernacao;

import java.util.*;


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

