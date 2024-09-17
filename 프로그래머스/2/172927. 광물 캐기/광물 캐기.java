import java.util.*;

class Solution {
    
   public  static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int arrLength = 0;
        for (int pick : picks) {
            arrLength += pick * 5;
        }
        HashMap<Integer, Integer> stoneCnt = new HashMap<>();
        //만약 곡괭이로 미네랄을 전부 캘 수 없다면
        if (arrLength < minerals.length) {
            minerals = Arrays.copyOfRange(minerals, 0, arrLength);
        }
        // 가장 피로도가 많이 드는 돌을 기준으로 5개씩 피로도 정렬
        int sum = 0;
        for (int i = 0; i < minerals.length; i++) {
             sum += pick("stone", minerals[i]);
            if ((i + 1) % 5 == 0 || i == minerals.length - 1) {
                stoneCnt.put(stoneCnt.size() + 1, sum);
                sum = 0;
            }
        }

        //value 값을 기준으로 내림차순으로 정렬
        LinkedList<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(stoneCnt.entrySet());
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        for (Map.Entry<Integer, Integer> integerIntegerEntry : entryList) {
            String[] newArr = Arrays.copyOfRange(minerals, (integerIntegerEntry.getKey() - 1) * 5, minerals.length);
            if (picks[0]>0) {
                for (int i = 0; i < 5; i++) {
                    answer ++;
                    if (i == newArr.length - 1) {
                        break;
                    }
                }
                picks[0] --;
                continue;
            }
            if (picks[1] > 0) { //철이 있을 때
                for (int i = 0; i < 5; i++) {
                    answer += pick("iron", newArr[i]);
                    if (i == newArr.length - 1) {
                        break;
                    }
                }
                picks[1]--;
                continue;
            }
            answer += integerIntegerEntry.getValue();
        }

        return answer;
    }

    public static int pick(String pick, String mineral) {
        if(pick.equals("stone")) {
            if (mineral.equals("diamond")) {
                return 25;
            } else if (mineral.equals("iron")) {
                return 5;
            }
        }
        if (pick.equals("iron")) {
            if (mineral.equals("diamond")) {
                return 5;
            }
        }
        return 1;
    }

}