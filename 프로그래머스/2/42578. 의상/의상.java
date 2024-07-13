import java.util.HashMap;

class Solution {
    public  int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            if (map.containsKey(clothe[1])) {
                map.replace(clothe[1], map.get(clothe[1])+1);
            }else {
                map.put(clothe[1], 1);
            }
        }
        int answer =1;
        for (Integer value : map.values()) {
            answer *= (value+1);
        }
        return answer-1;
    }
}