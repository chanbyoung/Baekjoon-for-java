import java.util.*;
class Solution {
    public static int[] solution(String[] keymap, String[] targets) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<keymap.length; i++){
            String[] key = keymap[i].split("");
            for(int j=0; j<key.length; j++){
                if(map.containsKey(key[j])){
                    int min = map.get(key[j])> j+1 ? j+1 : map.get(key[j]);
                    map.put(key[j], min);
                }
                else {
                    map.put(key[j], j+1);
                }
            }
        }
        int[] result = new int[targets.length];
        for(int i = 0; i<targets.length; i++){
            String[] word = targets[i].split("");
            int cnt = 0;
            for(int j=0; j<word.length; j++){
                if(map.containsKey(word[j])) {
                    cnt += map.get(word[j]);
                }
                else {
                    cnt = -1;
                    break;
                }
            }
            result[i] = cnt;
        }
        return result;
    }
}