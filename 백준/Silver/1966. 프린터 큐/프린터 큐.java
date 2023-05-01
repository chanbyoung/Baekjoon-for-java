import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i<T; i++) {
            String[] NM = br.readLine().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            String[] arr= br.readLine().split(" ");
            Queue<Integer> num = new LinkedList<>();
            int[] max = new int[N];
            for(int j = 0;j < N; j++){
                num.add(Integer.parseInt(arr[j])); //중요도가 들어있는 num
                max[j] = Integer.parseInt(arr[j]);
            }
            // 값 넣기 완료
            Arrays.sort(max); //중요도의 순서대로 들어있는 max'
            Queue<Integer> maxnum = new LinkedList<>(); // 중요도 queue
            for(int j= max.length-1; j>=0;j--){
                maxnum.add(max[j]);
            }
            int cnt = 0;
            while(true){
                int n = num.poll();
                if(n == maxnum.peek()){
                    cnt ++;
                    if(M == 0){
                        break;
                    }
                    M--;
                    maxnum.poll();
                    //중요도의 값과 num이 담긴 값이 같다면 제거해준다
                }
                else{ // n != maxnum.peek()
                    M--;
                    if(M<0) M = num.size();
                    num.add(n);
                    // 그것이 아니라면 뒤에 중요도 값을 다시 넣어줌
                }
            }
            System.out.println(cnt);


        }
    }
}



