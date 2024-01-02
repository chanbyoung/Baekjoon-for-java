import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer =1;
        Arrays.sort(targets, (Comparator.comparingInt(x -> x[0])));
        int preStart = targets[0][0];
        int preEnd = targets[0][1];

        for (int[] target : targets) {
            int curStart = target[0];
            int curEnd = target[1];

            if (preStart <= curStart && curStart < preEnd) {
                preStart = Math.max(preStart, curStart);
                preEnd = Math.min(preEnd, curEnd);
            } else {
                answer ++;
                preStart = curStart;
                preEnd = curEnd;
            }
        }
        return answer;
    }
}