import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int targetPoint = -1;
        int answer =0;

        Arrays.sort(targets, Comparator.comparingInt(o -> o[1]));

        for (int[] target : targets) {
            if (target[0] < targetPoint) {
                continue;
            }
            targetPoint = target[1];
            answer ++;

        }
        return answer;
    }

}