import java.util.*;

class Solution {
    public static int solution(int x, int y, int n) {
        if (x == y) return 0;  // 이미 x가 y라면 연산이 필요 없음
        
        // BFS를 위한 Queue 사용
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        
        // 최소 연산 횟수를 저장하기 위한 배열
        int[] yArr = new int[y + 1];
        Arrays.fill(yArr, Integer.MAX_VALUE);
        yArr[x] = 0;  // 시작점은 연산 0번
        
        // BFS 실행
        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentCount = yArr[current];
            
            // 3가지 연산에 대한 계산
            int[] nextSteps = {current * 2, current * 3, current + n};
            
            for (int next : nextSteps) {
                // 다음 상태가 y보다 크면 무시
                if (next > y) continue;
                
                // 다음 상태가 아직 방문되지 않았거나 더 적은 연산 횟수로 방문 가능하면 갱신
                if (yArr[next] > currentCount + 1) {
                    yArr[next] = currentCount + 1;
                    queue.offer(next);
                }
            }
        }
        
        // 결과 반환
        return yArr[y] == Integer.MAX_VALUE ? -1 : yArr[y];
    }
}