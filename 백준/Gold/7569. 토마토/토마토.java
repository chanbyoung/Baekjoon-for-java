import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int M, N, H;
    static int[][][] map;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] cx = {1,0,-1,0};
    static int[] cy = {0,1,0,-1};

    public static int bfs() {
        while (!queue.isEmpty()) {
            int h = queue.peek()[0];
            int x = queue.peek()[1];
            int y = queue.peek()[2];
            queue.poll();
            if (H > h + 1) {
                if (map[h + 1][x][y] == 0) {
                    queue.add(new int[]{h + 1, x, y});
                    map[h + 1][x][y] = map[h][x][y] + 1;
                }
            }
            if (h - 1 >= 0) {
                if (map[h - 1][x][y] == 0) {
                    queue.add(new int[]{h - 1, x, y});
                    map[h - 1][x][y] = map[h][x][y] + 1;
                }
            }
            for (int i = 0; i < 4; i++) {
                int X = x + cx[i];
                int Y = y + cy[i];
                if (X >= 0 && Y >= 0 && X < N && Y < M) {
                    if (map[h][X][Y] == 0) {
                        queue.add(new int[]{h, X, Y});
                        map[h][X][Y] = map[h][x][y] + 1;
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        if (zero()) {
            return -1;
        } else {
            for (int k = 0; k < H; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (max < map[k][i][j]) {
                            max = map[k][i][j];
                        }
                    }
                }
            }
            return max - 1;
        }
    }


    private static boolean zero() {
        for(int k =0; k<H; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[k][i][j] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        for(int i=0; i<H; i++){
            for(int j =0; j<N; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k=0; k<M; k++){
                    int tomato = Integer.parseInt(st.nextToken());
                    map[i][j][k] = tomato;
                    if(tomato==1){
                        queue.add(new int[]{i,j,k});
                    }
                }
            }
        }
        System.out.println(bfs());

    }
}