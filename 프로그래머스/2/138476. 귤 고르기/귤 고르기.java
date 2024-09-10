import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        int result= 0;
        for (int i : tangerine) {
            if (numMap.containsKey(i)) {
                numMap.replace(i, numMap.get(i) + 1);
                continue;
            }
            numMap.put(i, 1);
        }

        List<Map.Entry<Integer, Integer>> numList = new ArrayList<>(numMap.entrySet());

        Collections.sort(numList, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        
        for (Map.Entry<Integer, Integer> entry : numList) {
            k = k - entry.getValue();
            result++;
            if (k <= 0) {
                break;
            }
        }
        
        return result;
        
    }
}