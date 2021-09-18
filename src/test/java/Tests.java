//import org.junit.jupiter.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Tests {
    Perceptron teste = new Perceptron();
    int vetorEntrada[] = {0,0,0,0};
    int vetorSaida1[] = {0,0,0,0};

    @Test
    public void testeSomaPonderada1(){
        Assertions.assertEquals(0.5, teste.soma_Ponderada(vetorEntrada));
    }
/*
    @Test
    public void testeCalculaErro1(){
        Assertions.assertEquals(vetorSaida1, teste.calcula_Erro(vetorEntrada, 0));
    }
*/
}

