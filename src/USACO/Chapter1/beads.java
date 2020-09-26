/*
ID: richard78
LANG: JAVA
TASK: beads
*/

import java.io.*;

public class beads
{
    public static String beads;
    public static void main(String[] args) throws IOException
    {
        // file
        BufferedReader reader = new BufferedReader(new FileReader("beads.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));

        reader.readLine();
        beads = reader.readLine();
        int max = 0;
        for (int index = 0; index < beads.length(); index++)
        {
            max = Math.max(getMaxBeads(index), max);
            System.out.println(index + ": " + max);
        }

        writer.println(max);
        reader.close();
        writer.close();
        System.exit(0);
    }

    public static int getMaxBeads(int index)
    {
        int maxLeft = 0;
        int maxRight = 0;
        char colorDeterm = 'n';
        char curColor;
        while (true)
        {
            curColor = getColor(index - maxLeft - 1);
            if (colorDeterm == 'n')
            {
                if (curColor == 'r' || curColor == 'b') colorDeterm = curColor;
            }
            if (colorDeterm == 'n' || colorDeterm == curColor || curColor == 'w') maxLeft++;
            else break;
            if (maxLeft == beads.length()) break;
        }
        colorDeterm = 'n';
        while (true)
        {
            if (maxRight == beads.length()) break;
            curColor = getColor(index + maxRight);
            if (colorDeterm == 'n')
            {
                if (curColor == 'r' || curColor == 'b') colorDeterm = curColor;
            }
            if (colorDeterm == 'n' || colorDeterm == curColor || curColor == 'w') maxRight++;
            else break;
            if (maxRight == beads.length()) break;
        }
        System.out.println(index + ": " + maxLeft + ", " + maxRight);
        return Math.min(maxLeft + maxRight, beads.length());
    }
    public static char getColor(int index)
    {
        if (index < 0) return beads.charAt(beads.length() + index);
        else if (index >= beads.length()) return beads.charAt(index - beads.length());
        else return beads.charAt(index);
    }
}
