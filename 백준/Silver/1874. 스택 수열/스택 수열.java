import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<String> result = new Stack<>();
        int cnt =0;
        int max_num=1;
        for(int i = 0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            if(max_num <= num){
                for(int j=max_num ; j<= num; j++){
                    stack.push(j);
                    result.push("+");
                    cnt++;
                }
                stack.pop();
                result.push("-");
                cnt --;
                max_num = num+1; // 이전의 값까지 넣었으므로 +1
            }
            else{
                do{
                    if(stack.pop() == num){
                        result.push("-");
                        cnt --;
                        break;
                    }
                    else {
                        if(cnt > 0 ){
                            break;
                        }
                        result.push("-");
                        cnt --;
                    }
                }while(true);
            }
        }
        if(cnt == 0){ // 스택이 비어있고 cnt 가 0이라면 결과 출력
            for (String s : result) {
                System.out.println(s);
            }
        }
        else {
            System.out.println("NO");
        }
    }
}



