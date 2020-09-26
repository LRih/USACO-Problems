package USACO.Chapter1;

/*
ID: richard78
LANG: JAVA
TASK: sprime
*/

import java.io.*;

public class sprime
{
    public static int digits;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("sprime.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
        digits = Integer.parseInt(reader.readLine());

        int current = (int)Math.pow(10, digits - 1) + 1;
        int end = (int)Math.pow(10, digits) - 1;
        while (current <= end)
        {
            boolean isSuperprime = true;
            for (int digit = 1; digit <= digits; digit++)
            {
                if (!isFirstXDigitsPrime(current, digit))
                {
                    isSuperprime = false;
                    int mag = (int)Math.pow(10, digits - digit);
                    current = (current + mag) / mag * mag;
                    break;
                }
            }
            if (isSuperprime)
            {
                writer.println(current);
                System.out.println(current);
                current += 2;
            }
        }

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static boolean isFirstXDigitsPrime(int number, int x)
    {
        for (int i = 0; i < digits - x; i++)
            number /= 10;
        return isPrime(number);
    }

    public static boolean isPrime(int number)
    {
        if (number == 0 || number == 1) return false;
        for (int divisor = 2; divisor < (int)Math.sqrt(number) + 1; divisor++)
            if (number % divisor == 0) return false;
        return true;
    }
}
