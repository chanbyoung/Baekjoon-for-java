import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M;
    static boolean[] visit;
    static int[][] map;
    public static void bfs(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visit[i] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            for(int k=1; k<=N; k++){
                if(map[temp][k] == 1 && !visit[k]){
                    queue.add(k);
                    visit[k] = true;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        map = new int[N+1][N+1];
        while(M-->0){
            st= new StringTokenizer(br.readLine()," ");
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        int sum = 0;
        for(int i = 1; i<=N; i++){
            if(!visit[i]){
                bfs(i);
                sum++;
            }
        }
        System.out.println(sum);


    }
}