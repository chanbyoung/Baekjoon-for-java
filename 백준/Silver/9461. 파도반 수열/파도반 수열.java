import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            int N = Integer.parseInt(br.readLine());
            long[] dp = new long[N+1];
            dp[1] = 1;
            if(N>1) dp[2] = 1;
            if(N>2) dp[3] = 1;
            if(N>3) for(int i=4; i<=N; i++) dp[i] = dp[i-2] + dp[i-3];
            System.out.println(dp[N]);
        }
    }
}