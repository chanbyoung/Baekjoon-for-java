import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        m = (n-m > m) ? n-m : m;
        BigInteger sum = BigInteger.valueOf(n);
        for(int i=n-1; i>m; i--){
            sum =sum.multiply(BigInteger.valueOf(i));
        }
        BigInteger sum2 = BigInteger.valueOf(n-m);
        for(int i=n-m-1; i>0; i--){
            sum2 = sum2.multiply(BigInteger.valueOf(i));
        }
        BigInteger result = sum.divide(sum2);
        System.out.println(result);

    }

}