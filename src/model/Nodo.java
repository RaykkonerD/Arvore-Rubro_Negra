package model;

public class Nodo {
    private int valor;
    private boolean rubro; // FALSE = NEGRO; TRUE = RUBRO
    private Nodo filhoEsquerda;
    private Nodo filhoDireita;
    private Nodo pai;

    public Nodo getPai() {
        return pai;
    }

    public void setPai(Nodo pai) {
        this.pai = pai;
    }

    public Nodo getEsquerda() {
        return filhoEsquerda;
    }

    public void setEsquerda(Nodo filhoEsquerda) {
        this.filhoEsquerda = filhoEsquerda;
    }

    public Nodo getDireita() {
        return filhoDireita;
    }

    public void setDireita(Nodo filhoDireita) {
        this.filhoDireita = filhoDireita;
    }

    public Nodo(int valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isRubro() {
        return rubro;
    }

    public void setRubro(boolean rubro) {
        this.rubro = rubro;
    }
}
