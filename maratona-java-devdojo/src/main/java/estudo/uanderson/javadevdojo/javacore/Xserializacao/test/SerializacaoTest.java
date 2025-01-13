package estudo.uanderson.javadevdojo.javacore.Xserializacao.test;

import estudo.uanderson.javadevdojo.javacore.Xserializacao.domain.Aluno;
import estudo.uanderson.javadevdojo.javacore.Xserializacao.domain.Turma;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SerializacaoTest {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(1L, "Uanderson","2112112");
        Turma turma = new Turma("Virada no Jiraya");
        aluno.setTurmaAluno(turma);

        serializar(aluno);
        deserializar();

    }


    private static void serializar(Aluno aluno){
        Path path = Paths.get("pasta/aluno.ser");

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path))) {
            objectOutputStream.writeObject(aluno);
        }catch (IOException e){
            e.printStackTrace();
        }
    }//method serializar

    private static void deserializar(){
        Path path = Paths.get("pasta/aluno.ser");

        try(ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path))) {
            Aluno readObjectAluno = (Aluno) objectInputStream.readObject();
            System.out.println(readObjectAluno);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }//method serializar

}//class
/*
Quando estamos serializamos algo, estamos a trabalhar
com um array de bytes e geralmente iremos trabalhar com
uma das class "Stream".

InputStream - Para leitura (Entrada de dados)
OutputStream - Para escrever (Saída de dados)

saída para consultar -> https://www.tutorialspoint.com/java/java_files_io.htm#

-> Ao se tentar serializar um objeto/class é necessário que o mesmo
passe no teste é um, sendo assim, é necessario que a class i
implemente a interface flag Serializable, senão irá gerar uma
Exception -> ( NotSerializableException).

flag, pois não possue metodos.

OBSERVAÇÃO: Quando se estar(deserializando) a ler um objeto serializado o java
não irá utilizar o construtor. Por isso, tomar cuidado, quando estamos trabalhando com
herança que necessita da chamada do super() no method construtor.

 */