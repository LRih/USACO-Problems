package USACO.Chapter2;

/*
ID: richard78
LANG: JAVA
TASK: prefix
*/

import java.io.*;
import java.util.*;

public class prefix
{
    public static List<String> primitives = new ArrayList<String>();
    public static String sequence = "";
    public static boolean[] visited;

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("prefix.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
        String line;
        while (!(line = reader.readLine()).equals("."))
        {
            StringTokenizer tokenizer = new StringTokenizer(line);
            while (tokenizer.hasMoreTokens())
                primitives.add(tokenizer.nextToken());
        }

        StringBuilder builder = new StringBuilder();
        while ((line = reader.readLine()) != null)
            builder.append(line);
        sequence = builder.toString();

        visited = new boolean[sequence.length() + 1];
        Arrays.fill(visited, false);

        int longest = getLongest();
        System.out.println(longest);
        writer.println(longest);

        reader.close();
        writer.close();
        System.exit(0);
    }

    // bfs
    public static int getLongest()
    {
        int longest = 0;

        Queue<Integer> q = new PriorityQueue<Integer>();
        q.add(0);

        while (!q.isEmpty())
        {
            int cur = q.poll();

            for (String primitive : primitives)
            {
                int nextLength = cur + primitive.length();
                if (isNextSequence(cur, primitive) && !visited[nextLength])
                {
                    q.add(nextLength);
                    longest = Math.max(longest, nextLength);
                    visited[nextLength] = true;
                }
            }
        }

        return longest;
    }

    public static boolean isNextSequence(int index, String primitive)
    {
        for (int i = 0; i < primitive.length(); i++)
            if (index + i > sequence.length() - 1 || primitive.charAt(i) != sequence.charAt(index + i)) return false;
        return true;
    }
}