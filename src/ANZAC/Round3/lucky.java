package ANZAC.Round3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class lucky
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (!(input = reader.readLine()).equals("-1"))
        {
            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            char b = st.nextToken().charAt(0);

            int largest = -1;
            String output = "";

            for (int i = 2; i <= 10; i++)
            {
                String base = Integer.toString(a, i);
                int large = getCnt(base, b);
                if (large >= largest)
                {
                    largest = large;
                    output = base;
                }
            }
            System.out.println(output);
        }

    }

    public static int getCnt(String s, char num)
    {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == num) cnt++;
        return cnt;
    }

}
