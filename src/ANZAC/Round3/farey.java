package ANZAC.Round3;

import Utils.ANZACUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class farey
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(reader.readLine());
//        int cnt = 1;

        for (int i = 0; i < cnt; i++)
        {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            st.nextToken();
            int n = Integer.parseInt(st.nextToken());
//            int n = 80;

            List<int[]> fracs = getFractions(n);
            List<int[]> fareyFracs = getFareyFractions(fracs);

            BigInteger[] curFrac = { new BigInteger("0"), new BigInteger("1") };

            for (int[] fareyFrac : fareyFracs)
                fracAdd(curFrac, new BigInteger(String.valueOf(fareyFrac[0])), new BigInteger(String.valueOf(fareyFrac[1])));

            fracSimplify(curFrac);

            System.out.println((i + 1) + " " + curFrac[0] + "/" + curFrac[1]);
        }
    }

    public static List<int[]> getFractions(int n)
    {
        List<int[]> res = new ArrayList<int[]>();

        for (int b = 0; b <= n; b++)
            for (int a = 0; a <= b; a++)
                if (ANZACUtils.isRelativePrime(a, b))
                    res.add(new int[]{ a, b });

        Collections.sort(res, new Comparator<int[]>()
        {
            public int compare(int[] f1, int[] f2)
            {
                return f1[0] * f2[1] - f1[1] * f2[0];
            }
        });

        return res;
    }

    public static List<int[]> getFareyFractions(List<int[]> fractions)
    {
        List<int[]> res = new ArrayList<int[]>();

        for (int i = 0; i < fractions.size() - 1; i++)
        {
            int[] f1 = fractions.get(i);
            int[] f2 = fractions.get(i + 1);

            res.add(new int[]{ f1[1], f2[1] });
        }

        return res;
    }

    public static void fracSimplify(BigInteger[] frac)
    {
        BigInteger gcd = getGCD(frac[0], frac[1]);
        frac[0] = frac[0].divide(gcd);
        frac[1] = frac[1].divide(gcd);
    }

    public static void fracAdd(BigInteger[] res, BigInteger a, BigInteger b)
    {
        res[0] = res[0].multiply(b).add(res[1].multiply(a));
        res[1] = res[1].multiply(b);
    }

    public static BigInteger getGCD(BigInteger a, BigInteger b)
    {
        if (b.equals(new BigInteger("0"))) return a;
        return getGCD(b, a.mod(b));
    }
}
