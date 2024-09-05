package model;

public class Arvore {
    private Nodo raiz;

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public Arvore(int raiz){
        this.raiz = new Nodo(raiz);
    }

    public void inserir(int valor){
        if (this.raiz == null) {
            this.raiz = new Nodo(valor);
        } else if (!buscar(valor)) {
            inserir(this.raiz, valor);
        }
    }

    public void inserir(Nodo nodo, int valor){
        if(valor < nodo.getValor()){
            if(nodo.getEsquerda() == null){
                Nodo novoNodo = new Nodo(valor);
                novoNodo.setRubro(true);
                novoNodo.setPai(nodo);
                nodo.setEsquerda(novoNodo);
                if(nodo.isRubro()){
                    ajustarAEsquerda(nodo, valor);
                }
            } else {
                inserir(nodo.getEsquerda(), valor);
            }
        } else {
            if(nodo.getDireita() == null){
                Nodo novoNodo = new Nodo(valor);
                novoNodo.setRubro(true);
                novoNodo.setPai(nodo);
                nodo.setDireita(novoNodo);
                if(nodo.isRubro()) {
                    ajustarADireita(nodo, valor);
                }
            } else {
                inserir(nodo.getDireita(), valor);
            }
        }
    }

    public void ajustarAEsquerda(Nodo nodo, int valor){
        Nodo tio = (nodo == nodo.getPai().getEsquerda()) ? nodo.getPai().getDireita() : nodo.getPai().getEsquerda();
        if(tio != null) {
            if (tio.isRubro()) {
                recolorir(nodo);
            }
        }

        if(nodo == nodo.getPai().getEsquerda()){
            // Rotação R-L
        } else {
            // Rotação L
        }
    }

    public void ajustarADireita(Nodo nodo, int valor){
        Nodo tio = (nodo == nodo.getPai().getEsquerda()) ? nodo.getPai().getDireita() : nodo.getPai().getEsquerda();
        if(tio != null) {
            if (tio.isRubro()) {
                recolorir(nodo);
            }
        }

        if(nodo == nodo.getPai().getEsquerda()){
            // Rotação L-R
        } else {
            // Rotação R
        }
    }

    public void recolorir(Nodo nodo){
        if(nodo == this.raiz){
            this.raiz.setRubro(false);
            return;
        }

        nodo.setRubro(!nodo.isRubro());
        recolorir(nodo.getPai());
    }

    public boolean buscar(int valor) {
        return buscar(this.raiz, valor);
    }

    protected boolean buscar(Nodo pai, int valor) {
        if (pai == null) {
            return false;
        } else if (valor < pai.getValor()) {
            return buscar(pai.getEsquerda(), valor);
        } else if (valor > pai.getValor()) {
            return buscar(pai.getDireita(), valor);
        }

        return true;
    }

    public void imprimir() {
        imprimirRecursivo(this.getRaiz(), "", true);
    }

    protected void imprimirRecursivo(Nodo nodo, String prefixo, boolean ehUltimo) {
        if (nodo != null) {
            System.out.print(prefixo);
            System.out.print(ehUltimo ? "└── " : "├── ");
            System.out.println(nodo.getValor());
            imprimirRecursivo(nodo.getDireita(), prefixo + (ehUltimo ? "    " : "│   "), false);
            imprimirRecursivo(nodo.getEsquerda(), prefixo + (ehUltimo ? "    " : "│   "), true);
        }
    }
}
