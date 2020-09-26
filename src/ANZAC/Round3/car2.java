package ANZAC.Round3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class car2
{
    static int cnt;
    static int[][] matrix;
    static int[] reached;
    static int[] trapped;

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        cnt = Integer.parseInt(reader.readLine());
        matrix = new int[cnt][cnt];
        reached = new int[cnt];
        trapped = new int[cnt];

        for (int i = 0; i < cnt; i++)
        {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int id = Integer.parseInt(st.nextToken());
            int connections = Integer.parseInt(st.nextToken());

            for (int j = 0; j < connections; j++)
                matrix[id][Integer.parseInt(st.nextToken())] = 1;
        }

        testReach(0, new int[cnt]);
        testTrap(0, new int[cnt]);

        for (int i = 1; i < cnt; i++)
        {
            if (trapped[i] == 0)
                System.out.println("TRAPPED " + i);
        }

        for (int i = 1; i < cnt; i++)
        {
            if (reached[i] == 0)
                System.out.println("UNREACHABLE " + i);
        }
    }

    static void testReach(int from, int[] checked)
    {
        reached[from] = 1;
        checked[from] = 1;

        for (int i = 0; i < cnt; i++)
        {
            if (matrix[from][i] == 1 && checked[i] == 0)
                testReach(i, checked);
        }
    }

    static void testTrap(int from, int[] checked)
    {
        trapped[from] = 1;
        checked[from] = 1;

        for (int i = 0; i < cnt; i++)
        {
            if (matrix[i][from] == 1 && checked[i] == 0)
                testTrap(i, checked);
        }
    }
}

/*


6
0 1 1
1 1 2
2 3 1 3 0
3 0
4 2 5 0
5 1 4


*/ 
