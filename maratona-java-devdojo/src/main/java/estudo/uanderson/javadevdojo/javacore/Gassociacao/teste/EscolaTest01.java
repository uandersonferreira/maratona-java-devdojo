package estudo.uanderson.javadevdojo.javacore.Gassociacao.teste;

import estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Escola;
import estudo.uanderson.javadevdojo.javacore.Gassociacao.dominio.Execicio.Professor;

public class EscolaTest01 {
    public static void main(String[] args) {
        Professor professor1 = new Professor("Jiraya");
        Professor professor2 = new Professor("Konohamaro");
        Professor[] professores = {professor1,professor2}; //new Professor[]{professor1,professor2, ...};

        Escola escola = new Escola("Konoha",professores);
        Escola escola2 = new Escola("Lunar",professores);

        escola.imprime();
        escola2.imprime();

    }//main
}//class
