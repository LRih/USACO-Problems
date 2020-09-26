package USACO.Chapter2;

/*
ID: richard78
LANG: JAVA
TASK: wormhole
*/

import java.io.*;
import java.util.StringTokenizer;

public class wormhole
{
    public static int[][] coords;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("wormhole.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
        int n = Integer.parseInt(reader.readLine());
        coords = new int[n][];
        for (int i = 0; i < n; i++)
        {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            coords[i] = new int[2];
            coords[i][0] = Integer.parseInt(tokenizer.nextToken());
            coords[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static int combin(int num)
    {
        return fact(num) / (fact(num - 2) * fact(2));
    }
    public static int fact(int x)
    {
        int sum = 1;
        for (int i = 2; i <= x; i++)
            sum *= i;
        return sum;
    }
}
