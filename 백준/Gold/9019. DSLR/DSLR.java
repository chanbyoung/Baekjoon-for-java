import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static String[] map ;
    static boolean[] visit;
    static int A,B;

    public static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(A);
        map[A] = "";
        visit[A] = true;

        while (!queue.isEmpty()&& !visit[B]){
            int q = queue.poll();
            //D연산
            if(visit[q*2%10000] == false) {
                queue.add(q*2%10000);
                map[q * 2 % 10000] = map[q] + "D";
                visit[q*2%10000] = true;
            }

            //S연산
            int S = (q==0) ? 9999 : q-1;
            if(visit[S]==false) {
                queue.add(S);
                map[S] = map[q] + "S";
                visit[S] = true;
            }
            //L연산
            int L = (q%1000)*10+q/1000;
            if(visit[L]==false) {
                queue.add(L);
                map[L] = map[q] + "L";
                visit[L] = true;
            }
            //R연산
            int R = (q%10)*1000+q/10;
            if(visit[R]==false) {
                queue.add(R);
                map[R] = map[q] + "R";
                visit[R] = true;
            }
        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            visit = new boolean[10000];
            map = new String[10000];
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            bfs();
            System.out.println(map[B]);
        }
    }
}