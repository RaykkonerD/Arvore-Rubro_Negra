import model.Arvore;

public class Main {
    public static void main(String[] args) {
        Arvore arvore = new Arvore(30);
        arvore.inserir(15);
        arvore.inserir(50);
        arvore.inserir(10);
        arvore.inserir(20);
        arvore.inserir(25);
        arvore.inserir(5);
        arvore.inserir(40);
        arvore.inserir(60);
        arvore.inserir(45);
        arvore.inserir(35);
        arvore.inserir(70);  
        arvore.inserir(8);  
        arvore.inserir(65);  
        arvore.inserir(27);  
        arvore.inserir(71);  
        arvore.inserir(72);  
        arvore.inserir(18);  

        ApresentaArvore.execute(arvore);
    }
}
