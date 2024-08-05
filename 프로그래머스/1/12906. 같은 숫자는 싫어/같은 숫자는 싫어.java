import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (stack.empty()) {
                stack.push(i);
                continue;
            }
            if (stack.peek() == i) {
                continue;
            }
            stack.push(i);
        }
        int[] result = new int[stack.size()];
        for (int i = stack.size()-1; i >= 0 ; i--) {
            result[i] = stack.get(i);
        }
        return result;
    }
}