package estudo.uanderson.javadevdojo.javacore.Kenumeracao.dominio;

public class Cliente {
    private String nome;
    private TipoCliente tipoCliente;//relação é um/agregação
    private TipoPagamento tipoPagamento;//relação é um/agregação


    public Cliente(String nome, TipoCliente tipoCliente, 
    TipoPagamento tipoPagamento) {
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.tipoPagamento = tipoPagamento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", tipoCliente=" + tipoCliente.nomeRelatorio +
                ", tipoCliente=" + tipoCliente.VALOR +//tipoCliente.getValor() caso utilize -> private int valor;
                ", tipoPagamento=" + tipoPagamento +
                '}';
    }
}//class
/*
- NO JAVA É PERMITIDO CRIAR UMA CLASSE ENUM DENTRO DE OUTRA CLASSE.
-E MESMO CRIANDO DENTRO DE UM CLASSE, TEMOS QUE CRIAR UMA VÁRIAVEL
COM A REFERENCIA A CLASSE(RELAÇÃO).
 */