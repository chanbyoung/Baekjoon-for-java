import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i : scoville) {
            minHeap.add(i);
        }
        int cnt =0;
        while (minHeap.size()>1) {
            if (minHeap.peek() >= K) {
                return cnt;
            }
            Integer removeNum = minHeap.remove();
            int newScoville = removeNum + (minHeap.remove() * 2);
            minHeap.add(newScoville);
            cnt ++;
        }

        if (minHeap.peek() >= K) {
            return cnt;
        }
        return -1;
    }
}