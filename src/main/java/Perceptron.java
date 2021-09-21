import java.io.FileNotFoundException;
import java.io.IOException;

public class Perceptron {
    final static double taxaAprendizado = 0.1;
    final static int x0 = 1;
    static double[] pesos = {-0.5, 0.7, -0.2, 0.1, 0.9};
    static Integer[] entradasFixas = {1,-1,1,1,-1};
    static int saida;
    static double[] erro = new double[5];

    public static void treinar() throws IOException { // COLOCAR UMA ENTRADA FIXA!!!!!!!! AAAAA -1,-1,1,1,-1
        ler();
        holdout();
        //Treinamento:
        for (int i = 0; i < Holdout.conjTreinamento.size(); i++) {
            double somaPonderada = somaPonderada(Holdout.conjTreinamento.get(i));
            //System.out.println("Soma ponderada: " + somaPonderada);
            funcaoAtivacao(somaPonderada);
            calculaErro(Holdout.conjTreinamento.get(i));
            if (saida != Holdout.conjTreinamento.get(i)[0]) {
                ajustaPesos();
            }
        }

        //Teste:
        teste();
    }

    public static void teste() {
        for (int i = 0; i < Holdout.conjTeste.size(); i++) {
            double somaPonderada = somaPonderada(Holdout.conjTreinamento.get(i));
            funcaoAtivacao(somaPonderada);
            exibirVetor(Holdout.conjTreinamento.get(i));
        }
    }

    public static void exibirVetor(Integer[] vetor){
        System.out.print("Vetor: ");
        for (int i = 1; i < vetor.length; i++) {
            System.out.print(vetor[i]+" ");
        }
        System.out.println("\nSaída esperada: "+vetor[0]+" saída obtida: "+saida+"\n");

    }

    public static void ler() throws IOException {
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
            erro[i] = taxaAprendizado * (entrada[0] - saida) * entrada[i];
        }
    }

    public static void ajustaPesos() {
        for (int i = 0; i < pesos.length; i++) {
            pesos[i] += erro[i];
        }
    }
/*
    public static int classificar(Integer[] entrada){
        int somaPonderada = 0;
        for (int i = 1; i < entrada.length; i++) {
            somaPonderada += entrada[i] * pesos[i];
        }
        return somaPonderada;
    }

 */
}
