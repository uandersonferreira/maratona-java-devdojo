package dio.br.com.uanderson.map.pesquisa;

import java.util.*;


public class EstoqueProdutos {

    private Map<Long, Produto> estoqueProdutosMap;

    public EstoqueProdutos() {
        this.estoqueProdutosMap = new HashMap<>();
    }

    public void adicionarProduto(long cod, String nome, int quantidade, double preco){
        estoqueProdutosMap.put(cod, new Produto(nome, preco, quantidade));
    }

    public void exibirProdutos(){
        System.out.println(estoqueProdutosMap);
    }

    public double calculaValorTotalEstoque(){
        double valorTotalEstoque = 0;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
                valorTotalEstoque += p.getQuantidade() * p.getPreco(); 
            }
        }

        return valorTotalEstoque;
    }

    public Produto obterProdutoMaisCaro(){
        Produto produtoMaisCaro = null;
        double maiorPreco = 0;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
               if (p.getPreco() > maiorPreco) {
                    produtoMaisCaro = p;
                    maiorPreco = p.getPreco(); // Corrigido
               } 
            }
        }

        return produtoMaisCaro;
    }

    public Produto obterProdutoMaisBarato(){
        Produto produtoMaisBarato = null;
        double menorPreco = Double.MAX_VALUE;
        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
               if (p.getPreco() < menorPreco) {
                  produtoMaisBarato = p;
                  menorPreco = p.getPreco(); // Corrigido
               } 
            }
        }

        return produtoMaisBarato;
    }


    public Produto obterProdutoMaiorQuantidadeValorTotalNoEstoque(){
        Produto produtoMaiorQuantidadeEstoque = null;
        double maiorValorTotal = 0;

        if (!estoqueProdutosMap.isEmpty()) {
            for (Produto p : estoqueProdutosMap.values()) {
              double valorTotalAtual = (p.getPreco() * p.getQuantidade()); 
              if (valorTotalAtual > maiorValorTotal) { 
                    maiorValorTotal = valorTotalAtual;
                    produtoMaiorQuantidadeEstoque = p;
              }
            }
        }

        return produtoMaiorQuantidadeEstoque;
    }

    public static void main(String[] args) {
        EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

        estoqueProdutos.exibirProdutos();

        estoqueProdutos.adicionarProduto(1, "Produto 1", 10, 8); // 80
        estoqueProdutos.adicionarProduto(2, "Produto 2", 11, 2); // 22
        estoqueProdutos.adicionarProduto(3, "Produto 3", 2, 10); // 20
        estoqueProdutos.adicionarProduto(4, "Produto 4", 1, 25); // 25

        estoqueProdutos.exibirProdutos();

        System.out.println("Total estoque: " + estoqueProdutos.calculaValorTotalEstoque());
        System.out.println("Produto mais caro: " + estoqueProdutos.obterProdutoMaisCaro());
        System.out.println("Produto mais barato: " + estoqueProdutos.obterProdutoMaisBarato());
        System.out.println("Produto com maior valor total em estoque: " + estoqueProdutos.obterProdutoMaiorQuantidadeValorTotalNoEstoque());
    }

}//class




