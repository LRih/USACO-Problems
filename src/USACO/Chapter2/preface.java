package USACO.Chapter2;

/*
ID: richard78
LANG: JAVA
TASK: preface
*/

import java.io.*;
import java.util.LinkedHashMap;

public class preface
{
    public static int pages;
    public static LinkedHashMap<String, Integer> letterCounts = new LinkedHashMap<String, Integer>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("preface.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
        pages = Integer.parseInt(reader.readLine());
        letterCounts.put("I", 0);
        letterCounts.put("V", 0);
        letterCounts.put("X", 0);
        letterCounts.put("L", 0);
        letterCounts.put("C", 0);
        letterCounts.put("D", 0);
        letterCounts.put("M", 0);

        generateLetters();

        for (String key : letterCounts.keySet())
        {
            if (letterCounts.get(key) > 0)
            {
                writer.println(key + " " + letterCounts.get(key));
                System.out.println(key + " " + letterCounts.get(key));
            }
        }

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static void generateLetters()
    {
        for (int thousands = 0; thousands <= 9; thousands++)
        {
            String textThousands = getPrefix(thousands, "_", "_", "M");
            for (int hundreds = 0; hundreds <= 9; hundreds++)
            {
                String textHundreds = textThousands + getPrefix(hundreds, "M", "D", "C");
                for (int tens = 0; tens <= 9; tens++)
                {
                    String textTens = textHundreds + getPrefix(tens, "C", "L", "X");
                    for (int ones = 0; ones <= 9; ones++)
                    {
                        int value = thousands * 1000 + hundreds * 100 + tens * 10 + ones;
                        if (value > pages) return;
                        System.out.println(value + " " + textTens + getPrefix(ones, "X", "V", "I"));
                        setPrefix(thousands, "_", "_", "M");
                        setPrefix(hundreds, "M", "D", "C");
                        setPrefix(tens, "C", "L", "X");
                        setPrefix(ones, "X", "V", "I");
                    }
                }
            }
        }
    }

    public static void setPrefix(int value, String s1, String s2, String s3)
    {
        if (value == 0)
            return;
        else if (value <= 3)
            for (int i = 0; i < value; i++) letterCounts.put(s3, letterCounts.get(s3) + 1);
        else if (value == 4)
        {
            letterCounts.put(s3, letterCounts.get(s3) + 1);
            letterCounts.put(s2, letterCounts.get(s2) + 1);
        }
        else if (value <= 8)
        {
            letterCounts.put(s2, letterCounts.get(s2) + 1);
            for (int i = 5; i < value; i++) letterCounts.put(s3, letterCounts.get(s3) + 1);
        }
        else if (value == 9)
        {
            letterCounts.put(s3, letterCounts.get(s3) + 1);
            letterCounts.put(s1, letterCounts.get(s1) + 1);
        }
    }

    public static String getPrefix(int value, String s1, String s2, String s3)
    {
        String text = "";
        if (value == 0)
            return text;
        else if (value <= 3)
            for (int i = 0; i < value; i++) text += s3;
        else if (value == 4)
            text += s3 + s2;
        else if (value <= 8)
        {
            text += s2;
            for (int i = 5; i < value; i++) text += s3;
        }
        else if (value == 9)
            text += s3 + s1;
        return text;
    }
}
