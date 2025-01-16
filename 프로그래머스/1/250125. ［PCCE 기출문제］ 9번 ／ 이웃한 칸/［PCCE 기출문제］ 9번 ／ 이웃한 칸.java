import java.util.*;

class Solution {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static boolean[][] visit;

    public int solution(String[][] board, int h, int w) {
        visit = new boolean[board.length][board[0].length];
        return bfs(board, board[h][w], h, w);
    }
    private int bfs(String[][] board, String color, int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(new int[]{x, y});
        int sum = 0;
        int[] poll = q.poll();
        for (int i = 0; i < 4; i++) {
            int cx = poll[0] + dx[i];
            int cy = poll[1] + dy[i];
            if (cx < 0 || cx >= board.length || cy < 0 || cy >= board[0].length)
                continue;
            if (!visit[cx][cy] && board[cx][cy].equals(color)) {
                visit[cx][cy] = true;
                q.add(new int[]{cx, cy});
                sum++;
            }
        }
        return sum;

    }
}