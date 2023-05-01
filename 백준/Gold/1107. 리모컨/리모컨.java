import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        if(M!=0) st = new StringTokenizer(br.readLine());
        boolean[] arr = new boolean[10];
        while (M-- > 0) arr[Integer.parseInt(st.nextToken())] = true;
        int cnt1= Integer.MAX_VALUE;
        for(int i=0; i<=999999;i++){
            String str = String.valueOf(i);
            boolean check = true;
            for(int j =0; j<str.length(); j++){
                if(arr[str.charAt(j)-'0']){
                    check = false; break;
                }
            }
            if(check == false) continue;
            int cnt = str.length() + Math.abs(i-N);
            if(cnt < cnt1){
                cnt1 = cnt;
            }
        }
        int cnt2= Math.abs(100-N);
        int min_cnt= (cnt1>=cnt2) ?cnt2:cnt1;
        System.out.println(min_cnt);
    }

}