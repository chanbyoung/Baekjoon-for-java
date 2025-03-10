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
    static String[][] map;
    static int cnt = 0;
    static Queue<Coordinate> queue= new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n][m];
        map = new String[n][m];

        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                String s = split[j];
                map[i][j] = s;
                if (s.equals("I")) {
                    visit[i][j] = true;
                    queue.add(new Coordinate(i, j));
                }
            }
        }

        bfs();
        if (cnt > 0) {
            System.out.println(cnt);
        } else {
            System.out.println("TT");
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
                        && !map[nx][ny].equals("X")) {
                    if (map[nx][ny].equals("P")) cnt ++;
                    visit[nx][ny] = true;
                    queue.add(new Coordinate(nx, ny));
                }
            }
        }
    }
}