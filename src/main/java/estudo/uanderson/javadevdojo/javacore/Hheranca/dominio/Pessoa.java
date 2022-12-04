package estudo.uanderson.javadevdojo.javacore.Hheranca.dominio;

public class Pessoa {
    protected String nome;
    protected String cpf;
    protected Endereco endereco;
/*
O protected irá permitir que os atributos sejam vistos em todas as
sub-classes de Person e classes dentro do mesmo pacote. E nas classes
de outros pacotes que herdam a super classe.
 */
    static{
    System.out.println("Dentro do bloco statico de Person");
    }

    {
        System.out.println("Bloco de inicialização não estático de Person 1 ");
    }

    {
        System.out.println("Bloco de inicialização não estático de Person 2 ");
    }

 public Pessoa(String nome){
     System.out.println("Dentro do construtor de Person");
     this.nome = nome;
 }

 public Pessoa(){

 }

    public void imprime(){
        System.out.println(this.nome);
        System.out.println(this.cpf);
        System.out.println(this.endereco.getRua() +", "+this.endereco.getCep());
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}//class
