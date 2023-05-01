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
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i<=N; i++){
            list.add(i);
        }
        int[] arr = new int[N];
        int k = K;
        K -=1;
        for(int i = 0; i<N; i++){
            int cnt = 0;
            while(K>=list.size()){
                K -= list.size();
            }
            arr[i] = list.remove(K);
            K += k-1; // 인덱스가 하나씩 줄어드므로 1씩 빼준다

        }
        System.out.print("<");
        for(int i=0; i<N; i++){
            if(i == N-1){
                System.out.print(arr[N-1]);
                break;
            }
            System.out.print(arr[i]+", ");
        }
        System.out.print(">");
    }
}


