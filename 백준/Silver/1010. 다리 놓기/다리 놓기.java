import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            System.out.println(combination(m, n));
        }
    }

    public static long combination(int m, int n) {
        if (n > m - n) { // 최적화: 작은 값을 선택하여 계산량 줄이기
            n = m - n;
        }

        long result = 1;

        for (int i = 0; i < n; i++) {
            result = result * (m - i) / (i + 1);
        }

        return result;
    }
}