package USACO.Chapter1;

/*
ID: richard78
LANG: JAVA
TASK: ride
*/

import java.io.*;

public class ride
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("ride.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
        // algorithm
        String str1 = reader.readLine();
        String str2 = reader.readLine();
        if (calculateValue(str1) % 47 == calculateValue(str2) % 47) writer.println("GO");
        else writer.println("STAY");
        reader.close();
        writer.close();
        System.exit(0);
    }

    public static int calculateValue(String name)
    {
        int value = 1;
        for (char c : name.toCharArray())
            value *= ((int)c - 64);
        return value;
    }
}
