package ANZAC.Round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class please_go_first
{

    static int countTime(String order)
    {
        String group = "";

        int total = 0;

        for (int j = 0; j < order.length(); j++)
        {
            int last = order.lastIndexOf(order.charAt(j));

            if (group.indexOf(order.charAt(j)) == -1)
                group += order.charAt(j);
            total += (last - j + 1) * 5;
        }

        return total;
    }

    static String sortQueue(String order)
    {
        String group = "";

        for (int i = 0; i < order.length(); i++)
            if (group.indexOf(order.charAt(i)) == -1)
                group += order.charAt(i);

        String newOrder = "";

        for (int i = 0; i < group.length(); i++)
            for (int j = 0; j < order.length(); j++)
                if (order.charAt(j) == group.charAt(i))
                    newOrder += order.charAt(j);

        return newOrder;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int cases = Integer.parseInt(reader.readLine());
        String[] queue = new String[25000];

        for (int i = 0; i < cases; i++)
        {
            int n = Integer.parseInt(reader.readLine());

            queue[i] = reader.readLine();
        }

        for (int i = 0; i < cases; i++)
        {
            int orgTime = countTime(queue[i]);
            String newOrder = sortQueue(queue[i]);
            int newTime = countTime(newOrder);
            System.out.println(orgTime - newTime);
        }
    }

}
