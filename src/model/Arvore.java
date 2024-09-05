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
            rotacaoADireita(nodo.getPai());
        } else {
            // Rotação R-L
        }
    }

    public void ajustarADireita(Nodo nodo, int valor){
        Nodo tio = (nodo == nodo.getPai().getEsquerda()) ? nodo.getPai().getDireita() : nodo.getPai().getEsquerda();
        if(tio != null) {
            if (tio.isRubro()) {
                recolorir(nodo);
            }
        }

        if(nodo == nodo.getPai().getDireita()){
            rotacaoAEsquerda(nodo.getPai());
        } else {
            // Rotação L-R
        }
    }

    private void rotacaoADireita(Nodo nodo) {
        if (this.raiz == nodo) {
            this.raiz = nodo.getEsquerda();
            this.raiz.setPai(null);
            Nodo aDireita = this.raiz.getDireita();

            if (aDireita != null) {
                aDireita.setPai(nodo);
            }

            nodo.setEsquerda(aDireita);
            nodo.setPai(this.raiz);
            this.raiz.setDireita(nodo);
        } else {
            nodo.getEsquerda().setPai(nodo.getPai());
            if (nodo.getPai().getEsquerda() == nodo) {
                nodo.getPai().setEsquerda(nodo.getEsquerda());
            } else {
                nodo.getPai().setDireita(nodo.getEsquerda());
            }
            nodo.setPai(nodo.getEsquerda());
            nodo.setEsquerda(nodo.getEsquerda().getDireita());
            nodo.getPai().setDireita(nodo);
        }
    }

    private void rotacaoAEsquerda(Nodo nodo) {
        if (this.raiz == nodo) {
            this.raiz = nodo.getDireita();
            this.raiz.setPai(null);
            Nodo aEsquerda = this.raiz.getEsquerda();

            if (aEsquerda != null) {
                aEsquerda.setPai(nodo);
            }

            nodo.setDireita(aEsquerda);
            nodo.setPai(this.raiz);
            this.raiz.setEsquerda(nodo);
        } else {
            nodo.getDireita().setPai(nodo.getPai());
            if (nodo.getPai().getDireita() == nodo) {
                nodo.getPai().setDireita(nodo.getDireita());
            } else {
                nodo.getPai().setEsquerda(nodo.getDireita());
            }
            nodo.setPai(nodo.getDireita());
            nodo.setDireita(nodo.getDireita().getEsquerda());
            nodo.getPai().setEsquerda(nodo);
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
