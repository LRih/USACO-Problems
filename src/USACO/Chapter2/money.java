package USACO.Chapter2;/*
ID: richard78
LANG: JAVA
TASK: money
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class money
{
    public static long[][] cache;
	public static int[] money;
    public static int coinCount;
    public static int targetSum;
    public static long answer;
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("money.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        coinCount = Integer.parseInt(tokenizer.nextToken());
        targetSum = Integer.parseInt(tokenizer.nextToken());
        money = new int[coinCount];
        // initialize cache
        cache = new long[targetSum + 1][coinCount + 1];
        for (int y = 0; y < coinCount + 1; y++)
        {
            for (int x = 0; x < targetSum + 1; x++)
                cache[x][y] = -1;
        }

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < coinCount; i++)
        {
            if (!tokenizer.hasMoreTokens())
                tokenizer = new StringTokenizer(reader.readLine());
            money[i] = Integer.parseInt(tokenizer.nextToken());
        }
        Arrays.sort(money);

        answer = search(0, 0);

        System.out.println(answer);
        writer.println(answer);
        
        reader.close();
        writer.close();
        System.exit(0);
    }

    public static long search(int sum, int currentIndex)
    {
        long answer = 0;
        for (int i = currentIndex; i < coinCount; i++)
        {
            int newSum = sum + money[i];
            if (newSum == targetSum)
                answer++;
            else if (newSum < targetSum)
            {
                if (cache[newSum][i] == -1) cache[newSum][i] = search(newSum, i); // stores answer for [newSum, i] in cache if hasn't been stored already
                answer += cache[newSum][i];
            }
        }
        return answer;
    }
}