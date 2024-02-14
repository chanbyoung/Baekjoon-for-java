class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                for (int k = j+1; k < nums.length ;k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    boolean prime = prime(sum);
                    if (!prime) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

    private boolean prime(int sum) {
        boolean prime = false;
        for (int i = 2; i <=Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                prime = true;
                break;
            }
        }
        return prime;
    }
}