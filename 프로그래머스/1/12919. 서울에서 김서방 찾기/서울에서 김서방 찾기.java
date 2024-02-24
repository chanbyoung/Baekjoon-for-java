class Solution {
    public String solution(String[] seoul) {
        String answer = "김서방은 ";
        int cnt = 0;
        for (String s : seoul) {
            if (s.equals("Kim")) {
                break;
            }
            cnt++;
        }
        answer += cnt+"에 있다";
        return answer;
    }
}