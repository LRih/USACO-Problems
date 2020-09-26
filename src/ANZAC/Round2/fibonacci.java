package ANZAC.Round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class fibonacci
{
    static long f(long n)
    {
        long f = 0;
        if (n == 0 || n == 1)
            return 1;

        long f0 = 1;
        long f1 = 1;

        for (int i = 2; i <= n; i++)
        {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }

        return f;
    }

    static String genF(long n)
    {
        String s = "";

        while (n >= 1)
        {
            for (long i = n; i > 0; i--)
            {
                if (n >= f(i))
                {
                    n = n - f(i);
                    s += "1";
                }
                else
                    s += "0";
            }
        }

        while (s.charAt(0) == '0')
            s = s.substring(1, s.length());

        return s;
    }

    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());

        String result = "";
        for (int i = 1; i < input; i++)
            result += genF(i);

        int count = 0;
        for (int i = 0; i < input; i++)
            if (result.charAt(i) == '1')
                count++;
        System.out.println(result);
        System.out.println(count);
    }

}
