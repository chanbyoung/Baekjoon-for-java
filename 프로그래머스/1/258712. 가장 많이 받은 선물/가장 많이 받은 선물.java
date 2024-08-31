import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int[][] giftList = new int[friends.length][friends.length];
        List<String> friendList = new ArrayList<>(Arrays.asList(friends));
        HashMap<String, Integer> giftPoint = new HashMap<>();
        for (String s : friendList) {
            giftPoint.put(s, 0);
        }

        for (String gift : gifts) {
            String[] split = gift.split(" ");
            int sender = friendList.indexOf(split[0]);
            int receiver = friendList.indexOf(split[1]);
            giftList[sender][receiver] ++;
            giftPoint.replace(split[0], giftPoint.get(split[0]) + 1);
            giftPoint.replace(split[1], giftPoint.get(split[1]) - 1);
        }
        //선물 주고 받기와 선물 지수 계산 끝
        
        int max = 0;
        for (int i = 0; i < friends.length; i++) {
            int cnt =0;
            for (int j = 0; j < friends.length; j++) {
                if(i == j) continue;
                // 선물을 주고 받은 기록이 없거나, 주고 받은 수가 같은 경우
                if ((giftList[i][j] == 0 && giftList[j][i] == 0) || giftList[i][j] == giftList[j][i]) {
                    if (giftPoint.get(friends[i]) > giftPoint.get(friends[j])) {
                        cnt++;
                    }
                }
                // 선물을 상대방에게 더 많이 준 경우 
                if (giftList[i][j] > giftList[j][i]) {
                    cnt ++;
                }
            }
            if (max < cnt) {
                max = cnt;
            }
        }
        
        return max;
    }
}