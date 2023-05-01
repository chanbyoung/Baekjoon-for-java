import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0){
            String[] cmd = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String num = br.readLine();
            Deque<Integer> deque = new LinkedList<>();
            boolean flag = true;
            if(n>0) {
                num = num.substring(1, num.length()-1);
                String[] numArr = num.split(",");
                for (int i = 0; i < numArr.length; i++) deque.add(Integer.parseInt(numArr[i]));
            }
            boolean rFlag = false;
            for(int i=0; i<cmd.length; i++){
                if(cmd[i].equals("R")){
                    if(rFlag == false) rFlag = true;
                    else rFlag = false;
                }
                else { //D가 들어 왔을 때
                    if(deque.isEmpty()) {
                        flag=false;
                        break;
                    }
                    if(rFlag){
                        deque.pollLast();
                    }
                    else deque.poll();
                }
            }
            if(flag){
                if(deque.isEmpty()){
                    sb.append("[]"+"\n");
                }
                else {
                    sb.append("[");
                    int K = deque.size()-1;
                    if(rFlag){
                        for (int i = 0; i < K; i++) {
                            sb.append(deque.removeLast() + ",");
                        }
                        sb.append(deque.remove());
                    }
                    else {
                        for (int i = 0; i < K; i++) {
                            sb.append(deque.remove() + ",");
                        }
                        sb.append(deque.remove());
                    }
                    sb.append("]"+"\n");
                }
            }
            else {
                sb.append("error"+"\n");
            }
        }
        System.out.println(sb);
    }

}