package estudo.uanderson.javadevdojo.javacore.Npolimorfismo.test;

import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.repositorio.Repositorio;
import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.servico.RepositorioBancoDeDados;

import java.util.ArrayList;
import java.util.List;

public class RepositorioTest01 {
    public static void main(String[] args) {
        Repositorio repositorio = new RepositorioBancoDeDados();
        repositorio.salvar();

        List<String> list = new ArrayList<>();
        list.add("Uanderson");
        list.add("Ferreira");
        list.add("Oliveira");
        System.out.println(list);


    }//main
}//class
