package Listas_JAVA

public class ListaCircular {
    private int tamanho;

    public ListaCircular() {
        this.cursor = null;
        this.tamanho = 0;
    }

    public void inserir(int elemento) {
        No novoNo = new No(elemento);
    }

    public boolean estarVazio() {
        return tamanho == 0;
    }
}