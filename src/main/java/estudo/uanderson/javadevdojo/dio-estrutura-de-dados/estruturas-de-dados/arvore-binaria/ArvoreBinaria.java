package dio.estruturas-de-dados.arvore-binaria;

public class ArvoreBinaria<T extends Comparable<T>> {

    private BinNo<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(T conteudo) {
        BinNo<T> novoNo = new BinNo<>(conteudo);
        raiz = inserir(raiz, novoNo);
    }

    private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo) {
        if (atual == null) { // Árvore vazia (1° elemento a ser inserido RAIZ) ou posição encontrada
            return novoNo; // Novo nó é inserido aqui (raiz ou folha)
        } else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) { // Conteúdo menor
            atual.setNoEsquerdo(inserir(atual.getNoEsquerdo(), novoNo));
        } else { // Conteúdo maior ou igual
            atual.setNoDireito(inserir(atual.getNoDireito(), novoNo)); 
        }
        return atual; // Retorna o nó atualizado
    }

    public void exibirInOrdem(){
        System.out.print("\n Exibindo InOrdem: ");
        exibirInOrdem(this.raiz);
    }

    public void exibirInOrdem(BinNo<T> atual){
        if (atual != null) {
            exibirInOrdem(atual.getNoEsquerdo());
            System.out.print(atual.getConteudo() + ", ");
            exibirInOrdem(atual.getNoDireito());
        }
      
    }//method


    public void exibirPosOrdem(){
        System.out.println("\n Exibindo PosOrdem: ");
        exibirPosOrdem(this.raiz);
    }

    public void exibirPosOrdem(BinNo<T> atual){
        if (atual != null) {
            exibirPosOrdem(atual.getNoEsquerdo());
            exibirPosOrdem(atual.getNoDireito());
            System.out.print(atual.getConteudo() + ", ");
        }
      
    }//method

    public void exibirPreOrdem(){
        System.out.print("\n Exibindo PreOrdem> ");
        exibirPreOrdem(this.raiz);
    }

    public void exibirPreOrdem(BinNo<T> atual){
        if (atual != null) {
            System.out.print(atual.getConteudo() + ", ");
            exibirPreOrdem(atual.getNoEsquerdo());
            exibirPreOrdem(atual.getNoDireito());
        }
      
    }//method

    public void remover(T conteudo){
        try{
            BinNo<T> atual = this.raiz;
            BinNo<T> pai = null;
            BinNo<T> filho = null;
            BinNo<T> temp = null;

            while (atual != null && !atual.getConteudo().equals(conteudo)){
                pai = atual;
                if(conteudo.compareTo(atual.getConteudo()) < 0){
                    atual = atual.getNoEsquerdo();
                }else {
                    atual = atual.getNoDireito();
                }
            }

            if(atual == null){
                System.out.println("Conteudo nao encontrado. Bloco Try");
            }

            if(pai == null){
                if(atual.getNoDireito() == null){
                    this.raiz = atual.getNoEsquerdo();
                }else if(atual.getNoEsquerdo() == null){
                    this.raiz = atual.getNoDireito();
                }else {
                    for(temp = atual, filho = atual.getNoEsquerdo();
                        filho.getNoDireito() != null;
                        temp = filho, filho = filho.getNoEsquerdo()
                    ){
                        if(filho != atual.getNoEsquerdo()){
                            temp.setNoDireito(filho.getNoEsquerdo());
                            filho.setNoEsquerdo(raiz.getNoEsquerdo());
                        }
                    }
                    filho.setNoDireito(raiz.getNoDireito());
                    raiz = filho;
                }
            }else if(atual.getNoDireito() == null){
                if(pai.getNoEsquerdo() == atual){
                    pai.setNoEsquerdo(atual.getNoEsquerdo());
                }else {
                    pai.setNoDireito(atual.getNoEsquerdo());
                }
            }else if(atual.getNoEsquerdo() == null){
                if(pai.getNoEsquerdo() == atual){
                    pai.setNoEsquerdo(atual.getNoDireito());
                }else {
                    pai.setNoDireito(atual.getNoDireito());
                }
            }else{
                for(
                        temp = atual, filho = atual.getNoEsquerdo();
                        filho.getNoDireito() != null;
                        temp = filho, filho = filho.getNoDireito()
                ){
                    if(filho != atual.getNoEsquerdo()){
                        temp.setNoDireito(filho.getNoEsquerdo());
                        filho.setNoEsquerdo(atual.getNoEsquerdo());
                    }
                    filho.setNoDireito(atual.getNoDireito());
                    if(pai.getNoEsquerdo() == atual){
                        pai.setNoEsquerdo(filho);
                    }else{
                        pai.setNoDireito(filho);
                    }
                }
            }
        }catch (NullPointerException erro){
            System.out.println("Conteudo nao encontrado. Bloco Catch");
        }
    }



}//clas


/*
 * RELEMBRANDO:
 * 
 * O modificador de acesso (public, private, protected) e o tipo de retorno não
 * influenciam na sobrecarga de methods.
 * 
 * A sobrecarga é determinada somente pela assinatura do método, que inclui:
 *   - O nome do método.
 *   - O número, tipo e ordem dos parâmetros.
 * No  caso:
 *  public void inserir(T conteudo) — visibilidade public e um parâmetro.
 *  private BinNo<T> inserir(BinNo<T> atual, BinNo<T> novoNo) — visibilidade private e dois parâmetros.
 * 
 */