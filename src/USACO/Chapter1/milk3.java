package USACO.Chapter1;

/*
ID: richard78
LANG: JAVA
TASK: milk3
*/

import java.io.*;
import java.util.*;

public class milk3
{
    public static int[] capacities = new int[3];
    public static List<int[]> visitedStates = new ArrayList<int[]>();
    public static List<Integer> answers = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("milk3.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < capacities.length; i++)
            capacities[i] = Integer.parseInt(tokenizer.nextToken());
        // search
        search(new int[] { 0, 0, capacities[2] });
        Collections.sort(answers);

        System.out.println(Arrays.toString(answers.toArray(new Integer[] {})));

        for (int i = 0; i < answers.size(); i++)
        {
            if (i != 0) writer.print(" ");
            writer.print(answers.get(i));
        }
        writer.println();

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static void search(int[] buckets)
    {
        for (int fromIndex = 0; fromIndex < buckets.length; fromIndex++)
        {
            for (int toIndex = 0; toIndex < buckets.length; toIndex++)
            {
                if (fromIndex == toIndex) continue;
                int[] newState = new int[] { buckets[0], buckets[1], buckets[2] };
                int maxFill = capacities[toIndex] - newState[toIndex];
                int transfer = Math.min(newState[fromIndex], maxFill);
                newState[fromIndex] -= transfer;
                newState[toIndex] += transfer;
                System.out.println(fromIndex + " to " + toIndex + ": " + maxFill + ", " + Arrays.toString(newState));
                if (!isStateExists(newState))
                {
                    System.out.println("new state");
                    if (newState[0] == 0 && !answers.contains(newState[2]))
                        answers.add(newState[2]);
                    visitedStates.add(newState);
                    search(newState);
                }
            }
        }
    }

    public static boolean isStateExists(int[] state)
    {
        for (int[] visitedState : visitedStates)
        {
            if (state[0] == visitedState[0] && state[1] == visitedState[1] && state[2] == visitedState[2]) return true;
        }
        return false;
    }
}
