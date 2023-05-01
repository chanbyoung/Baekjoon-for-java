import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int map[][]; // 각 정점간 탐색 경로 저장
    static boolean visit[]; // 정점 탐색여부 체크
    static int N, M, v; // 정점. 간선, 시작정점
    static int count = 0 ; // 정점과 연결된 바이러스 걸리는 컴퓨터 수
    public static int bfs(int i){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        visit[i] = true;
        while (!queue.isEmpty()){
            int temp = queue.poll();
            for(int k=1 ; k<=N; k++){
                if(map[temp][k] == 1 && visit[k] == false){
                    queue.offer(k);
                    visit[k] = true;
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 정점의 개수
        M = Integer.parseInt(br.readLine()); // 간선의 개수
        v = 1; // 시작 정점
        map = new int[N+1][N+1]; // 각 정점간 탐색 경로 저장
        visit = new boolean[N+1]; // 정점의 탐색 여부 체크

        for(int i =0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = map[b][a] = 1;
        }
        System.out.println(bfs(1));

    }
}