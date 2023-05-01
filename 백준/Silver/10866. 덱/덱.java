import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<N; i++){
            String[] str = br.readLine().split(" ");
            if(str[0].equals("push_front")){
                deque.addFirst(Integer.parseInt(str[1]));
            } else if (str[0].equals("push_back")) {
                deque.addLast(Integer.parseInt(str[1]));
            } else if (str[0].equals("pop_front")) {
                if(deque.isEmpty()){
                    System.out.println(-1);
                }
                else {
                    System.out.println(deque.pollFirst());
                }
            }
            else if (str[0].equals("pop_back")) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollLast());
                }
            } else if (str[0].equals("size")) {
                System.out.println(deque.size());
            } else if (str[0].equals("empty")) {
                if(deque.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
            else if(str[0].equals("front")) {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekFirst());
            }
            else {
                if(deque.isEmpty()) System.out.println(-1);
                else System.out.println(deque.peekLast());
            }
        }
    }
}