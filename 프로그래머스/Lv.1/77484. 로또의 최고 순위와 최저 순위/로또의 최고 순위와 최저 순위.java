import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] result = new int[2];
        List<Integer> list = IntStream.of(win_nums)
                .boxed()
                .collect(Collectors.toList());
        int zero_cnt= 0;
        int lotto_cnt= 0;
        for (int lotto : lottos) {
            if (list.contains(lotto)) {
                lotto_cnt++;
            }
            if (lotto == 0) {
                zero_cnt ++;
            }
        }
        int exCnt = lotto_cnt + zero_cnt;
        result[0] -= exCnt-7;
        result[1] -= lotto_cnt-7;
        for (int i = 0; i < 2; i++) {
            if (result[i] >=6) {
                result[i] =6 ;
            }
        }
        return result;


    }

}