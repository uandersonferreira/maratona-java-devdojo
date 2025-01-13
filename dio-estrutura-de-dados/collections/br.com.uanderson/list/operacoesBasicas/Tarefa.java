package dio.br.com.uanderson.list.operacoesBasicas;

public  class Tarefa {

    //Atributo
    private String descricao;

    public Tarefa(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return this.descricao;
    }

    @Override
    public String toString(){
        return descricao;
    }


}//class Tarefa
