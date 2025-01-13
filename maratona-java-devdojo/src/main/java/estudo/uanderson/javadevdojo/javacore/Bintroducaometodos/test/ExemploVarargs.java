package estudo.uanderson.javadevdojo.javacore.Bintroducaometodos.test;

public class ExemploVarargs {

    public static void main(String[] args) {
        somarNumeros(1, 2, 3);           // Passando vários argumentos
        somarNumeros();                  // Sem argumentos
        somarNumeros(10);                // Um único argumento

        imprimirMensagens("Olá", "Tudo bem?", "Bem-vindo ao Java!");
    }

    /*
     * Em vez de criar sobrecargas para diferentes números de parâmetros, você pode usar um único método.
     *
     * Exemplo antes do varargs:
     *
     * public void somarNumeros(int a) { }
     * public void somarNumeros(int a, int b) { }
     * public void somarNumeros(int a, int b, int c) { }
     *
     */

    // Método com varargs para somar números
    public static void somarNumeros(int... numeros) {
        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        System.out.println("Soma: " + soma);
    }

    // Método com varargs para imprimir mensagens
    public static void imprimirMensagens(String... mensagens) {
        for (String mensagem : mensagens) {
            System.out.println(mensagem);
        }
    }
}
