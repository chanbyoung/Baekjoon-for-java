public class Solution {
    /**
     * 상자 num을 꺼내기 위해 위에 쌓인 상자의 개수를 계산
     *
     * @param n   총 상자 수
     * @param w   한 줄당 상자 수
     * @param num 꺼내려는 상자 번호
     * @return 꺼내야 하는 상자의 수
     */
    public int solution(int n, int w, int num) {
        int count = 1; // num 상자 포함
        int layer = 0;
        int[][] stack = new int[101][w]; // 충분한 높이 확보

        int box = 1;
        boolean leftToRight = true;

        while (box <= n) {
            if (leftToRight) {
                for (int i = 0; i < w && box <= n; i++) {
                    stack[layer][i] = box++;
                }
            } else {
                for (int i = w - 1; i >= 0 && box <= n; i--) {
                    stack[layer][i] = box++;
                }
            }
            leftToRight = !leftToRight;
            layer++;
        }

        // num이 위치한 층과 열(index)를 찾는다
        int numLayer = 0, numCol = 0;
        outer:
        for (int i = 0; i < layer; i++) {
            for (int j = 0; j < w; j++) {
                if (stack[i][j] == num) {
                    numLayer = i;
                    numCol = j;
                    break outer;
                }
            }
        }

        // 위층에 같은 column에 상자가 있으면 count++
        for (int i = numLayer + 1; i < layer; i++) {
            if (stack[i][numCol] != 0) count++;
        }

        return count;
    }
}