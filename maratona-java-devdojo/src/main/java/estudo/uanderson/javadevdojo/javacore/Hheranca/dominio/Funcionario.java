package estudo.uanderson.javadevdojo.javacore.Hheranca.dominio;

public class Funcionario extends Pessoa {
    private double salario;



    static{
        System.out.println("Dentro do bloco statico do Funcionário");
    }

    {
        System.out.println("Bloco de inicialização não estático de Funcionário 1 ");
    }

    {
        System.out.println("Bloco de inicialização não estático de Funcionário 2 ");
    }

    public Funcionario(String nome) {
        super(nome);
        System.out.println("Dentro do construtor do Funcionario");
    }

    @Override
    public void imprime() {
        super.imprime();
        /*
        Aqui estamos acessando diretamente o nome, como se tivesse sido declarado dentro do bloco da
        classe Funcionario. sem a necessidade de se está utilizando o método get, por causa do protected.

         */
        System.out.println("O funcionário: "+this.nome+" recebe -->"+this.salario);
    }




    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
