import java.util.*;   
class Solution {
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<String, Integer> word = new HashMap<>();
        String[] split = s.split("");
        for(int i=0; i< split.length; i++){
            String w = split[i];
            if(!word.containsKey(w)){
                answer[i] = -1;
                word.put(w, i);
            }
            else {
                answer[i] = i - word.get(w);
                word.put(w, i);
            }
        }

        return answer;
    }
}