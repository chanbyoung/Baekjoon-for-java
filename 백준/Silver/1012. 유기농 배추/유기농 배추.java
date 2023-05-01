import javax.swing.tree.TreeCellRenderer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int map[][];
    static boolean visit[][];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N, M, K;
    static int count ;

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        while(!queue.isEmpty()){
            x=queue.peek()[0];
            y=queue.peek()[1];
            visit[x][y] = true;
            queue.poll();
            for(int i=0; i<4; i++){
                int cx = x+dx[i];
                int cy = y+dy[i];
                if(cx>=0 && cy>=0 && cx < N && cy< M){
                    if(visit[cx][cy] == false && map[cx][cy] == 1){
                        queue.add(new int[]{ cx, cy });
                        visit[cx][cy] = true;
                    }
                }
            }

        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visit = new boolean[N][M];
            count = 0;
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }


    }
}