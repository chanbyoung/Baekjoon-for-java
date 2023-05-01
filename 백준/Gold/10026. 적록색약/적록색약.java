import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String map[][];
    static boolean visit[][];
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N;
    static Queue<int[]> queue = new LinkedList<>();

    static void bfs(int i, int j, String word){
        queue.add(new int[]{i,j});
        visit[i][j]= true;
        while (!queue.isEmpty()){
            int x=queue.peek()[0];
            int y=queue.peek()[1];
            queue.poll();
            for(int k = 0; k<4; k++){
                int cx = x+dx[k];
                int cy = y+dy[k];
                if(cx>=0 && cy>=0 && cx<N &&cy<N){
                    if(map[cx][cy].equals(word) && !visit[cx][cy]){
                        queue.add(new int[]{cx,cy});
                        visit[cx][cy]=true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new String[N][N];
        visit = new boolean[N][N];
        for(int i =0; i<N; i++){
            String[] st= br.readLine().split("");
            for(int j=0; j<N; j++){
                map[i][j] = st[j];
            }
        }
        int rgbCnt=0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j].equals("R") && !visit[i][j]){
                    bfs(i,j,"R");
                    rgbCnt++;
                }
                if(map[i][j].equals("G") && !visit[i][j]){
                    bfs(i,j,"G");
                    rgbCnt++;
                }
                if(map[i][j].equals("B") && !visit[i][j]){
                    bfs(i,j,"B");
                    rgbCnt++;
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0;j<N;j++){
                if(map[i][j].equals("G")){
                    map[i][j]="R";
                }
                visit[i][j] = false;
            }
        }

        int rbCnt = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j].equals("R") && !visit[i][j]){
                    bfs(i,j,"R");
                    rbCnt++;
                }
                if(map[i][j].equals("B") && !visit[i][j]){
                    bfs(i,j,"B");
                    rbCnt++;
                }
            }
        }

        System.out.print(rgbCnt+" "+rbCnt);

    }
}