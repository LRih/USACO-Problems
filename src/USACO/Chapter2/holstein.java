package USACO.Chapter2;/*
ID: richard78
LANG: JAVA
TASK: holstein
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class holstein
{
    public static int[] vitaminTargets;
    public static int[][] feedTypes;
    public static int[] results;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("holstein.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
        vitaminTargets = new int[Integer.parseInt(reader.readLine())];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < vitaminTargets.length; i++)
        {
            vitaminTargets[i] = Integer.parseInt(tokenizer.nextToken());
        }
        feedTypes = new int[Integer.parseInt(reader.readLine())][vitaminTargets.length];
        for (int i = 0; i < feedTypes.length; i++)
        {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < vitaminTargets.length; j++)
                feedTypes[i][j] = Integer.parseInt(tokenizer.nextToken());
        }
        // get result
        for (int i = 0; !check(0, i, new int[25], new int[15]); i++);
        int max = 0;
        String types = "";
        for (int i = 0; i < feedTypes.length; i++)
        {
            if (results[i] == 1)
            {
                types += " " + (i + 1);
                max++;
            }
        }
        writer.println(max + types);
        System.out.println(max + types);

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static boolean check(int startIndex, int depth, int[] vitamins, int[] result)
    {
        for (int i = startIndex; i < feedTypes.length; i++)
        {
            int[] newVitamins = Arrays.copyOf(vitamins, vitamins.length);
            for (int vitaminIndex = 0; vitaminIndex < vitaminTargets.length; vitaminIndex++)
                newVitamins[vitaminIndex] += feedTypes[i][vitaminIndex];
            int[] newResult = Arrays.copyOf(result, result.length);
            newResult[i] = 1;
            if (depth > 1)
            {
                if (check(i + 1, depth - 1, newVitamins, newResult)) return true;
            }
            else if (isTargetMet(newVitamins, vitaminTargets))
            {
                results = newResult;
                return true;
            }
        }
        return false;
    }

    public static boolean isTargetMet(int[] cow, int[] target)
    {
        for (int i = 0; i < target.length; i++)
        {
            if (cow[i] < target[i]) return false;
        }
        return true;
    }
}
