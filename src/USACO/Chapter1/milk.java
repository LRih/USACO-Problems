package USACO.Chapter1;

/*
ID: richard78
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;

public class milk
{
    public static void main(String[] args) throws IOException
    {
        // file
        BufferedReader reader = new BufferedReader(new FileReader("milk.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
        int required = Integer.parseInt(reader.readLine().split("\\s")[0]);
        int spent = 0;
        // sort prices
        List<int[]> prices = new ArrayList<int[]>();
        String line;
        while ((line = reader.readLine()) != null)
        {
            StringTokenizer tokenizer = new StringTokenizer(line);
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            prices.add(new int[] { start, end });
        }
        Collections.sort(prices, new Comparator<int[]>()
        {
            public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];
            }
        });
        // algorithm
        int buyIndex = 0;
        while (required > 0)
        {
            int[] values = prices.get(buyIndex);
            int buyAmount = Math.min(values[1], required);
            required -= buyAmount;
            spent += values[0] * buyAmount;
            buyIndex++;
        }

        writer.println(spent);

        reader.close();
        writer.close();
    }
}
