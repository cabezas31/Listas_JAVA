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
        if(tamanho == 0) {
            cabeca = cauda = novoNo;
        } else {
            novoNo.setProximo(cabeca);
            cabeca = novoNo;
        }
        tamanho++;
    }

    public void inserirNoFim(int elemento) {
        No novoNo = new No(elemento);
        if(tamanho == 0) {
            cabeca = cauda = novoNo;
        } else {
            cauda.setProximo(novoNo);
            cauda = novoNo;
        }
        tamanho++;
    }
}
