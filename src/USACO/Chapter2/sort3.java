package USACO.Chapter2;

/*
ID: richard78
LANG: JAVA
TASK: sort3
*/

import java.io.*;
import java.util.Arrays;

public class sort3
{
    public static int[] values;
    public static int[] rankStartIndexes = new int[4];
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("sort3.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
        values = new int[Integer.parseInt(reader.readLine())];
        for (int i = 0; i < values.length; i++)
        {
            values[i] = Integer.parseInt(reader.readLine());
            for (int j = values[i]; j < 4; j++)
                rankStartIndexes[j]++;
        }
        System.out.println("rank start: " + Arrays.toString(rankStartIndexes));

        int swapCount = 0;
        for (int i = 0; i < values.length; i++)
        {
            int sourceRank = values[i];
            if (isRankInTarget(sourceRank, i)) continue;
            int targetRank = getTargetRankAtIndex(i);
            System.out.println(Arrays.toString(values) + ", " + "look for rank: " + targetRank + " at index: " + i);
            int j = getSwapIndex(sourceRank, targetRank, i);
            int temp = values[i];
            values[i] = values[j];
            values[j] = temp;
            swapCount++;
        }
        System.out.println(Arrays.toString(values));

        writer.println(swapCount);
        System.out.println(swapCount);

        reader.close();
        writer.close();
        System.exit(0);
    }


    public static boolean isRankInTarget(int rank, int index)
    {
        return (index >= rankStartIndexes[rank - 1] && index < rankStartIndexes[rank]);
    }
    public static int getTargetRankAtIndex(int index)
    {
        for (int rank = 0; rank < rankStartIndexes.length; rank++)
        {
            if (index < rankStartIndexes[rank]) return rank;
        }
        return -1;
    }

    public static int getSwapIndex(int sourceRank, int targetRank, int startIndex)
    {
        int secondChoice = -1;
        for (int i = startIndex; i < values.length; i++)
        {
            int rank = values[i];
            if (isRankInTarget(rank, i)) continue;
            if (rank == targetRank)
            {
                if (isRankInTarget(sourceRank, i))
                    return i;
                else
                    secondChoice = i;
            }
        }
        return secondChoice;
    }
}
