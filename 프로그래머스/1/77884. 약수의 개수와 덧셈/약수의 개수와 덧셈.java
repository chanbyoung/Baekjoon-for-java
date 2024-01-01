class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            boolean flag = flag(i);
            if (flag) {
                answer += i;
            }
            else answer -= i;
        }

        return answer;
    }

    private boolean flag(int i) {
        int cnt = 0;
        for (int j = 1; j <= i ; j++) {
            if (i % j == 0) {
                cnt++;
            }
        }
        return cnt % 2 == 0;

    }
}