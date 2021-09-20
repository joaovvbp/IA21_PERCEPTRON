import java.io.FileNotFoundException;

public class TesteInformalHoldout {
    public static void main(String[] args) throws FileNotFoundException {
        Perceptron.treinar();
        System.out.println(Perceptron.pesos[0]);
        System.out.println(Perceptron.pesos[1]);
        System.out.println(Perceptron.pesos[2]);
        System.out.println(Perceptron.pesos[3]);
        System.out.println(Perceptron.pesos[4]);
    }
}
