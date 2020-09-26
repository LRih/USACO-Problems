package USACO.Chapter1;

/*
ID: richard78
LANG: JAVA
TASK: transform
*/

import java.io.*;

public class transform
{
    public static int size;
    public static String start = "";
    public static String result = "";
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("transform.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

        size = Integer.parseInt(reader.readLine());
        for (int i = 0; i < size; i++) start += reader.readLine();
        for (int i = 0; i < size; i++) result += reader.readLine();

        if (result.equals(rotate90(start))) writer.println(1);
        else if (result.equals(rotate180(start))) writer.println(2);
        else if (result.equals(rotate270(start))) writer.println(3);
        else if (result.equals(mirrorY(start))) writer.println(4);
        else if (result.equals(rotate90(mirrorY(start)))) writer.println(5);
        else if (result.equals(rotate180(mirrorY(start)))) writer.println(5);
        else if (result.equals(rotate270(mirrorY(start)))) writer.println(5);
        else if (start.equals(result)) writer.println(6);
        else writer.println(7);

        reader.close();
        writer.close();
    }

    public static String rotate90(String matrix)
    {
        return mirrorY(transpose(matrix));
    }
    public static String rotate180(String matrix)
    {
        return mirrorX(mirrorY(matrix));
    }
    public static String rotate270(String matrix)
    {
        return mirrorX(transpose(matrix));
    }
    public static String transpose(String matrix)
    {
        String transpose = "";
        for (int x = 0; x < size; x++)
        {
            for (int y = 0; y < size; y++)
                transpose += getChar(matrix, x, y);
        }
        return transpose;
    }
    public static String mirrorX(String matrix)
    {
        String mirrorX = "";
        for (int y = size - 1; y >= 0; y--)
        {
            for (int x = 0; x < size; x++)
                mirrorX += getChar(matrix, x, y);
        }
        return mirrorX;
    }
    public static String mirrorY(String matrix)
    {
        String mirrorY = "";
        for (int y = 0; y < size; y++)
        {
            for (int x = size - 1; x >= 0; x--)
                mirrorY += getChar(matrix, x, y);
        }
        return mirrorY;
    }

    public static char getChar(String matrix, int x, int y)
    {
        return matrix.charAt(size * y + x);
    }
}
