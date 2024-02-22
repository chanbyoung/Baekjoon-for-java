import java.util.*;

class Solution {
    public static int solution(int[] nums) {
        int n = nums.length/2; // 가져갈 수 있는 포켓몬 개수
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int answer = Math.min(n, numSet.size());
        return answer;
    }
}