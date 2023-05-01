import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        Stack<Integer> num = new Stack<>();
        for(int i = 0 ; i<K ; i++){
            int n = Integer.parseInt(br.readLine());
            if(n != 0){
                num.push(n);
            }
            else num.pop();
        }
        int sum = 0;
        for (Integer integer : num) {
            sum += integer;
        }
        System.out.println(sum);
    }
}