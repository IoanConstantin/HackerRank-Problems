import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getMostVisited' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY sprints
     */

    public static int getMostVisited(int n, List<Integer> sprints) {
    // Write your code here
        HashMap<Integer, Integer> dictionar = new HashMap<Integer, Integer>();

        for(int i = 0; i < sprints.size() - 1;i++) {
            int x1 = sprints.get(i);
            int x2 = sprints.get(i+1);
            int aux;
            if(x2 < x1){
                aux = x1;
                x1 = x2;
                x2 = aux;
            }

            for(int j = x1; j <= x2; j++) {
                if(dictionar.get(j) == null)
                    dictionar.put(j, 1);
                else
                {
                    int value = dictionar.get(j);
                    value++;
                    dictionar.put(j, value);
                }
            }
        }
        
        for(int z = 0; z < sprints.size();z++) {
	   	   if(dictionar.get(z) == null)
                    dictionar.put(z, 0);
        }

        int max = dictionar.get(0);
        int pmax = 0;
        for(int k = 1; k < sprints.size();k++)
        {
            if(dictionar.get(k) > max){
                max = dictionar.get(k);
                pmax = k;
            }
        }
        return pmax;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int sprintsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> sprints = IntStream.range(0, sprintsCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.getMostVisited(n, sprints);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
