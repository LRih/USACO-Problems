package USACO.Chapter1;

/*
ID: richard78
LANG: JAVA
TASK: palsquare
*/

import java.io.*;

public class palsquare
{
    public static void main(String[] args) throws IOException
    {
        // file
        BufferedReader reader = new BufferedReader(new FileReader("palsquare.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
        int base = Integer.parseInt(reader.readLine());
        
        for (int i = 1; i < 300; i++)
        {
            boolean isPal = true;
            String square = convertToBase(i * i, base);
            for (int index = 0; index < square.length() / 2; index++)
            {
                if (square.charAt(index) != square.charAt(square.length() - index - 1))
                    isPal = false;
            }
            if (isPal)
                writer.println(convertToBase(i, base) + " " + square);
        }

        reader.close();
        writer.close();
    }
    
    public static String convertToBase(int number, int base)
    {
        int leftover = number;
        String result = "";
        while (leftover != 0)
        {
            result = IntToChar(leftover % base) + result;
            leftover /= base;
        }
        return result;
    }
    
    public static char IntToChar(int number)
    {
        if (number >= 10) return (char)(55 + number);
        else return String.valueOf(number).charAt(0);
    }
}
