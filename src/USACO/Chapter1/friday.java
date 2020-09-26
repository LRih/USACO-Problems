/*
ID: richard78
LANG: JAVA
TASK: friday
*/

import java.io.*;

public class friday
{
    public static void main(String[] args) throws IOException
    {
        // file
        BufferedReader reader = new BufferedReader(new FileReader("friday.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int day = 2;
        int endYear = 1900 + Integer.parseInt(reader.readLine()) - 1;
        int[] thirteenCounts = new int[7]; // sat, sun, ...
        // algorithm
        for (int year = 1900; year <= endYear; year++)
        {
            for (int month = 1; month <= 12; month++)
            {
                int numberOfDays = getNumberOfDays(year, month);
                for (int date = 1; date <= numberOfDays; date++)
                {
                    if (date == 13) thirteenCounts[day]++;
                    day = ((day + 1) % 7);
                }
            }
        }
        for (int i = 0; i < thirteenCounts.length; i++)
        {
            if (i != 0) writer.print(" ");
            writer.print(thirteenCounts[i]);
        }
        writer.println();
        reader.close();
        writer.close();
    }

    public static int getNumberOfDays(int year, int month)
    {
        switch (month)
        {
            case 4:
            case 6:
            case 9:
            case 11: return 30;
            case 2: return (isLeapYear(year) ? 29 : 28);
            default: return 31;
        }
    }

    public static boolean isLeapYear(int year)
    {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
