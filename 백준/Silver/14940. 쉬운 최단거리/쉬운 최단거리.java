import java.io.*;
import java.util.*;

class Main {

    static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static boolean[][] visit;
    static int[][] map;
    static int[][] result;
    static Queue<Coordinate> queue= new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n][m];
        map = new int[n][m];
        result = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 2) {
                    visit[i][j] = true;
                    queue.add(new Coordinate(i, j));
                }
            }
        }

        bfs();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1 && result[i][j] == 0) {
                    System.out.print("-1 ");
                }
                else{
                    System.out.print(result[i][j]+" ");
                }
            }
            System.out.println();
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            int x = coordinate.x;
            int y = coordinate.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && !visit[nx][ny]
                        && map[nx][ny] != 0) {
                    result[nx][ny] = result[x][y] + 1;
                    visit[nx][ny] = true;
                    queue.add(new Coordinate(nx, ny));
                }
            }
        }
    }
}