import java.io.FileNotFoundException;

public class Perceptron {
    final double taxaAprendizado = 0.1;
    final int x0 = 1;
    static double[] pesos = {0.5, 0.5, 0.5, 0.5, 0.5};

    public static void ler() throws FileNotFoundException {
        LerDados.lerDados("/home/joao/IdeaProjects/IA21_PERCEPTRON/src/main/resources/dados.csv");
    }

    public double soma_Ponderada(int[] entrada) {//Entrada com 5 valores, o primeiro sendo o rotulo
        double somaponderada = 0;

        somaponderada += 1 * pesos[0];

        for (int i = 1; i < entrada.length; i++) {
            somaponderada += entrada[i] * pesos[i];
        }

        return somaponderada;
    }

    public int funcaoAtivacao(int entrada[], double somaponderada) {
        if (somaponderada > 0) return 1;
        return -1;
    }

    public double[] calculaErro(int[] entrada, int saida) {
        double[] erro = new double[entrada.length];

        for (int i = 0; i < entrada.length; i++) {
            erro[i] = taxaAprendizado * (entrada[0] - saida) * entrada[i];
        }

        return erro;
    }

    public void ajustaPesos(int[] entrada, double[] erro) {
        for (int i = 1; i < pesos.length; i++) {
            pesos[i] += erro[i-1];
        }
    }

}
