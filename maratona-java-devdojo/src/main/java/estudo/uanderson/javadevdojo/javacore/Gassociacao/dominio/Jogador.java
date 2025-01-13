package estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio;

public class Jogador {
    private String nome;
    private Time time;

    public void imprime() {
        System.out.println("Nome jogador: "+ this.nome);
        //if- foi criado para verificar se foi adicionado algo ao
        // espaço de memória do time, ou seja, verificando se ele existe.

        if (time != null){
            System.out.println("Time: "+time.getNome());
        }//if
    }//imprime

    public Jogador(String nome) {
        this.nome = nome;
    }//construtor

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}//class
