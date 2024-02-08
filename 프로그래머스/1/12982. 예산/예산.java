import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
       Arrays.sort(d);
       int cnt = 0;
        for (int i : d) {
            budget = budget - i;
            if (budget >= 0) {
                cnt++;
            }
        }
        return cnt;
    }

}