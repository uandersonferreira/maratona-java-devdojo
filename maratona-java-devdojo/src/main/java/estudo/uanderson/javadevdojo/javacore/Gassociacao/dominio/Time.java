package estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio;

public class Time {
    private  String nome;
    private Jogador[] jogadores;

    public Time(String nome){
        this.nome = nome;
    }//construtor


    public Time(String nome, Jogador[] jagadores) {
        this.nome = nome;
        this.jogadores = jagadores;
    }//2° construtor


    public void imprime(){
        System.out.println("Time: "+this.nome);

        if (jogadores == null) return;

        for (Jogador jogador: jogadores) {
            System.out.println("Nome Jogador: "+jogador.getNome());
        }

    }//imprime

    public Jogador[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(Jogador[] jogadores) {
        this.jogadores = jogadores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
