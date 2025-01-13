package dio.br.com.uanderson.list.pesquisa;


import java.util.*;


public class CatalogoLivro{
    
    private List<Livro> livroList;
    
    public CatalogoLivro(){
        this.livroList = new ArrayList<>();
    }
    
    
    public void adicionarLivro(String titulo, String autor, int anoPublicacao){
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }
    
    public List<Livro> pesquisarPorAutor(String autor){
        
        List<Livro> livrosPorAutor = new ArrayList<>();
        
        if(!livroList.isEmpty()){
            for(Livro l : livroList){
                if(l.getAutor().equalsIgnoreCase(autor)){
                   livrosPorAutor.add(l);   
                }
            }//for
        }//if
        
        return livrosPorAutor;
        
    }//method
    
    
    
    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal){
       
       List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        
        if(!livroList.isEmpty()){
            for(Livro l : livroList){
                if(l.getAnoPublicacao() >= anoInicial & l.getAnoPublicacao() <= anoFinal){
                  livrosPorIntervaloAnos.add(l); 
                }
            }//for
        }//if
        
        return livrosPorIntervaloAnos;
    }
    
    public Livro pesquisarPorTitulo(String titulo){
        Livro livroPorTitulo = null;
        
        if(!livroList.isEmpty()){
            for (Livro l : livroList){
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    livroPorTitulo = l;
                    break; //para o laço pois só preciso do primeiro
                }
            }
        }//if
        
        return livroPorTitulo;
        
    }//method
    
    
    public static void main(String[] args){
        CatalogoLivro catalogoLivros = new CatalogoLivro();
        
       catalogoLivros.adicionarLivro("Livro 1", "Autor 1", 2020);
       catalogoLivros.adicionarLivro("Livro 1", "Autor 2", 2021);
       catalogoLivros.adicionarLivro("Livro 2", "Autor 2", 2022);
       catalogoLivros.adicionarLivro("Livro 3", "Autor 3", 2023);
       catalogoLivros.adicionarLivro("Livro 4", "Autor 4", 1994);
       catalogoLivros.adicionarLivro("Livro 5", "Autor 5", 2024);
       catalogoLivros.adicionarLivro("Livro 6", "Autor 6", 2008);

        System.out.println("=================== pesquisarPorAutor ==================");
        System.out.println(catalogoLivros.pesquisarPorAutor("Autor 2"));
        
        System.out.println("=================== pesquisarPorIntervaloAnos ==================");
        System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2010, 2022));

        System.out.println("=================== pesquisarPorTitulo ==================");
        System.out.println(catalogoLivros.pesquisarPorTitulo("Livro 1"));


    }
    
}//class CatalogoLivro
    






