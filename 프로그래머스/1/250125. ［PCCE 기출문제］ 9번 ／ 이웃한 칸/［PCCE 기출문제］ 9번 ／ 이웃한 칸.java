class Solution {
    public int solution(String[][] board, int h, int w) {
        int n = board.length; // 1. board의 길이를 저장
        int count = 0; // 2. 같은 색으로 색칠된 칸의 개수를 저장하는 변수
        
        // 3. h, w의 변화량을 저장하는 리스트
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};

        // 4. 반복문을 통해 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int h_check = h + dh[i]; // 4-1. 체크할 h 좌표
            int w_check = w + dw[i]; // 4-1. 체크할 w 좌표

            // 4-2. h_check와 w_check가 유효한 범위 내에 있는지 확인
            if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                // 4-2-a. 같은 색이면 count 증가
                if (board[h][w].equals(board[h_check][w_check])) {
                    count++;
                }
            }
        }
        return count; // 5. count 반환
    }
}