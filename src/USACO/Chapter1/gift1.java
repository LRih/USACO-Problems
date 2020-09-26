/*
ID: richard78
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.StringTokenizer;

public class gift1
{
    static int numberPeople;
    static String[] names;
    static int[] initialMoney;
    static int[] receiveMoney;
    public static void main(String[] args) throws IOException
    {
        // file
        BufferedReader reader = new BufferedReader(new FileReader("gift1.in"));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        // variables
        numberPeople = Integer.parseInt(tokenizer.nextToken());
        names = new String[numberPeople];
        initialMoney = new int[numberPeople];
        receiveMoney = new int[numberPeople];
        // get names
        for (int i = 0; i < numberPeople; i++)
            names[i] = reader.readLine();
        // transactions
        String name;
        while ((name = reader.readLine()) != null)
        {
            int giverIndex = getNameIndex(name);
            tokenizer = new StringTokenizer(reader.readLine());
            initialMoney[giverIndex] = Integer.parseInt(tokenizer.nextToken());
            int receiveCount = Integer.parseInt(tokenizer.nextToken());
            for (int i = 0; i < receiveCount; i++)
            {
                int splitMoney = initialMoney[giverIndex] / receiveCount;
                int receiverIndex = getNameIndex(reader.readLine());
                receiveMoney[receiverIndex] += splitMoney;
                receiveMoney[giverIndex] -= splitMoney;
            }
        }
        // output
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
        for (int i = 0; i < numberPeople; i++)
        {
            String printLine = names[i] + " " + (receiveMoney[i]);
            writer.println(printLine);
            System.out.println(printLine);
        }
        reader.close();
        writer.close();
    }

    public static int getNameIndex(String name)
    {
        for (int i = 0; i < numberPeople; i++)
            if (names[i].equals(name)) return i;
        return -1;
    }
}
