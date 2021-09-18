import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LerDados {

    static List<Integer[]> vetores = new ArrayList<>();

    static void lerDados(String nome) throws FileNotFoundException {

        String[] entradaString;
        Integer[] entradaInteger = new Integer[4];

        Scanner in = new Scanner(new FileReader(nome));

        while (in.hasNextLine()) {
            String line = in.nextLine();
            entradaString = line.split(",");
            for(int i=0;i<4;i++){
                entradaInteger[i] = Integer.parseInt(entradaString[i]);
            }
            vetores.add(entradaInteger);
        }

    }
}
