import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i=0 ; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int[] max_arr = new int[N];
        max_arr[0] = arr[0];
        if(N>1) max_arr[1] = arr[0]+arr[1];
        if(N>2) max_arr[2] = (arr[0]+arr[2] > arr[1]+arr[2]) ? arr[0]+arr[2] : arr[1]+arr[2];
        if(N>3) {
            for (int i = 3; i < N; i++) {
                max_arr[i] = (max_arr[i - 2] + arr[i] > max_arr[i - 3] + arr[i - 1] + arr[i]) ? max_arr[i - 2] + arr[i] : max_arr[i - 3] + arr[i - 1] + arr[i];
            }
        }
        System.out.println(max_arr[N-1]);
    }
}
