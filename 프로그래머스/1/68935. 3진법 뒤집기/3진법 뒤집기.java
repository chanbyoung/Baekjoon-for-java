import java.util.ArrayList;
import java.util.List;
class Solution {
    public int solution(int n) {
        int answer =0;
        int mok = n;
        List<Integer> num = new ArrayList<>();

        while (mok != 0) {
            num.add(mok % 3);
            mok /= 3;
        }

        int cnt = num.size() - 1;
        for (Integer i : num) {
            answer += (int) (i * Math.pow(3, cnt--));
        }
        return answer;
    }
}