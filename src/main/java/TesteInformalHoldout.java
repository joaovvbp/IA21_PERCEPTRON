import java.io.FileNotFoundException;

public class TesteInformalHoldout {
    public static void main(String[] args) throws FileNotFoundException {
        Perceptron.ler();
        Holdout.dividir();
        Holdout.exibirTaxaDiv();

    }

}
