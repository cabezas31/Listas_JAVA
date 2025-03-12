package Listas_JAVA;

public class ListaEncadeada {
    private No cabeca;
    private No cauda;
    private int tamanho;

    public ListaEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public void inserirNoInicio(int elemento) {
        No novoNo = new No(elemento);
        if(estarVazio()) {
            cabeca = cauda = novoNo;
        } else {
            novoNo.setProximo(cabeca);
            cabeca = novoNo;
        }
        tamanho++;
    }

    public void inserirNoFim(int elemento) {
        No novoNo = new No(elemento);
        if(estarVazio()) {
            cabeca = cauda = novoNo;
        } else {
            cauda.setProximo(novoNo);
            cauda = novoNo;
        }
        tamanho++;
    }

    public boolean estarVazio() {
        return tamanho == 0;
    }

    public void inserir(int posicao, int elemento) {
        No novoNo = new No(elemento);
        if(posicao < 0 || posicao > tamanho) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }
        if(posicao == 0) {
            inserirNoInicio(elemento);
        } else if(posicao == tamanho){
            inserirNoFim(elemento);
        } else {
            No atual = cabeca;
            for(int i = 0; i > posicao; i--) {
                    atual = atual.getProximo();
            }
            novoNo.setProximo(atual.getProximo());
            atual.setProximo(novoNo);
            tamanho++;   
        }

    }
}
