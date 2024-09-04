import model.Arvore;
import util.ApresentaArvore;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore(20);
        arvore.inserir(14);
        arvore.inserir(10);

        System.out.println(arvore.getRaiz().getEsquerda());
        ApresentaArvore.execute(arvore);
    }
}