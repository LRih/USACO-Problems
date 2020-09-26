package USACO.Chapter2;

/*
ID: richard78
LANG: JAVA
TASK: zerosum
*/

import java.io.*;

public class zerosum
{
    public static int n;
    public static int operatorCount;
    public static String result = "";
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader("zerosum.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));
        n = Integer.parseInt(reader.readLine());
        operatorCount = n - 1;

        search(0, new int[operatorCount]);
        writer.print(result);

        reader.close();
        writer.close();
        System.exit(0);
    }

    public static void search(int index, int[] operators)
    {
        if (index == operatorCount) return;
        for (int state = 0; state < 3; state++)
        {
            int[] newOperators = operators.clone();
            newOperators[index] = state;
            if (index == operatorCount - 1 && getSum(newOperators) == 0)
            {
                String expression = getExpression(newOperators);
                System.out.println(expression);
                result += expression + "\n";
            }
            search(index + 1, newOperators);
        }
    }

    public static int getSum(int[] operators)
    {
        int sum = 0;
        int nextNum = 0;
        int consecutiveSpace = 0;
        for (int i = operatorCount - 1; i >= 0; i--)
        {
            nextNum += (i + 2) * Math.pow(10, consecutiveSpace);
            switch (operators[i])
            {
                case 0:
                    consecutiveSpace++;
                    break;
                case 1:
                    sum += nextNum;
                    consecutiveSpace = 0;
                    nextNum = 0;
                    break;
                case 2:
                    sum -= nextNum;
                    consecutiveSpace = 0;
                    nextNum = 0;
                    break;
            }
        }
        sum += Math.pow(10, consecutiveSpace) + nextNum;
        return sum;
    }

    public static String getExpression(int [] operators)
    {
        String expression = "1";
        for (int i = 2; i <= operatorCount + 1; i++)
        {
            switch (operators[i - 2])
            {
                case 0: expression += " "; break;
                case 1: expression += "+"; break;
                case 2: expression += "-"; break;
            }
            expression += i;
        }
        return expression;
    }
}
