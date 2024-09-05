import model.Arvore;
import ApresentaArvore;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore(20);
        arvore.inserir(14);
        arvore.inserir(10);

        ApresentaArvore.execute(arvore);
    }
}