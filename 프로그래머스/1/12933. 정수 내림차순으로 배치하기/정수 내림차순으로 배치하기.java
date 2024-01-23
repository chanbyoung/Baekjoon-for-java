import java.util.Arrays;

class Solution {
    public long solution(long n) {
        String[] convert = String.valueOf(n).split("");
        Arrays.sort(convert);
        String num = "";
        for (int i = convert.length-1; i >=0; i--) {
            num += convert[i];
        }
        return Long.valueOf(num);
    }
}