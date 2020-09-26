package USACO.Chapter2;/*
ID: richard78
LANG: JAVA
TASK: frac1
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class frac1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("frac1.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
        List<int[]> fractions = new ArrayList<int[]>();
        int denominator = Integer.parseInt(reader.readLine());

        for (int denom = 1; denom <= denominator; denom++)
        {
            for (int numer = 0; numer <= denom; numer++)
            {
                fractions.add(new int[] { numer, denom } );
            }
        }
        Collections.sort(fractions, new Comparator<int[]>()
        {
            public int compare(int[] o1, int[] o2)
            {
                int val1 = o1[0] * o2[1];
                int val2 = o2[0] * o1[1];
                if (val1 < val2) return -1; // compare actual value
                else if (val1 > val2) return 1;
                return o1[1] - o2[1]; // compare denominator
            }
        });

        for (int i = 0; i < fractions.size(); i++)
        {
            if (i > 0 && isEqual(fractions.get(i - 1), fractions.get(i)))
                continue;
            writer.println(fractions.get(i)[0] + "/" + fractions.get(i)[1]);
            System.out.println(fractions.get(i)[0] + "/" + fractions.get(i)[1]);
        }

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static boolean isEqual(int[] frac1, int[] frac2)
    {
        int val1 = frac1[0] * frac2[1];
        int val2 = frac2[0] * frac1[1];
        return val1 == val2;
    }
}
