import model.Arvore;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore(20);
        arvore.inserir(14);
        arvore.inserir(10);
        arvore.inserir(22);

        ApresentaArvore.execute(arvore);
    }
}