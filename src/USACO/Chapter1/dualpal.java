/*
ID: richard78
LANG: JAVA
TASK: dualpal
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class dualpal
{
    public static void main(String[] args) throws IOException
    {
        // file
        BufferedReader reader = new BufferedReader(new FileReader("dualpal.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int times = Integer.parseInt(tokenizer.nextToken());
        int start = Integer.parseInt(tokenizer.nextToken());
        int found = 0;
        for (int i = start + 1; found != times; i++)
        {
            int isPalCount = 0;
            for (int base = 2; base <= 10; base++)
            {
                if (isPal(convertToBase(i, base)))
                    isPalCount++;
            }
            if (isPalCount >= 2)
            {
                writer.println(i);
                found++;
            }
        }

        reader.close();
        writer.close();
        System.exit(0);
    }
    
    public static boolean isPal(String str)
    {
        for (int index = 0; index < str.length() / 2; index++)
        {
            if (str.charAt(index) != str.charAt(str.length() - index - 1))
                return false;
        }
        return true;
    }
    
    public static String convertToBase(int number, int base)
    {
        int leftover = number;
        String result = "";
        while (leftover != 0)
        {
            result = leftover % base + result;
            leftover /= base;
        }
        return result;
    }
}
