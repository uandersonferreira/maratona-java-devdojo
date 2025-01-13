package estudo.uanderson.javadevdojo.javacore.Aintroducaoclasses.test;


import estudo.uanderson.javadevdojo.javacore.Aintroducaoclasses.dominio.Estudante;

public class EstudanteTest {

    public static void main(String[] args) {
        Estudante estudante = new Estudante();
        Estudante estudante2 = new Estudante();

        //estudante.nome = "Luffy";
        //estudante.idade = 18;
        //estudante.sexo = 'M';

        System.out.println(estudante.nome);
        System.out.println(estudante.idade);
        System.out.println(estudante.sexo);

        System.out.println("==========");

        System.out.println(estudante2.nome);
        System.out.println(estudante2.idade);
        System.out.println(estudante2.sexo);


    }//main
}//class
