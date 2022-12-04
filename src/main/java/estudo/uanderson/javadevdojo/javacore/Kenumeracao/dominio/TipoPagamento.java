package estudo.uanderson.javadevdojo.javacore.Kenumeracao.dominio;

public enum TipoPagamento{
    DEBITO{
        @Override
        public double calcularDesconto(double valor) {
            return valor * 0.1;
        }
    },CREDITO{
        @Override
        public double calcularDesconto(double valor) {
            return valor * 0.05;
        }
    };

    public abstract double calcularDesconto(double valor);
    /*
           QUANDO QUEREMOS CRIAR UM MÉTODO, ONDE O SEU COMPORTAMENTO
           VAO SER DEFINIDO DENTRO DO BLOCO DE EXECUÇÃO DA OPÇAO ESCOLHIDA, QUE IRÁ
           SOBREESCREVER O MÉTODO. DEVEMOS CRIAR UM METODO ASBTRATO(abstract)

     */

}//class