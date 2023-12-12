class Solution {
        //n -> 빈 병의 수
    public int solution(int a, int b, int n) {
        int answer = 0; //새로 받은 병의 수
        while (n >= a) {
            answer += n/a*b;
            int cnt = n%a;
            n = n/a*b +cnt;
        }
        return answer;
    }
}