class Solution {
  public static int solution(int n, int m, int[] section) {
        int answer =0;
        int loc =0;
        for(int i=0;i<section.length; i++){
            if(section[i]<loc){
                continue;
            }
            answer +=1;
            loc = section[i] +m;
        }
        return answer;
    }
}