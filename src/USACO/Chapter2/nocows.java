package USACO.Chapter2;

/*
ID: richard78
LANG: JAVA
TASK: nocows
*/

import java.io.*;
import java.util.StringTokenizer;

// unfinished
public class nocows
{
    public static int maxNodes;
    public static int maxHeight;

    public static int total = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("nocows.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        maxNodes = Integer.parseInt(st.nextToken());
        maxHeight = Integer.parseInt(st.nextToken());

        traverse(maxNodes, 1);

        System.out.println(total);

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static void traverse(int nodesLeft, int height)
    {
        if (nodesLeft == 0 && height == maxHeight)
        {
            total++;
            return;
        }

        if (nodesLeft >= 2 && height != maxHeight)
        {
            traverse(nodesLeft - 2, height + 1);
            traverse(nodesLeft - 2, height + 1);
        }
    }
}
