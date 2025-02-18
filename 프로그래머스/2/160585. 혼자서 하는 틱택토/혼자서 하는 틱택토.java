import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    private static final String O = "O";
    private static final String X = "X";

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * O가 X보다 1개 많거나 둘의 개수는 같아야 한다.
     * 게임이 종료되었을때, 계속 플레이를 하면 안된다.
     */
    public int solution(String[] board) {
        List<Node> oList = new ArrayList<>();
        List<Node> xList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String[] splitBoard = board[i].split("");
            for (int j = 0; j < 3; j++) {
                if (splitBoard[j].equals(O)) {
                    oList.add(new Node(i, j));
                }
                if (splitBoard[j].equals(X)) {
                    xList.add(new Node(i, j));
                }
            }
        }
        // x의 개수가 더 많은 경우
        if (xList.size() > oList.size())
            return 0;

        // O는 X보다 최대 1개 더 많아야 한다.
        if (oList.size() > xList.size() + 1)
            return 0;

        boolean oWin = checkVictory(oList);
        boolean xWin = checkVictory(xList);

        // 둘 다 승리는 불가능
        if (oWin && xWin)
            return 0;
        // X가 승리했는데 O랑 개수가 다를 경우
        if (xWin && xList.size() != oList.size())
            return 0;
        // O가 승리했는데 X와 개수가 같을경우
        if (oWin && oList.size() == xList.size())
            return 0;

        return 1;

    }


    private boolean checkVictory(List<Node> nodeList) {
        // 가능한 승리 조건 (가로, 세로, 대각선)
        int[][] winConditions = {
                {0, 0, 0, 1, 0, 2}, // 가로 1줄
                {1, 0, 1, 1, 1, 2}, // 가로 2줄
                {2, 0, 2, 1, 2, 2}, // 가로 3줄
                {0, 0, 1, 0, 2, 0}, // 세로 1줄
                {0, 1, 1, 1, 2, 1}, // 세로 2줄
                {0, 2, 1, 2, 2, 2}, // 세로 3줄
                {0, 0, 1, 1, 2, 2}, // 대각선
                {0, 2, 1, 1, 2, 0}  // 대각선
        };

        HashMap<String, Boolean> nodeMap = new HashMap<>();
        for (Node node : nodeList) {
            nodeMap.put(node.x + "," + node.y, true);
        }

        // 모든 승리 조건을 확인
        for (int[] condition : winConditions) {
            String key1 = condition[0] + "," + condition[1];
            String key2 = condition[2] + "," + condition[3];
            String key3 = condition[4] + "," + condition[5];

            if (nodeMap.containsKey(key1) && nodeMap.containsKey(key2) && nodeMap.containsKey(key3)) {
                return true; // 승리 조건 만족
            }
        }

        return false; // 승리 조건 없음
    }

}