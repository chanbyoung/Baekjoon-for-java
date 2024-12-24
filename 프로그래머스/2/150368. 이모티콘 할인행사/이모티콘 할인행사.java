public class Solution {
    // 할인률 10%, 20%, 30%, 40%
    static final double[] discount = {10, 20, 30, 40};
    // 최대 구독자
    static int maxSubscribe;
    // 최대 수익
    static int maxRevenue;


    /**
     * 이모티콘 할인 행사 목표 1. 이모티콘 플러스서비스 가입자를 최대한 늘리는 것 2. 이모티콘 판매액을 최대한 늘리는 것
     * <p>
     * 진행 방식 1. n명의 카카오톡 사용자들에게 이모티콘 m 개를 할인하여 판매 2. 이모티콘마다 할인율은 다를 수 있음. 할인율 10%, 20%, 30%, 40%
     * <p>
     * 가입 및 구입 기준 1. 일정 비율 이상 할인하는 이모티콘을 모두 구매 2. 이모티콘 구매 비용의 합이 일정 가격 이상이 된다면 이모티콘 구매를 모두 취소하고, 플러스
     * 서비스 가입
     *
     * @param users 구입하는 이모티콘 할인률, 가격
     * @param emoticons 이모티콘 정가 리스트
     * @return 이모티콘 플러스 가입 횟수, 매출액
     */
    public int[] solution(int[][] users, int[] emoticons) {
        maxSubscribe = 0;
        maxRevenue = 0;

        // 이모티콘 마다 할인율 조합을 담는 discounts
        int[] discounts = new int[emoticons.length];

        // 이모티콘마다 할인율 조합 계산
        dfs(0, users, emoticons, discounts);

        return new int[]{maxSubscribe, maxRevenue};
    }

    private void dfs(int depth, int[][] users, int[] emoticons, int[] discounts) {
        // 할인율 조합 완성시 계산 수행
        if (depth == emoticons.length) {
            calculate(users, emoticons, discounts);
            return;
        }

        for (int i = 0; i < discount.length; i++) {
            discounts[depth] = i;
            dfs(depth + 1, users, emoticons, discounts);
        }
    }

    private void calculate(int[][] users, int[] emoticons, int[] discounts) {
        int subScribe = 0;
        int revenue = 0;

        for (int[] user : users) {
            int buyRate = user[0]; // 구입하는 할인율
            int threshold = user[1]; // 이모티콘 플러스 구매 기준 금액

            int total = 0;

            for (int i = 0; i < emoticons.length; i++) {
                if (buyRate <= discount[discounts[i]]) {
                    total += emoticons[i] * (100 - discount[discounts[i]])/100;
                }
            }

            if (total >= threshold) {
                subScribe++;
            } else {
                revenue += total;
            }
        }
        if (subScribe > maxSubscribe || subScribe == maxSubscribe && revenue > maxRevenue) {
            maxSubscribe = subScribe;
            maxRevenue = revenue;
        }
    }
}