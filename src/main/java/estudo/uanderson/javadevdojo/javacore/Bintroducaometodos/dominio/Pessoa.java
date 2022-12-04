package estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.dominio;

public class Pessoa {
    private String nome;
    private int idade;

    public void imprime(){
        System.out.println(this.nome);
        System.out.println(this.idade);
    }//imprime

    public void setNome(String nome){// SET -- para adiconar um valor ao atributo.
        this.nome = nome; // this e usado quando existe variáveis com o mesmo nome, para não correr o risco de confundir quem e quem dentro do escopo do código
    }//setNome

    public void setIdade(int idade){
        if (idade < 0){
            System.out.println("Idade Inválida!!");
            return;
        }
        this.idade = idade;
    }//setIdade

    public String getNome() {// GET- Pega o valor armazenado na variável.
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}//classe

/*

 */

