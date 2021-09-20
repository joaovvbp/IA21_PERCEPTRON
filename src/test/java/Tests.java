//import org.junit.jupiter.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

public class Tests {
    Perceptron teste = new Perceptron();
    int vetorEntrada[] = {1,1,1,1};
    int vetorSaida1[] = {0,0,0,0};

    @Test
    public void testeSomaPonderada1(){
        Assertions.assertEquals(2, teste.soma_Ponderada(vetorEntrada));
    }
/*
    @Test
    public void testeCalculaErro1(){
        Assertions.assertEquals(vetorSaida1, teste.calcula_Erro(vetorEntrada, 0));
    }
*/
    @Test
    public void Testar() {
        try {
            Perceptron.ler();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Holdout.dividir();
        Holdout.exibirTaxaDiv();
    }
}

