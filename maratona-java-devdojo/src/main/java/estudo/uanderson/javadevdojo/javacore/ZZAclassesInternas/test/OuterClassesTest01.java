package estudo.uanderson.javadevdojo.javacore.ZZAclassesInternas.test;

public class OuterClassesTest01 {
    private String name = "Monkey D. luffy";
 //Nested - Aninhada == Inner- Internas
    class Inner{
        public void printOuterClassAttribute(){
            System.out.println(name);
            System.out.println("Interno: "+this);//está se referindo ao objeto referente ao contexto em que ele se econtra(bloco - {} ), classe Interna
            System.out.println("Externo: "+OuterClassesTest01.this+"\n");//está se referindo a classe Externa
        }
    }//OuterClassesTest01

    public static void main(String[] args) {
        OuterClassesTest01 outerClass = new OuterClassesTest01();//criar um objeto da classe Externa
        Inner inner = outerClass.new Inner();//EX 2:
        OuterClassesTest01.Inner inner2 = outerClass.new Inner();//EX 2://Outra sintaxe valida para criar um obj da classe interna sem Precisar criar o obj da classe Externa.
        Inner inner3 = new OuterClassesTest01().new Inner();

        inner.printOuterClassAttribute();
        inner2.printOuterClassAttribute();
        inner3.printOuterClassAttribute();
    }
}
/*
Classes internas ->
 - são como atributos
 - São classe dentro de outras classes. Que estão fortemente
 acopladas(ligadas-conectadas)
 - Têm acesso a todos os metodos/atributos da classe Externa


 EX 2: Do obj da classe de fora(Externa) -> criar -> um novo obj da classe de dentro(Interna)
  ->   outerClass.new Inner();

 */