import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N, M;
    static int cnt = 0;

    public static void bfs(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        visit[0][0] = true;
        while(!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();
            for(int i=0; i<4; i++){
                int cx = x + dx[i];
                int cy = y + dy[i];
                if(cx>=0 && cy>=0 && cx<N && cy<M){
                    if(visit[cx][cy] == false && map[cx][cy] !=0){
                        queue.add(new int[]{cx, cy});
                        map[cx][cy] = map[x][y]+1;
                        visit[cx][cy] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i<N; i++){
            String[] arr = br.readLine().split("");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        bfs();
        System.out.println(map[N-1][M-1]);


    }
}