package estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.dominio;

public class Funcionario {
   private  String nome;
   private int idade;
   private double[] salarios;
    private double media = 0;
   public void imprimeFuncionario(){
       System.out.println(nome);
       System.out.println(idade);
   if (salarios != null) {
       for (double salario : salarios) {
           System.out.print("Salarios: " + salario + "/");
       }
   }
   }//método
   
   public void mediaFuncionario(){

    if (salarios == null) {//se salarios for igual a nulo, não retorno nada.
        return;
    }//if

        for (double salario : salarios) {
            media += salario;
        }

       media /= salarios.length;
       System.out.println("\nMédia salarial: "+ media);
   }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double[] getSalarios() {
        return salarios;
    }

    public void setSalarios(double[] salarios) {
        this.salarios = salarios;
    }

    public double getMedia() {
        return media;
    }
}//class
