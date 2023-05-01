class Solution {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int cnt = goal.length;
        int cnt1= 0;
        int cnt2= 0;
        for(int i=0 ; i<cnt; i++){
            if(cnt1 != cards1.length) {
                if (goal[i].equals(cards1[cnt1])) {
                    cnt1++;
                }
            }
            if(cnt2 != cards2.length) {
                if (goal[i].equals(cards2[cnt2])) {
                    cnt2++;
                }
            }
        }
        if(cnt1+cnt2 == cnt){
            return "Yes";
        }
        else {
            return "No";
        }
    }
}