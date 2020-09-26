package USACO.Chapter2;

/*
ID: richard78
LANG: JAVA
TASK: skidesign
*/

import java.io.*;

public class skidesign
{
    public static int[] hills;
    public static int[] modHills;
    public static int min = 9999, max = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("skidesign.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
        int n = Integer.parseInt(reader.readLine());
        hills = new int[n];
        modHills = new int [n];
        for (int i = 0; i < n; i++)
        {
            hills[i] = Integer.parseInt(reader.readLine());
            modHills[i] = hills[i];
        }

        generateMinMax();

        while (max - min > 17)
        {
            if (costToRaise() > costToReduce()) reduce();
            else raise();
        }

        int cost = 0;
        for (int i = 0; i < hills.length; i++)
        {
            int diff = Math.abs(hills[i] - modHills[i]);
            cost += Math.pow(diff, 2);
        }

        writer.println(cost);
        System.out.println(cost);

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static void raise()
    {
        for (int i = 0; i < modHills.length; i++)
        {
            if (modHills[i] == min)
                modHills[i]++;
        }
        min++;
    }
    public static void reduce()
    {
        for (int i = 0; i < modHills.length; i++)
        {
            if (modHills[i] == max)
                modHills[i]--;
        }
        max--;
    }

    public static int costToRaise()
    {
        int cost = 0;
        for (int i = 0; i < modHills.length; i++)
        {
            if (modHills[i] == min)
                cost += Math.pow(Math.abs(hills[i] - modHills[i] - 1), 2) - Math.pow(Math.abs(hills[i] - modHills[i]), 2);
        }
        return cost;
    }
    public static int costToReduce()
    {
        int cost = 0;
        for (int i = 0; i < modHills.length; i++)
        {
            if (modHills[i] == max)
                cost += Math.pow(Math.abs(hills[i] - modHills[i] + 1), 2) - Math.pow(Math.abs(hills[i] - modHills[i]), 2);
        }
        return cost;
    }

    public static void generateMinMax()
    {
        for (int i = 0; i < hills.length; i++)
        {
            min = Math.min(hills[i], min);
            max = Math.max(hills[i], max);
        }
    }
}
