package In;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author Milton
 */
public class Cellcycle {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        ArrayList<String> gene = new ArrayList();
        Scanner scanner = new Scanner(new FileReader("GOClassesSemRepetir.txt"));
        Scanner scanner2 = new Scanner(new FileReader("cellcycle_GO.train.arff"));
        PrintWriter out = new PrintWriter("cellcycle_GO.arff", "UTF-8");
        PrintWriter classes = new PrintWriter("cellcycle_GO.classes.arff", "UTF-8");

        String instance = "";
        int j = 82;

        while (scanner.hasNext()) {
            gene.add(scanner.next());
        }

        int n = gene.size();
        
        while (scanner2.hasNext() && j < 1707) {
            try (Stream<String> lines = Files.lines(Paths.get("cellcycle_GO.train.arff"))) {
                instance = lines.skip(j).findFirst().get();
                String[] atributes = instance.split(",");
                // 76 atributos
                for (int k = 0; k < 77; k++) {
                    out.print(atributes[k] + ",");                    
                }
            }
            
            for (int i = 0; i < n; i++) {
                if (instance.contains(gene.get(i))) {
                    out.print("1");
                    classes.print("1");
                } else {
                    out.print("0");
                    classes.print("0");
                }
            }
            out.print("\n");
            classes.print(",");
            j++;
        }        
        out.close();
        classes.close();
        
        Cellcycle_DuplicatesInArray d = new Cellcycle_DuplicatesInArray();
    }

}
