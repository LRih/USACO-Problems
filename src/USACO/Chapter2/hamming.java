package USACO.Chapter2;/*
ID: richard78
LANG: JAVA
TASK: hamming
*/

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hamming
{
    public static int minDistance;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("hamming.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] numbers = new int[Integer.parseInt(tokenizer.nextToken())];
        int totalBits = Integer.parseInt(tokenizer.nextToken());
        minDistance = Integer.parseInt(tokenizer.nextToken());

        for (int numberIndex = 0; numberIndex < numbers.length; numberIndex++)
        {
            int newNum = 0;
            for (; !isRequirementMet(newNum, numbers, numberIndex); newNum++);
            numbers[numberIndex] = newNum;
        }

        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length; i++)
        {
            if (i % 10 != 0) writer.print(" ");
            writer.print(numbers[i]);
            if ((i + 1) % 10 == 0) writer.println();
        }
        if (numbers.length % 10 != 0) writer.println();

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static boolean isRequirementMet(int testNum, int[] numbers, int exclusiveUpperBound)
    {
        for (int i = 0; i < exclusiveUpperBound; i++)
        {
            if (getHammingDistance(testNum, numbers[i]) < minDistance)
                return false;
        }
        return true;
    }

    public static int getHammingDistance(int num1, int num2)
    {
        int dist = 0;
        for (int i = 0; i < 8; i++)
        {
            if (((num1 >> i) & 1) != ((num2 >> i) & 1)) dist++;
        }
        return dist;
    }
}
