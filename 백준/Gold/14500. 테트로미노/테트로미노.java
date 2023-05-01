import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[][] map;
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];
        for(int i =0 ; i<N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visit[i][j] = true;
                solve(i,j,map[i][j],1);
                visit[i][j] = false;
            }
        }
        System.out.println(max);;
    }
    static void solve(int x, int y, int sum, int cnt){
        if(cnt == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int cX = x + dx[i];
            int cY = y + dy[i];
            if(cX>=0 && cY>=0 && cX<N && cY<M){
               if(!visit[cX][cY]){
                   if(cnt == 2){
                       visit[cX][cY] = true;
                       solve(x,y,sum+map[cX][cY], cnt+1);
                       visit[cX][cY] = false;
                   }
                   visit[cX][cY] = true;
                   solve(cX, cY, sum+map[cX][cY], cnt+1);
                   visit[cX][cY] = false;
               }
            }
        }
    }

}