import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int cnt = 0;
        while(true){
            if(A>B){
                System.out.println(-1);
                break;
            }
            if(A==B){
                cnt ++;
                System.out.println(cnt);
                break;
            }
            if(B%10 == 1){
                B--;
                B /=10;
            }
            else if(B%2 == 0){
                B/=2;
            }
            else {
                System.out.println(-1);
                break;
            }
            cnt++;
        }

    }
}



