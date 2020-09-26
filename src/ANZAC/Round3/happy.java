package ANZAC.Round3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class happy
{
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException
    {
        list = new ArrayList<Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());
        boolean[] answer = new boolean[count];
        int[] numbs = new int[count];

        for (int i = 0; i < count; i++)
        {
            String tmp = reader.readLine();
            StringTokenizer st = new StringTokenizer(tmp);
            st.nextToken();
            int number = Integer.parseInt(st.nextToken());
            numbs[i] = number;
            if (!isPrime(number) || number == 1)
                answer[i] = false;
            else if (answer[i] = analyse(number + ""))
                list = new ArrayList<Integer>();
        }

        for (int i = 0; i < count; i++)
        {
            String ans = (answer[i] ? "YES" : "NO");
            System.out.println((i + 1) + " " + numbs[i] + " " + ans);
        }
    }

    static boolean isPrime(int n)
    {
        for (int i = n - 1; i > 1; i--)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    static boolean analyse(String n)
    {
        int temp = Integer.parseInt(n);

        if (n.equals("1"))
            return true;
        if (list.contains(temp))
            return false;
        else
        {
            list.add(temp);
            int count = 0;
            for (int i = 0; i < n.length(); i++)
            {
                int t = Integer.parseInt(n.charAt(i) + "");
                count += t * t;
            }
            return analyse(count + "");
        }
    }
}
