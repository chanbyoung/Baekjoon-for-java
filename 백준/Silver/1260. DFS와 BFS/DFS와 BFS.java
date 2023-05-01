import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    static int N,M,V;
    static int[][] map;
    static boolean[] visit;
    public static void dfs(int v){
        visit[v] = true;
        System.out.print(v+" ");
        for(int i = 1; i<=N; i++){
            if(map[v][i] == 1 && !visit[i]){
                dfs(i);
            }
        }
    }
    public static void bfs(int v){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visit[v] = true;
        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.print(temp+" ");
            for(int i=1; i<=N; i++){
                if(map[temp][i]==1 && !visit[i]){
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visit = new boolean[N+1];
        while(M --> 0){
            st = new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = map[y][x] = 1;
        }
        dfs(V);
        for(int i=1; i<=N; i++) visit[i] =false;
        System.out.println();
        bfs(V);
    }
}