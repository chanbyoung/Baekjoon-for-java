class Solution {
    public String solution(String s) {
        String[] split = s.toLowerCase().split("");
        String answer = "";
        int cnt = 0;

        for (String string : split) {
            if (cnt % 2 == 0) {
                string = string.toUpperCase();
            }
            answer += string;
            if (string.equals(" ")) {
                cnt=0;
                continue;
            }
            cnt ++;
        }

        return answer;
    }
}