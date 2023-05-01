import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int map[][];
    static int N, M, cnt;
    static int[] cx = {1, 0, -1, 0};
    static int[] cy = {0, 1, 0, -1};
    static Queue<int[]> queue = new LinkedList<>();


    public static int bfs() {
        while (!queue.isEmpty()) {
            int x = queue.peek()[0];
            int y = queue.peek()[1];
            queue.poll();
            for (int i = 0; i < 4; i++) {
                int X = x + cx[i];
                int Y = y + cy[i];
                if (X >= 0 && Y >= 0 && X < N && Y < M) {
                    if (map[X][Y] == 0) {
                        queue.add(new int[]{X, Y});
                        map[X][Y] = map[x][y] + 1;
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        if (zero()) {
            return -1;
        } else {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (max < map[i][j]) {
                        max = map[i][j];
                    }
                }
            }
            return max - 1;
        }
    }






    private static boolean zero() {
        for(int i =0; i<N; i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); //가로 크기
        N = Integer.parseInt(st.nextToken()); //세로 크기
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                map[i][j]= tomato;
                if(tomato == 1){
                    queue.add(new int[]{i,j});
                }
            }
        }
        System.out.println(bfs());
    }
}

