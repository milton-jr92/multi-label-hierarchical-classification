package Classes;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author Milton
 */
public class TruthTable {

    private static void printTruthTable(int n) throws IOException {
        FileWriter arq = new FileWriter("classes.txt");
        PrintWriter gravarArq = new PrintWriter(arq);
        int rows = (int) Math.pow(2, n);

        for (int i = 0; i < rows; i++) {
            for (int j = n - 1; j >= 0; j--) {
                //System.out.print((i / (int) Math.pow(2, j)) % 2 + " ");
                gravarArq.printf((i / (int) Math.pow(2, j)) % 2 + " ");
            }
            //System.out.println();
            gravarArq.printf("\n");
        }

        arq.close();
    }

    public static void main(String[] args) throws IOException {
        printTruthTable(4125); // natural inteiro        
    }
}
