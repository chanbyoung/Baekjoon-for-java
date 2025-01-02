import java.util.*;

public class Solution {

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private char[][] arr;

    public int solution(String[] maps) {
        arr = Arrays.stream(maps)
                .map(String::toCharArray)
                .toArray(char[][]::new);

        // 시작 지점, 레버, 출구의 좌표를 찾는다
        int[] start = findPosition('S');
        int[] lever = findPosition('L');
        int[] exit = findPosition('E');

        // 시작 → 레버까지의 최단 거리
        int toLever = bfs(start, lever);
        if (toLever == -1) return -1;

        // 레버 → 출구까지의 최단 거리
        int toExit = bfs(lever, exit);
        if (toExit == -1) return -1;

        // 총 거리 반환
        return toLever + toExit;
    }

    private int bfs(int[] start, int[] target) {
        int n = arr.length, m = arr[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start[0], start[1], 0}); // x, y, 거리
        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            // 목표 지점에 도달하면 거리 반환
            if (x == target[0] && y == target[1]) {
                return dist;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && arr[nx][ny] != 'X') {
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }

        // 목표 지점에 도달할 수 없는 경우
        return -1;
    }

    private int[] findPosition(char target) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}