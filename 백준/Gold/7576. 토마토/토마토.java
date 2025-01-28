import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static String[][] box;
    private static Queue<Tomato> q = new LinkedList<>();

    static class Tomato {
        int x;
        int y;
        int day;

        public Tomato(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        box = new String[x][y];
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < y; j++) {
                box[i][j] = st.nextToken();
                if (box[i][j].equals("1")) {
                    q.offer(new Tomato(i, j, 0));
                }
            }

        }
        bfs();
    }

    private static void bfs() {
        int day = 0;
        while (!q.isEmpty()) {
            Tomato tomato = q.poll();
            day = tomato.day;
            for (int i = 0; i < 4; i++) {
                int cx = tomato.x + dx[i];
                int cy = tomato.y + dy[i];

                if (0 <= cx && cx < box.length && 0 <= cy && cy < box[0].length) {
                    if (box[cx][cy].equals("0")) {
                        box[cx][cy] = "1";
                        q.offer(new Tomato(cx, cy, tomato.day+1));
                    }
                }
            }

        }
        if (checkBox()) {
            System.out.println(day);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean checkBox() {
        for (String[] boxes : box) {
            List<String> box = Arrays.asList(boxes);
            if (box.contains("0")) {
                return false;
            }
        }
        return true;

    }

}
