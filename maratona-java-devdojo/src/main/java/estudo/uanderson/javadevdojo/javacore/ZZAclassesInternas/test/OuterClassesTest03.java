package estudo.uanderson.javadevdojo.javacore.ZZAclassesInternas.test;

public class OuterClassesTest03 {
    private String name = "Uanderson";
    static class Nested{
        private String lastName= "Oliveira";
        void print(){
            System.out.println(new OuterClassesTest03().name+" "+lastName);
        }
    }

    public static void main(String[] args) {
        Nested nested = new Nested();
        nested.print();
    }
}
