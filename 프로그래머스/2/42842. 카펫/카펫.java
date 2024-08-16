class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int[] answer = new int[2];
        for (int i = 1; i <= sum ; i++) {
            if (sum % i == 0) {
                int width = sum / i;
                int center = (width -2) * (i-2);
                if (width < i) {
                    break;
                }
                if(center == yellow) {
                    answer[0] = width;
                    answer[1] = i;
                }

            }
        }
        return answer;
    }
}