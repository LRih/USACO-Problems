/*
ID: richard78
LANG: JAVA
TASK: barn1
*/

import java.io.*;
import java.util.*;

public class barn1
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("barn1.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int maxBoards = Integer.parseInt(tokenizer.nextToken());
        int[] occupiedList = new int[Integer.parseInt(tokenizer.nextToken())];
        List<int[]> emptySpans = new ArrayList<int[]>();
        String line;
        while ((line = reader.readLine()) != null)
        {
            occupiedList[Integer.parseInt(line) - 1] = 1;
        }
        // trim edge
        for (int i = 0; occupiedList[i] != 1; i++)
            occupiedList[i] = 2;
        for (int i = occupiedList.length - 1; occupiedList[i] != 1; i--)
            occupiedList[i] = 2;
        // get empty spans
        int lastValue = 2;
        int emptyStart = 0;
        int emptySpan = 0;
        for (int i = 0; i < occupiedList.length; i++)
        {
            System.out.print(occupiedList[i]);
            if (occupiedList[i] == 2) // not yet reached first 1
                continue;
            else if (occupiedList[i] == 1 && lastValue == 0)
                emptySpans.add(new int[] { emptyStart, emptySpan });
            else if (occupiedList[i] == 0 && lastValue == 1)
            {
                emptyStart = i;
                emptySpan = 1;
            }
            else if (occupiedList[i] == 0 && lastValue == 0)
                emptySpan++;
            lastValue = occupiedList[i];
        }
        Collections.sort(emptySpans, new Comparator<int[]>()
        {
            public int compare(int[] o1, int[] o2)
            {
                return o2[1] - o1[1];
            }
        });
        if (maxBoards <= emptySpans.size()) emptySpans = emptySpans.subList(0, maxBoards - 1);
        Collections.sort(emptySpans, new Comparator<int[]>()
        {
            public int compare(int[] o1, int[] o2)
            {
                return o1[0] - o2[0];
            }
        });
        System.out.println();
        for (int[] item : emptySpans)
            System.out.println(item[0] + ", " + item[1]);
        // count stalls
        boolean isBoarding = false;
        int coveredStalls = 0;
        for (int i = 0; i < occupiedList.length; i++)
        {
            if (occupiedList[i] == 2)
                isBoarding = false;
            else if (containsStall(i, emptySpans))
                isBoarding = false;
            else if (occupiedList[i] == 1)
                isBoarding = true;
            if (isBoarding) coveredStalls++;
            if (isBoarding) occupiedList[i] = 8;

        }
        for (int i = 0; i < occupiedList.length; i++)
        {
            System.out.print(occupiedList[i]);
        }
        System.out.println();
        System.out.println(coveredStalls);
        writer.println(coveredStalls);

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static boolean containsStall(int stall, List<int[]> list)
    {
        for (int[] listItem : list)
        {
            if (listItem[0] == stall) return true;
        }
        return false;
    }
}
