import java.io.FileNotFoundException;

public class Perceptron {
    final static double taxaAprendizado = 0.1;
    final static int x0 = 1;
    static double[] pesos = {-0.5, 0.7, -0.2, 0.1, 0.9};
    static int saida;
    static double[] erro = new double[5];

    public static void treinar() throws FileNotFoundException { // COLOCAR UMA ENTRADA FIXA!!!!!!!! AAAAA -1,-1,1,1,-1
        ler();
        holdout();
        double somaPonderada = somaPonderada(Holdout.conjTreinamento.get(7));
        funcaoAtivacao(somaPonderada);
        calculaErro(Holdout.conjTreinamento.get(7));
        ajustaPesos();
    }

    public static void teste() {

    }

    public static void ler() throws FileNotFoundException {
        LerDados.lerDados("src/main/resources/dados.csv");
    }

    public static void holdout() { //Mudar para outros métodos de divisão
        Holdout.dividir();
    }

    public static double somaPonderada(Integer[] entrada) {//Entrada com 5 valores, o primeiro sendo o rotulo
        double somaponderada = 0;

        somaponderada += 1 * pesos[0];

        for (int i = 1; i < entrada.length; i++) {
            somaponderada += entrada[i] * pesos[i];
        }

        return somaponderada;
    }

    public static void funcaoAtivacao(double somaponderada) {
        if (somaponderada > 0) saida = 1;
        else saida = -1;
    }

    public static void calculaErro(Integer[] entrada) {
        for (int i = 0; i < entrada.length; i++) {
            erro[i] = taxaAprendizado * (entrada[0] - saida) * x0;
        }

    }

    public static void ajustaPesos() {
        for (int i = 0; i < pesos.length; i++) {
            pesos[i] += erro[i];
        }
    }
}
