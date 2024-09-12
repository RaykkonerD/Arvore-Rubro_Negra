import model.Arvore;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore(20);
        arvore.inserir(14);
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(22);
        arvore.inserir(7);
        // arvore.inserir(8);
        // arvore.inserir(9);

        ApresentaArvore.execute(arvore);
    }
}