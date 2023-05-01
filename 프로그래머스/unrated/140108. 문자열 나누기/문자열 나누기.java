class Solution {
    public static int solution(String s) {
        int answer =0;
        String[] split = s.split("");
        String k = split[0];
        int cnt1= 0;
        int cnt2= 0;
        for (String i : split) {
            if(cnt1 == cnt2){
                answer +=1;
                k=i;
            }
            if(k.equals(i)) cnt1++;
            else cnt2 ++;
        }
        return answer;
    }
}