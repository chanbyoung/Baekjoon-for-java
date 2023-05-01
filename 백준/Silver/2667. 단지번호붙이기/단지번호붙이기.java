import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N, cnt;

    public static void bfs(int x, int y){
        visit[x][y] = true;
        cnt ++;
        for(int i = 0; i<4; i++){
            int cx = x+dx[i];
            int cy = y+dy[i];
            if(cx>=0 && cy>=0 && cx<N &&cy<N){
                if(map[cx][cy]== 1 && !visit[cx][cy]){
                    bfs(cx,cy);
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visit = new boolean[N][N];
        for(int i = 0; i<N; i++){
            String[] arr = br.readLine().split("");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]== 1 && !visit[i][j]){
                    cnt = 0;
                    bfs(i,j);
                    list.add(cnt);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}