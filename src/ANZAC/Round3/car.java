package ANZAC.Round3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class car
{
    static int cnt;
    static int[] trapped;
    static int[] unreach;

    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(reader.readLine());

        long[][] matrix = new long[cnt][cnt];
        trapped = new int[cnt];
        unreach = new int[cnt];

        for (int i = 0; i < cnt; i++)
        {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int id = Integer.parseInt(st.nextToken());
            int connections = Integer.parseInt(st.nextToken());

            for (int j = 0; j < connections; j++)
                matrix[id][Integer.parseInt(st.nextToken())] = 1;
        }

        long[][] ans = matrix;
        for (int i = 0; i < cnt; i++)
        {
            ans = matMul(ans, matrix);

            for (int j = 0; j < cnt; j++)
                if (ans[j][0] != 0) trapped[j]++;

            for (int j = 0; j < cnt; j++)
                if (ans[0][j] != 0) unreach[j]++;
        }

        boolean flag = false;
        for (int i = 0; i < cnt; i++)
        {
            if (trapped[i] == 0)
            {
                System.out.println("TRAPPED " + i);
                flag = true;
            }
        }

        for (int i = 0; i < cnt; i++)
        {
            if (unreach[i] == 0)
            {
                System.out.println("UNREACHABLE " + i);
                flag = true;
            }
        }

        if (!flag)
            System.out.println("NO PROBLEMS");
    }

    static long[][] matMul(long[][] a, long[][] b)
    {
        long[][] ans = new long[cnt][cnt];
        for (int i = 0; i < cnt; i++)
            for (int j = 0; j < cnt; j++)
                for (int k = 0; k < cnt; k++)
                    ans[i][j] += a[i][k] * b[k][j];
        return ans;
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
