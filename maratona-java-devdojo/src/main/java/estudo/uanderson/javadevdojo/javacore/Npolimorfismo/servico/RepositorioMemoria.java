package estudo.uanderson.javadevdojo.javacore.Npolimorfismo.servico;

import estudo.uanderson.javadevdojo.javacore.Npolimorfismo.repositorio.Repositorio;

public class RepositorioMemoria implements Repositorio {

    @Override
    public void salvar() {
        System.out.println("salvando em Memória");
    }
}//interface
