class Solution {
      public static int solution(int n) {
        int answer =0;
        for (int i = 2; i <= n; i++) {
            boolean flag = flag(i);
            if (flag) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean flag(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}