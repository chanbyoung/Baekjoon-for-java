import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int[] arr= new int[N+1];
        for(int i= 1; i<= N; i++) { // 누적합을 배열에 이미 넣어둔다
            arr[i] = arr[i-1]+Integer.parseInt(st.nextToken());
        }
        for(int i= 0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a =Integer.parseInt(st.nextToken())-1;
            int b =Integer.parseInt(st.nextToken());
            System.out.println(arr[b]-arr[a]);
        }
    }
}