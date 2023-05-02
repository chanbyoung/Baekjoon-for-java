import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int[] arr;
    public static int[] num;
    public static boolean[] visit;
    public static LinkedHashSet<String> set;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        num = new int[N];
        visit = new boolean[N];
        set = new LinkedHashSet<>();
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);
        dfs(0);
        StringBuilder sb = new StringBuilder();
        for (String s : set) {
            sb.append(s+"\n");
        }
        System.out.print(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i : arr) {
                sb.append(i+" ");
            }
            set.add(String.valueOf(sb));
            return;
        }

        for (int i = 0; i < N; i++) {
            if(visit[i])
                continue;
            visit[i] = true;
            arr[depth] = num[i];
            dfs(depth + 1);
            visit[i] = false;
        }

    }
}

