package ANZAC.Round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class kickdown
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String a = reader.readLine();
        String b = reader.readLine();
        int min = 200;
        Boolean flag = true;

        int dif = Math.max(a.length(), b.length()) - Math.min(a.length(), b.length());

        int alen = a.length();
        int blen = b.length();

        String atmp = a;
        String btmp = b;
        for (int i = 0; i <= alen; i++)
        {
            String a1 = atmp;
            String b1 = btmp;

            dif = Math.max(a1.length(), b1.length()) - Math.min(a1.length(), b1.length());
            for (int z = 0; z < dif; z++)
                if (a1.length() > b1.length())
                    b1 += "0";
                else
                    a1 += "0";

            for (int j = 0; j < b1.length(); j++)
            {
                if (a1.charAt(j) == '2' && b1.charAt(j) == '2')
                {
                    flag = false;
                    break;
                }
            }
            if (flag && btmp.length() < min)
                min = Math.min(min, Math.min(a1.length(), b1.length()));
            btmp = "0" + btmp;
            flag = true;
        }

        atmp = a;
        btmp = b;

        for (int i = 0; i <= blen; i++)
        {

            String a1 = atmp;
            String b1 = btmp;

            dif = Math.max(a1.length(), b1.length()) - Math.min(a1.length(), b1.length());
            for (int z = 0; z < dif; z++)
                if (a1.length() > b1.length())
                    b1 += "0";
                else
                    a1 += "0";

            for (int j = 0; j < a1.length(); j++)
            {
                if (a1.charAt(j) == '2' && b1.charAt(j) == '2')
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
                min = Math.min(min, Math.min(a1.length(), b1.length()));
            atmp = "0" + atmp;
            flag = true;
        }
        System.out.println(min);
    }
}
