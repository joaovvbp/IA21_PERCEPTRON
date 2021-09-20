import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Holdout {

    static List<Integer[]> conjTreinamento = new ArrayList<>();
    static List<Integer[]> conjTeste = new ArrayList<>();
    static Random random = new Random();
    static double taxaConjTeste = 0.3; //% de elementos no conjunto de teste
    static double taxaTeste = 0.0; //Não mudar
    static double taxaTreinamento = 0.0; //Não mudar
    static double grauDePrecisao = 0.02; //Taxa de precisão minima, valores muito pequenos causarão falha
    static boolean usarConjDeValidacao = false; //Ainda não implementado

    //Faz a divisão dos elementos entre os dois conjuntos
    public static void dividir () {
        conjTeste.clear();
        conjTreinamento.clear();
        for (Integer[] vetor:LerDados.vetores){
            int numero = random.nextInt(10);
            if (numero < taxaConjTeste * 10) {
                conjTeste.add(vetor);
            } else {
                conjTreinamento.add(vetor);
            }
        }
        conferirPrecisao();
    }

    public static void conferirPrecisao(){
        calcularTaxas();
        while(taxaTeste - taxaConjTeste > grauDePrecisao || -(taxaTeste - taxaConjTeste) > grauDePrecisao)
            dividir();
    }

    public static void calcularTaxas(){
        taxaTeste = conjTeste.size()/(double)(conjTreinamento.size()+conjTeste.size());
        taxaTreinamento = conjTreinamento.size()/(double)(conjTreinamento.size()+conjTeste.size());
    }


    public static void exibirTaxaDiv(){
        calcularTaxas();
        System.out.println("Precisão: "+(1-(Math.abs(taxaTeste-Math.abs(taxaConjTeste))))*100+"%");
        System.out.println("% conjunto de treinamento: "+taxaTreinamento);
        System.out.println("% conjunto de teste: "+taxaTeste);
    }

}
