package estudo.uanderson.javadevdojo.javacore.Zgenerics.Service;
import java.util.List;

public class RentalService<T> {
    private List<T> objetosDisponiveis;

    public RentalService(List<T> objetosDisponiveis) {
        this.objetosDisponiveis = objetosDisponiveis;
    }

    public T buscarObjetoDisponivel(){
        System.out.println("Buscando objeto disponível....");
        T t = objetosDisponiveis.remove(0);
        System.out.println("Alugando objeto: "+ t);
        System.out.println("Objetos disponíveis para Alugar: ");
        System.out.println(objetosDisponiveis);
        return t;
    }

    public void retornarObjetoAlugado(T t){
        System.out.println("Devolvendo objeto: "+t);
        objetosDisponiveis.add(t);
        System.out.println("Objetos disponiveis para alugar: ");
        System.out.println(objetosDisponiveis);
    }
}
/*
T -> Representa o tipo, de um object que será passado,
como não sabemos o tipo exato usa-se generics para deixar
isso explicito. Pois, quando informar o tipo do objeto o "T", "t"
será substituido pelo objeto passado.

-Pode ser passado mais de 1 atributo para os sinais de maior ou menor
Ex:
 RentalService<T, X, V, U>



 */