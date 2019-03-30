import java.io.*;
import java.util.*;
import java.util.regex.*;


public class Solution {
    private static final Scanner scan = new Scanner(System.in);
    
    public static void main(String args[]) throws Exception {
        // read the string filename
        String filename;
        filename = scan.nextLine();

        PrintWriter writer = new PrintWriter("req_".concat(filename));

        HashMap <String, Double> dictionar = new HashMap <String, Double>();
        String line, aux,aux2;
        RandomAccessFile file = new RandomAccessFile(filename, "r");
        while((line=file.readLine())!=null) {
            StringTokenizer st = new StringTokenizer(line, "[]");
            aux = st.nextToken();
            aux = st.nextToken();

            StringTokenizer st2 = new StringTokenizer(aux, " ");
            aux2 = st2.nextToken();
            
            if(dictionar.get(aux2) == null)
                dictionar.put(aux2,1.0);
            else 
                writer.println(aux2);
        }
        
        writer.close();
    }
}
