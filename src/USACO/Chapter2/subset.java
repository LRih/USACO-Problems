package USACO.Chapter2;

/*
ID: richard78
LANG: JAVA
TASK: subset
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class subset
{
    public static int[][] counts;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("subset.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
        int n = Integer.parseInt(reader.readLine());
        int sum = (n * (n + 1)) / 2;
        int targetSum = sum / 2;
        // initialize cache
        counts = new int[targetSum + 1][n + 1];
        for (int y = 0; y < n + 1; y++)
        {
            for (int x = 0; x < targetSum + 1; x++)
                counts[x][y] = -1;
        }
        // calculate result
        if (sum % 2 != 0)
            writer.println(0);
        else
        {
            int count = getCount(targetSum, n);
            writer.println(count);
            System.out.println(count);
        }

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static int getCount(int targetSum, int elements)
    {
        if (targetSum < 0 || elements <= 0) return 0;
        else if (targetSum == 0) return 1;
        else if (counts[targetSum][elements] != -1) return counts[targetSum][elements];

        int count = getCount(targetSum, elements - 1) + getCount(targetSum - elements, elements - 1);
        counts[targetSum][elements] = count;
        return count;
    }
}
