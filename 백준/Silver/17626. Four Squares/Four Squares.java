import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        arr[1] = 1;
        for(int i = 2; i<=N; i++){
            int min = Integer.MAX_VALUE;
            for(int j=1; j*j<=i; j++) min = Math.min(min, arr[i-j*j]);
            arr[i] = min + 1;
        }
        System.out.println(arr[N]);
    }
}