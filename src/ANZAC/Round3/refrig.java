package ANZAC.Round3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class refrig
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while (!(input = reader.readLine()).equals("END"))
        {
            int[] ary = new int[26];

            for (int i = 0; i < input.length(); i++)
            {
                if (input.charAt(i) == ' ') continue;
                ary[input.charAt(i) - 65]++;
            }

            boolean f = true;
            for (int i = 0; i < 26; i++)
                if (ary[i] > 1) f = false;

            if (f)
                System.out.println(input);
        }
    }
}
