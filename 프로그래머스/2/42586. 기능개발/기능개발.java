import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int num = (int) Math.ceil((double) (100 - progresses[0]) / speeds[0]);
        int cnt = 1;
        for (int i = 1; i < progresses.length ; i++) {
            int newNum = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            if (num < newNum) {
                list.add(cnt);
                num = newNum;
                cnt =1;
            if (i == progresses.length - 1) {
                list.add(cnt);
            }
                continue;
            }
            cnt++;
            if (i == progresses.length - 1) {
                list.add(cnt);
            }
        }
        return list.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}