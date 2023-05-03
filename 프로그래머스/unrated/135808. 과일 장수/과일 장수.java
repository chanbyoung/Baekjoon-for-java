import java.util.*;

class Solution {
    public static int solution(int k, int m, int[] score) {
        int min =Integer.MAX_VALUE;
        Arrays.sort(score);
        Map<Integer, Integer> map = new HashMap<>();
        int cnt =0;
        for(int i= score.length-1; i>=0;i--){
            if(score[i]<=k){
                min=Math.min(min,score[i]);
                cnt++;
                if(cnt == m){
                    if(map.containsKey(min)){
                        map.put(min, map.get(min)+1);
                    }else {
                        map.put(min, 1);
                    }
                    cnt =0;
                }
            }
        }
        int result =0;
        for (Integer integer : map.keySet()) {
            result += integer*map.get(integer)*m;
        }
        return result;
    }

}