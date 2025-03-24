package Listas_JAVA;

public class No {
    private int elemento;
    private No proximo;
    private No anterior;

    public No(int elemento) {
        this.elemento = elemento;
        this.proximo = null;
        this.anterior = null;
    }

    public int getElemento() {
        return elemento;
    }
    public void setElemento(int elemento) {
        this.elemento = elemento;
    }
    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
    public No getProximo() {
        return proximo;
    }
    public void setAnterior(No anterior) {
        this.anterior = anterior;
    }
    public No getAnterior() {
        return anterior;
    }
}