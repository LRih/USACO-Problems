package USACO.Chapter2;/*
ID: richard78
LANG: JAVA
TASK: lamps
*/

import java.io.*;
import java.util.StringTokenizer;

public class lamps
{
    public static int[] buttons = new int[] { 0xffffffff, 0x55555555, 0xaaaaaaaa };
    public static int[][] solutions = new int[1000000][];
    public static int solutionIndex = 0;
    public static int[] restricts; // -1 = no restrictions
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("lamps.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
        int lampCount = Integer.parseInt(reader.readLine());
        int pressCount = Integer.parseInt(reader.readLine());
        restricts = new int[lampCount];
        for (int i = 0; i < restricts.length; i++)
            restricts[i] = -1;
        int index;
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens() && (index = Integer.parseInt(tokenizer.nextToken())) != -1)
            restricts[index] = 1;
        tokenizer = new StringTokenizer(reader.readLine());
        while (tokenizer.hasMoreTokens() && (index = Integer.parseInt(tokenizer.nextToken())) != -1)
            restricts[index] = 0;

        iteratePresses(press(new int[4], 0), pressCount);
        for (int i = 0; i < solutionIndex; i++)
            print(solutions[i], lampCount);

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static void iteratePresses(int[] lamps, int pressCount)
    {
        if (pressCount == 0) return;
        for (int button = 0; button <= 3; button++)
        {
            int[] newLamps = press(lamps, button);
            if (!alreadyExist(newLamps))
            {
                solutions[solutionIndex] = newLamps;
                solutionIndex++;
                iteratePresses(newLamps, pressCount - 1);
            }
        }
    }
    public static boolean alreadyExist(int[] lamps)
    {
        for (int i = 0; i < solutionIndex; i++)
        {
            if (lamps[0] == solutions[i][0] && lamps[1] == solutions[i][1] && lamps[2] == solutions[i][2] && lamps[3] == solutions[i][3])
                return true;
        }
        return false;
    }

    public static int[] press(int[] lamps, int button)
    {
        if (button == 3)
            return new int[] { lamps[0] ^ 0x92492492, lamps[1] ^ 0x49249249, lamps[2] ^ 0x24924924, lamps[3] ^ 0x92492492 };
        else
            return new int[] { lamps[0] ^ buttons[button], lamps[1] ^ buttons[button], lamps[2] ^ buttons[button], lamps[3] ^ buttons[button] };
    }

    public static void print(int[] lamps, int length)
    {
        for (int lamp : lamps)
        {
            for (int i = 31; i >= 0; i--)
                System.out.print(((lamp >> i) & 1) == 0 ? 0 : 1);
        }
        System.out.println();
    }
}
