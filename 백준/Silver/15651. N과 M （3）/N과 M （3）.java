import java.io.*;
import java.util.*;

class Main {

    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        dfs(0, m, n);
        System.out.println(sb);
    }

    public static void dfs(int depth, int maxDepth, int maxNum) {

        if (depth == maxDepth) {
            for (int i = 0; i < maxDepth; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= maxNum; i++) {
            arr[depth] = i;
            dfs(depth + 1, maxDepth, maxNum);
        }
    }


}