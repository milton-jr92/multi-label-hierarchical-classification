package In;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Milton
 */
public class Church_DuplicatesInArray {

    String token1 = "";
    Scanner inFile1;

    public Church_DuplicatesInArray() throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter classesSemRepetir = new PrintWriter("Church_classesSemRepetir.arff", "UTF-8");
        this.inFile1 = new Scanner(new File("church_GO.classes.arff")).useDelimiter(",\\s*");

        List<String> temps = new ArrayList<String>();

        while (inFile1.hasNext()) {
            // find next line
            token1 = inFile1.next();
            temps.add(token1);
        }
        inFile1.close();

        String[] tempsArray = temps.toArray(new String[0]);
        Map<Integer, String> nameAndCount = new HashMap<Integer, String>();

        // build hash table with count
        Integer count = 1;
        for (String classes : tempsArray) {
            nameAndCount.put(count, classes);
            count++;
        }

        nameAndCount = invert(invert(nameAndCount));

        for (String str : nameAndCount.values()) {
            classesSemRepetir.print(str + ",");
        }
    }

    private static <K, V> Map<V, K> invert(Map<K, V> map) {
        Map<V, K> result = new HashMap<V, K>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            result.put(entry.getValue(), entry.getKey());
        }
        return result;
    }
}
