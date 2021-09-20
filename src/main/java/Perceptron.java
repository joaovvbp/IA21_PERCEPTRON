import java.io.FileNotFoundException;

public class Perceptron {
    final double n = 0.1;
    final int x0 = 1;
    double[] pesos = {0.5,0.5,0.5,0.5,0.5};

    public static void ler() throws FileNotFoundException {
        LerDados.lerDados("dados.txt");
    }

    public double soma_Ponderada(int[] entrada){//Entrada com 5 valores, o primeiro sendo o rotulo
        double somaponderada = 0;

        somaponderada += 1*pesos[0];

        for (int i = 1; i < entrada.length; i++) {
            somaponderada += entrada[i]*pesos[i];
        }

        return somaponderada;
    }

    public int treshold(int entrada[], double somaponderada){
        if(somaponderada > 0) return 1;
        return -1;
    }

    public double[] calcula_Erro(int entrada[], int saida){
        double erro[] = new double [entrada.length];

        for (int i = 0; i < entrada.length; i++) {
            erro[i] = n * (entrada[0] - saida) * entrada[i];
        }

        return erro;
    }

    public void ajusta_Pesos(int entrada[], double erro[]){
        pesos[0] = 1 + erro[0];

        for (int i = 1; i < pesos.length; i++) {
             pesos[i] = entrada[i] + erro[i];
        }

    }

}
