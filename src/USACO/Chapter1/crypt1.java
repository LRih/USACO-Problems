/*
ID: richard78
LANG: JAVA
TASK: crypt1
*/

import java.io.*;
import java.util.StringTokenizer;

public class crypt1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("crypt1.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
        int numberCount = Integer.parseInt(reader.readLine());
        int[] validNumbers = new int[numberCount];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numberCount; i++)
            validNumbers[i] = Integer.parseInt(tokenizer.nextToken());
        // checking
        int count = 0;
        for (int a = 1; a <= 9; a++)
        {
            if (!contains(validNumbers, a)) continue;
            for (int b = 1; b <= 9; b++)
            {
                if (!contains(validNumbers, b)) continue;
                for (int c = 1; c <= 9; c++)
                {
                    if (!contains(validNumbers, c)) continue;
                    for (int d = 1; d <= 9; d++)
                    {
                        if (!contains(validNumbers, d)) continue;
                        for (int e = 1; e <= 9; e++)
                        {
                            if (!contains(validNumbers, e)) continue;
                            if (doesComputationContain(a * 100 + b * 10 + c, d * 10 + e, validNumbers))
                            {
                                System.out.println((a * 100 + b * 10 + c) + " * " + (d * 10 + e));
                                count++;
                            }
                        }
                    }
                }
            }
        }
        writer.println(count);

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static boolean doesComputationContain(int v1, int v2, int[] array)
    {
        int intermediate1 = v1 * (v2 - v2 / 10 * 10);
        if (intermediate1 / 1000 > 0) return false;
        int intermediate2 = v1 * (v2 / 10);
        if (intermediate2 / 1000 > 0) return false;
        int answer = intermediate1 + (intermediate2 * 10);
        if (answer / 10000 > 0) return false;
        String value = String.valueOf(intermediate1) + String.valueOf(intermediate2) + String.valueOf(answer);
        for (char c : value.toCharArray())
            if (!contains(array, Integer.parseInt(String.valueOf(c)))) return false;
        System.out.println(intermediate1 + " + " + intermediate2 + " = " + answer);
        return true;
    }

    public static boolean contains(int[] array, int value)
    {
        for (int testNum : array)
        {
            if (testNum == value) return true;
        }
        return false;
    }
}
