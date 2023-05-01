import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int[] block = new int[N*M];
        int min = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;

        int n = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < M; j++) {
                block[n]= Integer.parseInt(st.nextToken());
                n++;
            }
        }

        int h = 0;
        int cnt = 257;
        while(cnt-->0){
            int one = 0;
            int two = 0;
            for(int i=0; i<N*M; i++){
                int temp = block[i] - h;
                if(temp >0) one += temp;
                else if (temp < 0) two -= temp;
            }
            int time = one*2 + two*1;
            if(time >= 0 && (B+one-two) >= 0){
                if(min >= time && maxH < h){
                    min = time;
                    maxH = h;
                }
            }
            h++;
        }
        System.out.println(min+" "+maxH);

    }
}
