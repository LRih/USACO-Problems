/*
ID: richard78
LANG: JAVA
TASK: ariprog
*/

import java.io.*;

public class ariprog
{
    public static int[] bisquares = new int[125000 + 1]; // 2 * 250^2
    public static int largestBisquare = 0;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("ariprog.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
        int maxN = Integer.parseInt(reader.readLine()) - 1;
        int maxM = Integer.parseInt(reader.readLine());

        generateBisquares(maxM);

        boolean isFound = false;
        for (int b = 1; b <= largestBisquare / maxN; b++)
        {
            for (int a = 0; a <= largestBisquare; a++)
            {
                if (bisquares[a] == 0) continue;
                if (isBisquareProgression(a, b, maxN))
                {
                    writer.println(a + " " + b);
                    System.out.println(a + " " + b);
                    isFound = true;
                }
            }
        }
        if (!isFound) writer.println("NONE");

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static void generateBisquares(int limit)
    {
        System.out.print("bisquares: ");
        for (int p = 0; p <= limit; p++)
        {
            for (int q = p; q <= limit; q++)
            {
                int value = p * p + q * q;
                bisquares[value] = 1;
                largestBisquare = value;
//                System.out.print(value + " ");
            }
        }
        System.out.println();
    }

    public static boolean isBisquareProgression(int a, int b, int limit)
    {
        int value = a + limit * b;
        for (int n = 0; n <= limit; n++)
        {
            if (value > largestBisquare || bisquares[value] == 0) return false;
            value -= b;
        }
        return true;
    }
}
