import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        while(N --> 0) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0){
                if(!queue.isEmpty()){
                    System.out.println(queue.poll());
                }
                else System.out.println(0);
            }
            else queue.add(num);
        }
    }
}