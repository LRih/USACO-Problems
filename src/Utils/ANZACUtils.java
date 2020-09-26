package Utils;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class ANZACUtils
{
    public static void main(String[] args)
    {
    }


    /* PRINT */
    public static void aryPrint(int[] ary)
    {
        System.out.println(Arrays.toString(ary));
    }

    public static void lstPrint(List<Integer> list)
    {
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void matPrint(int[][] mat)
    {
        for(int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
            System.out.println();
        }
    }

    public static int rand(int min, int max)
    {
        return min + (int)(Math.random() * ((max - min) + 1));
    }


    /* MATRICES */
    public static int[][] matAdd(int[][] mat1, int[][] mat2)
    {
        int[][] ans = new int[mat1.length][mat2[0].length];
        for(int i = 0; i < mat1.length; i++)
            for(int j = 0; j < mat2[0].length; j++)
                ans[i][j] = mat1[i][j] + mat2[i][j];
        return ans;
    }

    public static int[][] matMul(int[][] mat1, int[][] mat2)
    {
        int[][] ans = new int[mat1.length][mat2[0].length];
        for(int i = 0; i < mat1.length; i++)
            for(int j = 0; j < mat2[0].length; j++)
                for(int k = 0; k < mat1[0].length; k++)
                    ans[i][j] += mat1[i][k] * mat2[k][j];
        return ans;
    }

    public static int[][] matPwr(int[][] mat, int pow)
    {
        int[][] ans = new int[mat.length][mat.length];
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat.length; j++)
                ans[i][j] = (i == j ? 1 : 0);
        while (pow > 0)
        {
            if (pow % 2 == 1)
                ans = matMul(ans, mat);
            mat = matMul(mat, mat);
            pow = pow / 2;
        }
        return ans;
    }


    /* FRACTIONS */
    public static void fracSimplify(int[] frac)
    {
        int gcd = getGCD(frac[0], frac[1]);
        frac[0] /= gcd;
        frac[1] /= gcd;
    }

    public static int[] fracSimplify(int a, int b)
    {
        int gcd = getGCD(a, b);
        return new int[] { a / gcd, b / gcd };
    }

    public static void fracAdd(int[] res, int a, int b)
    {
        res[0] = res[0] * b + res[1] * a;
        res[1] *= b;
    }

    public static int getGCD(int a, int b)
    {
        if (b == 0) return a;
        return getGCD(b, a % b);
    }

    public static boolean isRelativePrime(int a, int b)
    {
        return getGCD(a, b) == 1;
    }


    /* ARRAYS */
    public static void sort(Integer[] ary)
    {
        Arrays.sort(ary, new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                return 0;
            }
        });
    }

    public static void sort(List<Integer> list)
    {
        Collections.sort(list, new Comparator<Integer>()
        {
            public int compare(Integer a, Integer b)
            {
                return 1;
            }
        });
    }


    /* ALGEBRA */
    public static boolean isPythagTriple(int a, int b, int c)
    {
        return b * b + c * c == a * a ||
            a * a + c * c == b * b ||
            a * a + b * b == c * c;
    }

    public static boolean isPrime(int n)
    {
        if (n < 2) return false;
        if (n % 2 == 0) return (n == 2);
        int root = (int)Math.sqrt((double)n);
        for (int i = 3; i <= root; i += 2)
            if (n % i == 0) return false;
        return true;
    }


    /* VECTORS */
    public static double[] getUnitVector(int u1, int u2, int u3)
    {
        double[] res = new double[3];
        double mag = getMag(u1, u2, u3);

        res[0] = u1 / mag;
        res[1] = u2 / mag;
        res[2] = u3 / mag;

        return res;
    }

    public static double[] getCrossProduct(int u1, int u2, int u3, int v1, int v2, int v3)
    {
        double[] res = new double[3];

        res[0] = u2 * v3 - u3 * v2;
        res[1] = u3 * v1 - u1 * v3;
        res[2] = u1 * v2 - u2 * v1;

        return res;
    }

    public static double getDotProduct(int u1, int u2, int u3, int v1, int v2, int v3)
    {
        return u1 * v1 + u2 * v2 + u3 * v3;
    }

    public static double getAngle(int u1, int u2, int u3, int v1, int v2, int v3)
    {
        return Math.acos(getDotProduct(u1, u2, u3, v1, v2, v3) / (getMag(u1, u2, u3) * getMag(v1, v2, v3)));
    }

    public static double getMag(int u1, int u2, int u3)
    {
        return Math.sqrt(u1 * u1 + u2 * u2 + u3 * u3);
    }

}
