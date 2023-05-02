import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int[] num;
    public static boolean visit[];
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        num = new int[N];
        visit = new boolean[N];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        dfs(0);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if(!visit[i]) {
                visit[i] = true;
                arr[depth] = num[i];
                dfs(depth + 1);
                visit[i] = false;
            }
        }

    }
}

