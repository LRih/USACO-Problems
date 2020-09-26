package com.round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Grachten
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = new String[25000];
        String[] result = new String[25000];
        int count = 0;

        String tmp;
        while ((tmp = reader.readLine()) != null)
        {
            input[count] = tmp;
            count++;
        }

        for (int n = 0; n < count; n++)
        {
            StringTokenizer st = new StringTokenizer(input[n]);
            int ac = Integer.parseInt(st.nextToken());
            int ab = Integer.parseInt(st.nextToken());
            int bd = Integer.parseInt(st.nextToken());

            int x = ab * ac;
            int y = bd - ab;

            // fraction function
            if (x > y)
            {
                for (int i = y; y > 1; i--)
                {
                    if (x % i == 0 && y % i == 0)
                    {
                        x /= i;
                        y /= i;
                        break;
                    }
                }
            }
            else if (y > x)
            {
                for (int i = x; x > 1; i--)
                {
                    if (x % i == 0 && y % i == 0)
                    {
                        x /= i;
                        y /= i;
                        break;
                    }
                }
            }

            result[n] = x + "/" + y;
        }

        for (int n = 0; n < count; n++)
            System.out.println(result[n]);
        reader.close();
    }
}
