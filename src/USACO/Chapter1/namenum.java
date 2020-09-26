package USACO.Chapter1;

/*
ID: richard78
LANG: JAVA
TASK: namenum
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class namenum
{
    public static char[] letters = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
                                                'J', 'K', 'L', 'M', 'N', 'O', 'P', 'R', 'S',
                                                'T', 'U', 'V', 'W', 'X', 'Y' };
    public static List<String> dict = new ArrayList<String>();
    public static List<String> names = new ArrayList<String>();
    public static List<char[]> chars = new ArrayList<char[]>();
    public static int nameLength;
    public static void main(String[] args) throws IOException
    {
        // file
        BufferedReader reader = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
        String number = reader.readLine();
        nameLength = number.length();
        // load dictionary
        BufferedReader dictReader = new BufferedReader(new FileReader("dict.txt"));
        String line;
        while ((line = dictReader.readLine()) != null)
        {
            if (nameLength == line.length())
                dict.add(line);
        }
        dictReader.close();
        // get chars
        for (char c : number.toCharArray())
            chars.add(getChar(String.valueOf(c)));
        // get names
        populateNames("", 0);
        // check names
        boolean isFound = false;
        for (String dictEntry : dict)
        {
            if (names.contains(dictEntry))
            {
                writer.println(dictEntry);
                isFound = true;
            }
        }
        if (!isFound) writer.println("NONE");
        reader.close();
        writer.close();
        System.exit(0);
    }
    
    public static void populateNames(String name, int startIndex)
    {
        for (char c : chars.get(startIndex))
        {
            if (!doesAnyDictNameStartWith(name + String.valueOf(c))) continue;
            if (startIndex != nameLength - 1)
                populateNames(name + String.valueOf(c), startIndex + 1);
            else
            {
                names.add(name + String.valueOf(c));
//                System.out.println(name + String.valueOf(c));
            }
        }
    }

    public static boolean doesAnyDictNameStartWith(String start)
    {
        for (String name : dict)
        {
            if (name.startsWith(start)) return true;
        }
        return false;
    }

    public static char[] getChar(String integer)
    {
        return new char[] { letters[3 * (Integer.parseInt(integer) - 2)],
                            letters[3 * (Integer.parseInt(integer) - 2) + 1],
                            letters[3 * (Integer.parseInt(integer) - 2) + 2] };
    }
}
