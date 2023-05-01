    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.LinkedList;
    import java.util.Queue;
    import java.util.StringTokenizer;

    public class Main {
        static int[][] map;
        static int N,M;
        static boolean[] visit;
        public static int bfs(int n){
            Queue<int[]> queue = new LinkedList<>();
            int cnt = 0;
            queue.add(new int[] {n,cnt});
            visit[n] = true;
            int sum = 0;
            while(!queue.isEmpty()){
                int temp = queue.peek()[0];
                cnt= queue.peek()[1];
                sum+= cnt;
                queue.poll();
                cnt++;
                for(int i = 1; i<=N; i++){
                    if(map[temp][i] == 1 && !visit[i]){
                        queue.add(new int[]{i,cnt});
                        visit[i] = true;
                    }
                }
            }
            return sum;

        }
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new int[N+1][N+1];
            visit= new boolean[N+1];
            while(M --> 0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = map[y][x]= 1;
            }
            int[] count = new int[N+1];
            for(int i = 1; i<=N; i++){
                int cnt = bfs(i);
                count[i] = cnt;
                for(int j=1; j<=N; j++) visit[j] = false;
            }
            int[] cnt2 = new int[N];
            for(int i =1; i<N+1;i ++) cnt2[i-1] = count[i];
            Arrays.sort(cnt2);
            for(int i=1; i<=N;i++){
                if(count[i] == cnt2[0]){
                    System.out.println(i);
                    break;
                }
            }

        }

    }