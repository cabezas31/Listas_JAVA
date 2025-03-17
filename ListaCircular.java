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

    public void remove() {
        if(estarVazio()) {
            throw new IllegalStateException("lista vazia")
        } if(cursor.proximo == cursor) {
                cursor = null;
        } else {
            cursor.proximo = cursor.proximo.proximo;
        }
        tamanho--;
    }

    public boolean estarVazio() {
        return tamanho == 0;
    }

    public int pegaElemento() {
        if(estarVazio()) {
            throw new IllegalStateException("lista vazia");
        }
        return cursor.proximo.elemento;
    }

    public void avanca() {
        if(estarVazio()!) {
            cursor = cursor.proximo;
        }
    }
    public int tamanho() {
        return tamanho;
    }
}