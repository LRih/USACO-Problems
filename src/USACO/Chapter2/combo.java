package USACO.Chapter2;/*
ID: richard78
LANG: JAVA
TASK: combo
*/

import java.io.*;
import java.util.StringTokenizer;

public class combo
{
    public static int n;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("combo.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
        n = Integer.parseInt(reader.readLine());

        int[] combo1 = new int[3];
        int[] combo2 = new int[3];
        StringTokenizer tokenizer1 = new StringTokenizer(reader.readLine());
        StringTokenizer tokenizer2 = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 3; i++)
        {
            combo1[i] = Integer.parseInt(tokenizer1.nextToken());
            combo2[i] = Integer.parseInt(tokenizer2.nextToken());
        }

        int ans = 0;
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                for (int k = 1; k <= n; k++)
                {
                    if (isOpenable(combo1, i, j, k) || isOpenable(combo2, i, j, k)) ans++;
                }
            }
        }

        System.out.println(ans);
        writer.println(ans);

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static boolean isOpenable(int[] combo, int i, int j, int k)
    {
        return getDiff(combo[0], i) <= 2 && getDiff(combo[1], j) <= 2 && getDiff(combo[2], k) <= 2;
    }

    public static int getDiff(int i, int j)
    {
        int diff = Math.abs(i - j);
        if (diff > n / 2) diff = n - diff;
        return diff;
    }
}
