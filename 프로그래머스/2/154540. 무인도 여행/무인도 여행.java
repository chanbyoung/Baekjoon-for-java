import java.util.*;

class Solution {
    public static boolean[][] visit = new boolean[100][100];
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static String[][] arr;


    public int[] solution(String[] maps) {
        arr = new String[maps.length][maps[0].length()];
        int cnt =0;
        List<Integer> list = new ArrayList<>();
        for (String map : maps) {
            String[] split = map.split("");
            for (int i = 0; i < split.length; i++) {
                arr[cnt][i] = split[i];
            }
            cnt++;
        }
        // 초기 배열 생성 완료
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (!visit[i][j] && !arr[i][j].equals("X")) {
                    list.add(bfs(i, j));
                }
            }
        }
        if (list.isEmpty()) {
            return new int[]{-1};
        }

        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(array);
        return array;
    }

    public static int bfs(int x, int y) {
        int sum = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visit[x][y] = true;
        
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int cx = poll[0];
            int cy = poll[1];
            sum += Integer.parseInt(arr[cx][cy]);
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                //공간을 벗어나거나 벽에 부딪힌 경우
                if (nx < 0 || nx == arr.length || ny < 0 || ny == arr[0].length) continue;

                if (!visit[nx][ny] && !arr[nx][ny].equals("X")) {
                    visit[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return sum;
    }
}