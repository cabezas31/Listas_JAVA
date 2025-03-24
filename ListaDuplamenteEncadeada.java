package Listas_JAVA;

public class ListaDuplamenteEncadeada {
    private No cabeca;
    private No cauda;
    private int tamanho;
    private No cursor;

    public ListaDuplamenteEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
        this.cursor = null;
    }

    public void inserirNoInicio(int elemento) {
        No novoNo = new No(elemento);
        if (estaVazio()) {
            cabeca = cauda = novoNo;
        } else {
            novoNo.proximo = cabeca;
            cabeca.anterior = novoNo;
            cabeca = novoNo;
        }
        tamanho++;
    }

    public void inserirNoFim(int elemento) {
        No novoNo = new No(elemento);
        if (estaVazio()) {
            cabeca = cauda = novoNo;
        } else {
            cauda.proximo = novoNo;
            novoNo.anterior = cauda;
            cauda = novoNo;
        }
        tamanho++;
    }

    public void inserir(int elemento, int posicao) {
        if (posicao < 0 || posicao > tamanho) throw new IndexOutOfBoundsException("Posição inválida!");
        if (posicao == 0) {
            inserirNoInicio(elemento);
            return;
        }
        if (posicao == tamanho) {
            inserirNoFim(elemento);
            return;
        }
        No novoNo = new No(elemento);
        No atual = cabeca;
        for (int i = 0; i < posicao - 1; i++) {
            atual = atual.proximo;
        }
        novoNo.proximo = atual.proximo;
        novoNo.anterior = atual;
        atual.proximo.anterior = novoNo;
        atual.proximo = novoNo;
        tamanho++;
    }

    public boolean estaVazio() {
        return tamanho == 0;
    }

    public int pegaElemento(int posicao) {
        if (posicao < 0 || posicao >= tamanho) throw new IndexOutOfBoundsException("Posição inválida!");
        No atual = cabeca;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        return atual.elemento;
    }

    public void alteraElemento(int elemento, int posicao) {
        if (posicao < 0 || posicao >= tamanho) throw new IndexOutOfBoundsException("Posição inválida!");
        No atual = cabeca;
        for (int i = 0; i < posicao; i++) {
            atual = atual.proximo;
        }
        atual.elemento = elemento;
    }

    public void remove(int posicao) {
        if (posicao < 0 || posicao >= tamanho) throw new IndexOutOfBoundsException("Posição inválida!");
        if (posicao == 0) {
            cabeca = cabeca.proximo;
            if (cabeca != null) cabeca.anterior = null;
        } else if (posicao == tamanho - 1) {
            cauda = cauda.anterior;
            cauda.proximo = null;
        } else {
            No atual = cabeca;
            for (int i = 0; i < posicao; i++) {
                atual = atual.proximo;
            }
            atual.anterior.proximo = atual.proximo;
            atual.proximo.anterior = atual.anterior;
        }
        tamanho--;
    }

    public int tamanho() {
        return tamanho;
    }

    public void inserirOrdenado(int elemento) {
        if (estaVazio() || elemento <= cabeca.elemento) {
            inserirNoInicio(elemento);
            return;
        }
        if (elemento >= cauda.elemento) {
            inserirNoFim(elemento);
            return;
        }
        No atual = cabeca;
        while (atual != null && atual.elemento < elemento) {
            atual = atual.proximo;
        }
        inserir(elemento, pegaPosicao(atual));
    }

    private int pegaPosicao(No no) {
        No atual = cabeca;
        int posicao = 0;
        while (atual != no) {
            atual = atual.proximo;
            posicao++;
        }
        return posicao;
    }

    public void ordenar() {
        if (tamanho < 2) return;
        for (No i = cabeca; i != null; i = i.proximo) {
            for (No j = i.proximo; j != null; j = j.proximo) {
                if (i.elemento > j.elemento) {
                    int temp = i.elemento;
                    i.elemento = j.elemento;
                    j.elemento = temp;
                }
            }
        }
    }

    public void imprimirLista() {
        No atual = cabeca;
        while (atual != null) {
            System.out.print(atual.elemento + " ");
            atual = atual.proximo;
        }
        System.out.println();
    }

    public int pegaPrimeiro() {
        cursor = cabeca;
        return (cabeca != null) ? cabeca.elemento : 0;
    }

    public int pegaProximo() {
        if (cursor == null || cursor.proximo == null) return 0;
        cursor = cursor.proximo;
        return cursor.elemento;
    }

    public int pegaUltimo() {
        cursor = cauda;
        return (cauda != null) ? cauda.elemento : 0;
    }

    public int pegaAnterior() {
        if (cursor == null || cursor.anterior == null) return 0;
        cursor = cursor.anterior;
        return cursor.elemento;
    }
}