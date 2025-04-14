public class Fila_Simples implements IEstruturaSimples {
    private int quantidade;
    private int tamanho;
    private Object[] fila;

    public Fila_Simples(int tamanho) {
        this.tamanho = tamanho;
        this.fila = new Object[tamanho];
        this.quantidade = 0;
    }

    @Override
    public void inserirElemento(Object elemento) {
        if (estaCheia()) {
            System.out.println("A fila está cheia, impossível adicionar novos elementos");
        } else {
            fila[quantidade++] = elemento;
        }
    }

    @Override
    public void inserirElementoIndice(Object elemento, int indice) {
        if (estaCheia() || indice < 0 || indice > tamanho) {
            System.out.println("Índice inválido ou fila cheia.");
            return;
        }
        for (int i = quantidade; i > indice; i--) {
            fila[i] = fila[i - 1];
        }
        fila[indice] = elemento;
        quantidade++;
    }

    @Override
    public void inserirSequencia(Object elementos) {
        if (elementos instanceof Object[]) {
            Object[] sequencia = (Object[]) elementos;
            for (Object elem : sequencia) {
                inserirElemento(elem);
            }
        } else {
            System.out.println("Sequência inválida, informe uma sequência valida.");
        }
    }

    @Override
    public boolean removerElemento() {
        if (estaVazia()) return false;
        for (int i = 0; i < quantidade - 1; i++) {
            fila[i] = fila[i + 1];
        }
        fila[--quantidade] = null;
        return true;
    }

    @Override
    public Object removerIndice(int indice) {
        if (indice < 0 || indice >= quantidade) return null;
        Object removido = fila[indice];
        for (int i = indice; i < quantidade - 1; i++) {
            fila[i] = fila[i + 1];
        }
        fila[--quantidade] = null;
        return removido;
    }

    @Override
    public void removerSequencia(Object elementos) {
        if (elementos instanceof Object[]) {
            Object[] sequencia = (Object[]) elementos;
            for (Object elem : sequencia) {
                removerTodasOcorrencias(elem);
            }
        } else {
            System.out.println("Sequência inválida.");
        }
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {
        int i = 0;
        while (i < quantidade) {
            if (fila[i].equals(elemento)) {
                removerIndice(i);
            } else {
                i++;
            }
        }
    }

    @Override
    public boolean estaCheia() {
        return quantidade == tamanho;
    }

    @Override
    public boolean estaVazia() {
        return quantidade == 0;
    }

    @Override
    public boolean buscarElemento(Object elemento) {
        for (int i = 0; i < quantidade; i++) {
            if (fila[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object buscarElementoIndice(int indice) {
        if (indice > 0 && indice < quantidade) {
            return fila[indice];
        }
        return null;
    }

    @Override
    public void ordenarCrescente() {
        for (int i = 0; i < quantidade - 1; i++) {
            for (int j = 0; j < quantidade - 1 - i; j++) {
                Comparable a = (Comparable) fila[j];
                Comparable b = (Comparable) fila[j + 1];
                if (a.compareTo(b) > 0) {
                    Object temp = fila[j];
                    fila[j] = fila[j + 1];
                    fila[j + 1] = temp;

                }
            }
        }

    }

    @Override
    public void ordenarDecrescente() {
        for (int i = 0; i < quantidade - 1; i++) {
            for (int j = 0; j < quantidade - 1 - i; j++) {
                Comparable a = (Comparable) fila[j];
                Comparable b = (Comparable) fila[j + 1];
                if (a.compareTo(b) < 0) {
                    Object temp = fila[j];
                    fila[j] = fila[j + 1];
                    fila[j + 1] = temp;
                }
            }
        }

    }

    @Override
    public int quantidadeElementos() {
        return quantidade;
    }

    @Override
    public void dobrarCapacidade() {
        Object[] novaFila = new Object[fila.length * 2];
        for (int i = 0; i < quantidade; i++) {
            novaFila[i] = fila[i];
        }
        fila = novaFila;
        tamanho = fila.length;
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {
        for (int i = 0; i < quantidade; i++) {
            if (fila[i].equals(elementoAntigo)) {
                fila[i] = elementoNovo;
            }
        }
    }

    @Override
    public void limpar() {
        for (int i = 0; i < quantidade; i++) {
            fila[i] = null;
        }
        quantidade = 0;
    }

    @Override
    public void exibir() {
        System.out.print("Fila: [ ");
        for (int i = 0; i < quantidade; i++) {
            System.out.print(fila[i] + " ");
        }
        System.out.println("]");
    }

    @Override
    public Object obterPrimeiroElemento() {
        if (estaVazia()) {
            System.out.println("A fila está vazia.");
            return null;
        }
        return fila[0];
    }

    @Override
    public Object obterUltimoElemento() {
        if (estaVazia()) {
            System.out.println("A fila está vazia.");
            return null;
        }
        return fila[quantidade - 1];
    }
}
