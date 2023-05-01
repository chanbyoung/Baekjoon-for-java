import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i<N ; i++){
            String[] cmd = br.readLine().split(" ");
            if(cmd[0].equals("push")){
                stack.push(Integer.valueOf(cmd[1]));
            }
            else if (cmd[0].equals("pop")) {
                if(stack.empty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.pop());
                }
            }
            else if (cmd[0].equals("size")) {
                System.out.println(stack.size());
            }
            else if(cmd[0].equals("empty")){
                if(stack.empty()){
                    System.out.println(1);
                }
                else System.out.println(0);
            }
            else if(cmd[0].equals("top")) { // top
                if (stack.empty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }
            else continue;
        }
    }
}