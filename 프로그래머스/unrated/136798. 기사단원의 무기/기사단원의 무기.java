class Solution {
    public static int solution(int number, int limit, int power) {
        int answer=0;
        for(int i=1; i<=number; i++){
            answer += divisor(i) <= limit ? divisor(i): power;
        }
        return answer;
    }
    public static int divisor(int i){
        int cnt =0;
        for(int k=1; k<= (int)Math.sqrt(i); k++){
            if(i%k ==0){
                cnt++;
            }
        }
        return (i% Math.sqrt(i) ==0) ? cnt*2-1 :cnt*2;
    }
}