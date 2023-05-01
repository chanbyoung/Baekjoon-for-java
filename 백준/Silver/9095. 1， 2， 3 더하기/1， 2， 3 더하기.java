import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T -->0) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N + 1];
            arr[1] = 1;
            if(N>1) arr[2] = 2;
            if(N>2) arr[3] = 4;
            if(N>3) {
                for (int i = 4; i <= N; i++) arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
            }
            System.out.println(arr[N]);
        }
    }
}