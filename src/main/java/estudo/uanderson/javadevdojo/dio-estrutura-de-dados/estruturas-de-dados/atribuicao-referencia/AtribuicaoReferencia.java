package dio.estruturas-de-dados.atribuicao-referencia;

public class AtribuicaoReferencia {
    public static void main(String[] args) {
        
        // Declaração de uma variável do tipo primitivo int e atribuição do valor 1
        int intA = 1;
        // Atribuição do valor da variável intA para a variável intB (cópia do valor)
        int intB = intA;
        
        // Impressão do valor das variáveis intA e intB, ambos serão 1 neste ponto
        System.out.println("intA = " + intA + "  intB = " + intB);
        
        // Mudança do valor de intA para 2 (intA e intB são independentes, pois são tipos primitivos)
        intA = 2;
        
        // Impressão dos valores de intA (agora 2) e intB (permanece 1, pois foi uma cópia)
        System.out.println("intA = " + intA + "  intB = " + intB);

        System.out.println("\n========= OBJETOS =========\n");
        
        // Criação de um novo objeto MeuObjeto com valor 1
        MeuObjeto objA = new MeuObjeto(1);
        // Atribuição da referência de objA para objB (ambos apontam para o mesmo objeto)
        MeuObjeto objB = objA; 
        
        // Impressão do valor de objA e objB, ambos referenciam o mesmo objeto e serão 1
        System.out.println("objA = " + objA + "  objB = " + objB);
       
        // Modificação do valor do campo num do objeto referenciado por objA (como objA e objB referenciam o mesmo objeto, ambos serão afetados)
        objA.setNum(2);
       
        // Impressão dos valores de objA e objB, ambos agora serão 2, pois o objeto foi modificado
        System.out.println("objA = " + objA + "  objB = " + objB);
    }
}

class MeuObjeto{
    
    Integer num;
    
    public MeuObjeto(Integer num){
        this.num = num;
    }
    
    public void setNum(Integer num){
        this.num = num;
    }
    
    @Override
    public String toString(){
        return " " + this.num;
    }
}
