import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int num =N-1; //동전이 K값보다 커질때의 인덱스
        for(int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n>K){
                num = i-1;
                break;
            }
            arr[i] = n;
        }
        int cnt = 0;
        while(K != 0){
            cnt += K/arr[num];
            K %= arr[num];
            num --;
        }
        System.out.println(cnt);
    }
}
