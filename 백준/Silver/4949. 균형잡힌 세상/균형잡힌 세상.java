import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            int cnt = 0;
            String[] line = br.readLine().split("");
            if (line[0].equals(".")) {
                break;
            }
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < line.length; i++) {
                if (line[i].equals("(") || line[i].equals("[")) {
                    stack.push(line[i]);
                }
                if (line[i].equals(")")) {
                    if(stack.empty()){
                        cnt ++;
                        break;
                    }
                    if (stack.pop().equals("(")) {
                        continue;
                    } else {
                        cnt ++;
                        break;
                    }
                }
                if (line[i].equals("]")) {
                    if(stack.empty()){
                        cnt++;
                        break;
                    }
                    if (stack.pop().equals("[")) {
                        continue;
                    }
                    else {
                        cnt++;
                        break;
                    }
                }
            }
            if (stack.size() == 0 && cnt ==0) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}