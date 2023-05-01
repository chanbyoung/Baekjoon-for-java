import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> card = new LinkedList<>();
        for(int i=1; i<=N; i++) card.add(i);
        int cnt =0;
        while(card.size()>1){
            if(cnt%2==0){
                card.remove();
                cnt ++;
            }
            else{
                int n = card.remove();
                cnt ++;
                card.add(n);
            }
        }
        System.out.println(card.peek());
    }
}