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
            long[] arr1 = new long[N+1]; //0이 호출된 개수 배열
            long[] arr2 = new long[N+1]; //0이 호출된 개수 배열
            arr1[0] = 1;
            if(N>0) {
                arr1[1] = 0;
                arr2[1] = 1;
            }
            if(N>1) {
                for(int i= 2; i<=N; i++) {
                    arr1[i]=arr1[i-1]+arr1[i-2];
                    arr2[i]=arr2[i-1]+arr2[i-2];
                }
            }
            System.out.println(arr1[N]+" "+arr2[N]);
        }
    }
}