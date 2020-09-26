package USACO.Chapter1;

/*
ID: richard78
LANG: JAVA
TASK: milk2
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class milk2
{
    public static void main(String[] args) throws IOException
    {
        // file
        BufferedReader reader = new BufferedReader(new FileReader("milk2.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
        reader.readLine();
        // get and sort times
        List<int[]> rawTimes = new ArrayList<int[]>();
        String line;
        while ((line = reader.readLine()) != null)
        {
            StringTokenizer tokenizer = new StringTokenizer(line);
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            rawTimes.add(new int[] { start, end });
        }
        Collections.sort(rawTimes, new Comparator<int[]>()
        {
            public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];
            }
        });
        // get combined milking times
        List<int[]> times = new ArrayList<int[]>();
        for (int[] rawTime : rawTimes)
        {
            int start = rawTime[0];
            int end = rawTime[1];
            boolean combined = false;
            for (int[] time : times)
            {
                if (start < time[0] && end >= time[0] || start <= time[1] && end > time[1])
                {
                    if (start < time[0]) time[0] = start;
                    if (end > time[1]) time[1] = end;
                    combined = true;
                }
                else if (start >= time[0] && end <= time[1])
                    combined = true;
            }
            if (!combined)
                times.add(new int[] { start, end });
        }
        // calculate max milking time
        int maxMilk = 0;
        int maxMiss = 0;
        for (int i = 0; i < times.size(); i++)
        {
            System.out.println(times.get(i)[0] + ", " + times.get(i)[1]);
            maxMilk = Math.max(times.get(i)[1] - times.get(i)[0], maxMilk);
            if (i != times.size() - 1) maxMiss = Math.max(times.get(i + 1)[0] - times.get(i)[1], maxMiss);
        }
        System.out.println(times.size());
        writer.println(maxMilk + " " + maxMiss);
        reader.close();
        writer.close();
        System.exit(0);
    }
}
