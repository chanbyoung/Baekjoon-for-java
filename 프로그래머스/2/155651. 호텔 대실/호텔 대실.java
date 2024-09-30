import java.util.*;

class Solution {

    public static int solution(String[][] book_time) {
        int answer = 0;
        int[][] timeArr = new int[book_time.length][2];
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        // int형 배열로 바꿈
        for (int i = 0; i < book_time.length; i++) {
            timeArr[i][0] = timeChangeToInt(book_time[i][0]);
            timeArr[i][1] = timeChangeToInt(book_time[i][1]);
        }
        // 첫 번째 숫자 기준으로 오름차순으로 정렬
        Arrays.sort(timeArr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < timeArr.length; i++) {
            if (i==0) {
                pQ.add(timeArr[i][1] + 10);
                answer++;
                continue;
            }
            // 새로운 방을 구해야 하는 경우
            if (pQ.isEmpty() || pQ.peek() > timeArr[i][0]) {
                pQ.add(timeArr[i][1] + 10);
                answer ++;
                continue;
            }
            // 퇴실 + 정리시간 후 빈 방이 남은 경우
            pQ.add(timeArr[i][1] + 10);
            pQ.poll();
        }
        return answer;
    }

    public static int timeChangeToInt(String time) {
        String[] splitTime = time.split(":");
        return Integer.parseInt(splitTime[0]) * 60 + Integer.parseInt(splitTime[1]);
    }
}