import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    /**
     * 이전에 k광년을 이동했을 경우 k-1, k, k+1 광년만을 이동할 수 있음
     * x 지점에서 y 지점을 향해 최소한의 작동 횟수로 이동해야됨
     * 시작지점에서는 1 광년만을 이동할 수 있음
     * y 지점에 도착하러 가는 이동거리는 1 (직전의 이동거리는 1, 2 중 하나 )
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            // 시작지점 x, 목표지점 y
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 직전의 거리인 1 추가로
            int distance = y - x;

            int max = (int) Math.sqrt(distance);

            if (max == Math.sqrt(distance)) {
                System.out.println(2 * max - 1);
            } else if (distance <= max * max + max) {
                System.out.println(2 * max);
            } else {
                System.out.println(2 * max + 1);
            }


        }

    }

}
