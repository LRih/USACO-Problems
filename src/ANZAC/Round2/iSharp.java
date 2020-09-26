package ANZAC.Round2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class iSharp
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();

        input = input.substring(0, input.length() - 1);

        int firstspcinx = input.indexOf(' ');

        String mainType = input.substring(0, firstspcinx);

        String[] vars = input.substring(firstspcinx).replace("]", "").split(",");
        String[] names = new String[vars.length];
        String[] subtypes = new String[vars.length];

        for (int n = 0; n < vars.length; n++)
            subtypes[n] = "";

        for (int n = 0; n < vars.length; n++)
        {
            for (int i = vars[n].length() - 1; i >= 0; i--)
            {
                if (vars[n].charAt(i) == '*' || vars[n].charAt(i) == '&' || vars[n].charAt(i) == '[')
                    subtypes[n] += vars[n].charAt(i);
                else
                {
                    names[n] = vars[n].substring(0, i + 1);
                    break;
                }
            }
        }

        for (int n = 0; n < vars.length; n++)
            System.out.println(mainType + subtypes[n].replace("[", "[]") + names[n] + ";");

    }
}
