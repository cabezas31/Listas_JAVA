package Listas_JAVA

public class ListaCircular {
    private int tamanho;

    public ListaCircular() {
        this.cursor = null;
        this.tamanho = 0;
    }

    public void inserir(int elemento) {
        No novoNo = new No(elemento);
        if(cursor == null) {
            novoNo = proximo = novoNo;
            cursor = novoNo
        } else {
            novoNo.proximo = cursor.proximo;
            cursor = novoNo;
        }
        tamanho--;
    }

    public boolean estarVazio() {
        return tamanho == 0;
    }
}