import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = init(N, M, br);
        int[][] b = init(N, M, br);

        // 3*3 배열로 바꿀 수 없는 경우
        if (N < 3 || M < 3) {
            System.out.println(Arrays.deepEquals(a, b) ? 0 : -1);
            return;
        }

        int cnt = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (a[i][j] != b[i][j]) {
                    flip(a, i, j);
                    cnt++;
                }
            }
        }

        if (Arrays.deepEquals(a, b)) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }



    }

    private static int[][] init(int N, int M, BufferedReader br)
            throws IOException {
        int[][] ints = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                ints[i][j] = line.charAt(j) - '0';
            }
        }
        return ints;
    }

    private static void flip(int[][] a, int n, int m) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[n + i][m + j] = 1 - a[n + i][m + j];
            }
        }
    }
}
