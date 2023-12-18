class Solution {
    public int solution(int n) {
        if (n % 2 != 0) {
            return 2;
        }
        int answer =3;
        while (true) {
            if (n % answer == 1) {
                break;
            }
            answer += 2;
        }
        return answer;
    }
}