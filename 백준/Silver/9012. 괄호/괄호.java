import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i< N ; i++) {
            Stack<String> stack = new Stack<>();
            String[] vps = br.readLine().split("");
            for (String vp : vps) {
                if(vp.equals("(")){
                    stack.push("(");
                }
                else {
                    if(stack.empty()){
                        stack.push("0");
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.empty()){
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }



    }

}

