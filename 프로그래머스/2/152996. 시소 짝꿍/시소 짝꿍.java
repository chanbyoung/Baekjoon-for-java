import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);
        HashMap<Double, Integer> map = new HashMap<>();

        long answer = 0;

        for (int weight : weights) {
            double case1 = weight;
            double case2 = weight * 2.0 / 3.0;
            double case3 = weight / 2.0;
            double case4 = weight * 3.0 / 4.0;

            if (map.containsKey(case1)) {
                answer += map.get(case1);
            }
            if (map.containsKey(case2)) {
                answer += map.get(case2);
            }
            if (map.containsKey(case3)) {
                answer += map.get(case3);
            }
            if (map.containsKey(case4)) {
                answer += map.get(case4);
            }
            map.put(case1, map.getOrDefault(case1, 0) + 1);
        }
        return answer;
    }
}
