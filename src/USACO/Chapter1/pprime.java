package USACO.Chapter1;

/*
ID: richard78
LANG: JAVA
TASK: pprime
*/

import java.io.*;
import java.util.StringTokenizer;

public class pprime
{
    public static int start, end;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("pprime.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        String startString = tokenizer.nextToken();
        String endString = tokenizer.nextToken();
        start = Integer.parseInt(startString);
        end = Integer.parseInt(endString);

        if (start < 10) listPrimePalindromes1(writer);
        if (startString.length() <= 2) listPrimePalindromes2(writer);
        if (startString.length() <= 3) listPrimePalindromes3(writer);
        if (startString.length() <= 4) listPrimePalindromes4(writer);
        if (startString.length() <= 5) listPrimePalindromes5(writer);
        if (startString.length() <= 6) listPrimePalindromes6(writer);
        if (startString.length() <= 7) listPrimePalindromes7(writer);
        if (startString.length() <= 8) listPrimePalindromes8(writer);

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static boolean isPrime(int number)
    {
        if (number == 0 || number == 1) return false;
        for (int divisor = 2; divisor < (int)Math.sqrt(number) + 1; divisor++)
            if (number % divisor == 0) return false;
        return true;
    }

    public static void listPrimePalindromes1(PrintWriter writer)
    {
        for (int i = start; i <= 9; i++)
        {
            if (i > end) break;
            if (isPrime(i)) writer.println(i);
        }
    }
    public static void listPrimePalindromes2(PrintWriter writer)
    {
        for (int i = 1; i <= 9; i += 2)
        {
            int number = i * 10 + i;
            if (number < start) continue;
            else if (number > end) break;
            if (isPrime(number)) writer.println(number);
        }
    }
    public static void listPrimePalindromes3(PrintWriter writer)
    {
        for (int i = 1; i <= 9; i += 2)
        {
            for (int j = 0; j <= 9; j++)
            {
                int number = i * 100 + j * 10 + i;
                if (number < start) continue;
                else if (number > end) break;
                if (isPrime(number)) writer.println(number);
            }
        }
    }
    public static void listPrimePalindromes4(PrintWriter writer)
    {
        for (int i = 1; i <= 9; i += 2)
        {
            for (int j = 0; j <= 9; j++)
            {
                int number = i * 1000 + j * 100 + j * 10 + i;
                if (number < start) continue;
                else if (number > end) break;
                if (isPrime(number)) writer.println(number);
            }
        }
    }
    public static void listPrimePalindromes5(PrintWriter writer)
    {
        for (int i = 1; i <= 9; i += 2)
        {
            for (int j = 0; j <= 9; j++)
            {
                for (int k = 0; k <= 9; k++)
                {
                    int number = i * 10000 + j * 1000 + k * 100 + j * 10 + i;
                    if (number < start) continue;
                    else if (number > end) break;
                    if (isPrime(number)) writer.println(number);
                }
            }
        }
    }
    public static void listPrimePalindromes6(PrintWriter writer)
    {
        for (int i = 1; i <= 9; i += 2)
        {
            for (int j = 0; j <= 9; j++)
            {
                for (int k = 0; k <= 9; k++)
                {
                    int number = i * 100000 + j * 10000 + k * 1000 + k * 100 + j * 10 + i;
                    if (number < start) continue;
                    else if (number > end) break;
                    if (isPrime(number)) writer.println(number);
                }
            }
        }
    }
    public static void listPrimePalindromes7(PrintWriter writer)
    {
        for (int i = 1; i <= 9; i += 2)
        {
            for (int j = 0; j <= 9; j++)
            {
                for (int k = 0; k <= 9; k++)
                {
                    for (int l = 0; l <= 9; l++)
                    {
                        int number = i * 1000000 + j * 100000 + k * 10000 + l * 1000 + k * 100 + j * 10 + i;
                        if (number < start) continue;
                        else if (number > end) break;
                        if (isPrime(number)) writer.println(number);
                    }
                }
            }
        }
    }
    public static void listPrimePalindromes8(PrintWriter writer)
    {
        for (int i = 1; i <= 9; i += 2)
        {
            for (int j = 0; j <= 9; j++)
            {
                for (int k = 0; k <= 9; k++)
                {
                    for (int l = 0; l <= 9; l++)
                    {
                        int number = i * 10000000 + j * 1000000 + k * 100000 + l * 10000 + l * 1000 + k * 100 + j * 10 + i;
                        if (number < start) continue;
                        else if (number > end) break;
                        if (isPrime(number)) writer.println(number);
                    }
                }
            }
        }
    }
}
