import java.util.*;
class Solution {
    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        int cnt =0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : score) {
            queue.add(i);
            if(queue.size() == k+1) queue.poll();
            answer[cnt] = queue.peek();
            cnt++;
        }
        return answer;
    }
}