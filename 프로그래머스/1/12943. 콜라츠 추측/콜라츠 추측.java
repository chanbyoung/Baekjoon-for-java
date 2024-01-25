class Solution {
    public int solution(int num) {
        int answer = 0;
        long n = num;
        if(n != 1) {
            for (int i = 0; i < 500; i++) {
                if (n % 2 == 0) {
                    n /= 2;
                } else {
                    n = n * 3 + 1;
                }
                if (n == 1) {
                    answer = i + 1;
                    break;
                }
            }
            if (answer == 0) {
                return -1;
            }
        }
        return answer;
    }

}