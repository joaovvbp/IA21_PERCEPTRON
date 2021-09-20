//import org.junit.jupiter.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

class Tests {
    Perceptron teste = new Perceptron();
    Integer[] vetorEntrada = {1,1,1,1};

    @Test
    void testeSomaPonderada1(){
        Assertions.assertEquals(2, teste.somaPonderada(vetorEntrada));
    }
/*
    @Test
    public void testeCalculaErro1(){
        Assertions.assertEquals(vetorSaida1, teste.calcula_Erro(vetorEntrada, 0));
    }
*/
    @Test
    void testarPerceptron() throws FileNotFoundException {
        Perceptron.treinar();
        Assertions.assertEquals();
    }
}

