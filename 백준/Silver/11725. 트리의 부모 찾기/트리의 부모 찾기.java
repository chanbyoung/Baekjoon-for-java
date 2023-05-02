import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer> map[];
    static boolean visit[];
    static int[] arr;
    static int N;
    public static void bfs(){
        Queue<Integer> queue = new LinkedList();
        queue.add(1);
        visit[1] = true;
        while (!queue.isEmpty()){
            int x = queue.poll();
            for(int i: map[x]) {
                if (!visit[i]) {
                    queue.add(i);
                    arr[i] = x;
                    visit[i] = true;
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        map = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for(int i=0; i<N+1; i++){
            map[i] = new ArrayList<>();
        }
        for(int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
       bfs();
        for(int i=2; i<=N; i++){
            sb.append(arr[i]+"\n");
        }
        System.out.println(sb);
    }

}

