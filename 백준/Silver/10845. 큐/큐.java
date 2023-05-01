import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int last =0;
        for(int i = 0; i<N; i++){
            String[] cmd = br.readLine().split(" ");
            if(cmd[0].equals("push")){
                queue.add(Integer.parseInt(cmd[1]));
                last =Integer.parseInt(cmd[1]);
            } else if (cmd[0].equals("pop")) {
                if(queue.isEmpty()){
                    System.out.println(-1);
                }
                else {
                    System.out.println(queue.remove());
                }
            }
            else if(cmd[0].equals("size")){
                System.out.println(queue.size());
            } else if (cmd[0].equals("empty")) {
                if(queue.isEmpty()){
                    System.out.println(1);
                }
                else System.out.println(0);
            } else if (cmd[0].equals("front")) {
                if (queue.isEmpty()){
                    System.out.println(-1);
                }
                else System.out.println(queue.peek());
            }else if(cmd[0].equals("back")){
                if (queue.isEmpty()){
                    System.out.println(-1);
                }
                else {
                    System.out.println(last);
                }
            }

        }
        }
}



