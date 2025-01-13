package estudo.uanderson.javadevdojo.javacore.Xserializacao.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Aluno implements Serializable {

    private static final long serialVersionUID = 3989564031256329351L;
    private Long id;
    private String nome;
    private transient String password;
    private transient Turma turmaAluno;//associação


    private static final String NOME_ESCOLA = "DevDojo Academy";

    public Aluno(Long id, String nome, String password) {
        System.out.println("Dentro do Construtor");
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    private void writeObject(ObjectOutputStream objectOutputStream){
        try{
            objectOutputStream.defaultWriteObject();//1° salve da forma padrão o Objeto
            objectOutputStream.writeUTF(turmaAluno.getNome());//ao invés de serializar o objeto iremos serializar os atributos.

        }catch (IOException e){
            e.printStackTrace();
        }
    }//writeObject

    private void redObject(ObjectInputStream objectInputStream){
        try{
            objectInputStream.defaultReadObject();
            String nomeTurma = objectInputStream.readUTF();
            this.setTurmaAluno(new Turma(nomeTurma));

        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", NOME_ESCOLA='" + NOME_ESCOLA + '\'' +
                ", turma='" + turmaAluno + '\'' +
                '}';
    }

    public Turma getTurmaAluno() {
        return turmaAluno;
    }

    public void setTurmaAluno(Turma turmaAluno) {
        this.turmaAluno = turmaAluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
/*
    private transient String password;

  1-  transiet significa dizer que esse campo irá ser completamente
    ignorado durante a serialização.

    E ao ser usar pode gerar algo como class imcopatible serialVersionID. Pois o java pode não entender como deserializar um objeto.
    portando, é necessário ativar/gerar um novo serialVersionID qu eé gerado atomaticamente pela IDE.

2- private static final String NOME_ESCOLA = "DevDojo Academy";

 variaveis statics não são serializadas por pertencerem
 a class é não ao objeto.

    Quando se têm uma associação é quando muitas das vezes não temos acesso ao condigo
    fonte, pois pode ocorrer de pegamos de terceiros e/ou API, teremos quer dar as instruções
     por java para poder serializar ou deserializar um objeto que teoricamente não pode ser serializado.

     E para isso o 1° passo é definir a/as variavel(is) com "transient" para que seja
     ingnorada durante o processo.
     2°- E necessário praticamente escrever todos os atributos do objeto
     nos metodos writeObject e readObject. E ná hora da leitura, têm que ser
     na mesma ordem que foi/foram escritos.






 */