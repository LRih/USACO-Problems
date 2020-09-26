package USACO.Chapter1;

/*
ID: richard78
LANG: JAVA
TASK: numtri
*/

import java.io.*;
import java.util.StringTokenizer;

public class numtri
{
    public static int[][] pyramid;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("numtri.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
        pyramid = new int[Integer.parseInt(reader.readLine())][];

        // load data
        for (int level = 0; level < pyramid.length; level++)
        {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            pyramid[level] = new int[level + 1];
            for (int i = 0; i < pyramid[level].length; i++)
                pyramid[level][i] = Integer.parseInt(tokenizer.nextToken());
        }
        // alg
        for (int level = pyramid.length - 2; level >= 0; level--)
        {
            for (int i = 0; i < pyramid[level].length; i++)
                pyramid[level][i] += Math.max(pyramid[level + 1][i], pyramid[level + 1][i + 1]);
        }
        // print max
        System.out.println(pyramid[0][0]);
        writer.println(pyramid[0][0]);

        reader.close();
        writer.close();
        System.exit(0);
    }
}
