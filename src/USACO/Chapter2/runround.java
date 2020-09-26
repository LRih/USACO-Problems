package USACO.Chapter2;

/*
ID: richard78
LANG: JAVA
TASK: runround
*/

import java.io.*;
import java.util.Arrays;

public class runround
{
    public static int[] numberArray = new int[9];
    public static int length;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("runround.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
        String numberString = reader.readLine();
        length = numberString.length();
        setNumber(numberString);

        System.out.println(Arrays.toString(numberArray));
        // find runaround
        do { increment(); }
        while (containsDuplicateDigits() || !checkRunaround());
        // print
        for (int digit : numberArray)
        {
            if (digit != 0)
            {
                writer.print(digit);
                System.out.print(digit);
            }
        }
        writer.println();
        System.out.println();

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static void setNumber(String numberString)
    {
        int start = numberArray.length - numberString.length();
        for (int i = start; i < numberArray.length; i++)
        {
            numberArray[i] = Math.max(Integer.parseInt(String.valueOf(numberString.charAt(i - start))), 1);
        }
    }

    public static void increment()
    {
        int carry = 1;
        int digit = numberArray.length - 1;
        while (carry == 1)
        {
            if (numberArray[digit] == 9)
                numberArray[digit] = 1;
            else
            {
                if (numberArray[digit] == 0) length++;
                numberArray[digit] ++;
                carry = 0;
            }
            digit--;
        }
    }

    public static boolean containsDuplicateDigits()
    {
        int[] digits = new int[10];
        for (int i = numberArray.length - length; i < numberArray.length; i++)
        {
            if (digits[numberArray[i]] == 1) return true;
            else digits[numberArray[i]] = 1;
        }
        return false;
    }

    public static boolean checkRunaround()
    {
//        System.out.println(Arrays.toString(numberArray));
        int[] landedIndexes = new int[length];
        int startIndex = numberArray.length - length;
        int currentIndex = startIndex;
        for (int i = 0; i < length; i++)
        {
            int value = numberArray[currentIndex];
            int actualIndex = currentIndex - startIndex;
//            System.out.println("current index: " + currentIndex + " value: " + value);
            currentIndex = (actualIndex + value) % length + startIndex;
            if (landedIndexes[currentIndex - startIndex] == 1) return false;
            else landedIndexes[currentIndex - startIndex] = 1;
        }
        return (currentIndex == startIndex);
//        System.out.println(Arrays.toString(landedIndexes));
    }
}
