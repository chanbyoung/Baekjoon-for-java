import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    /**
     * 시간대에 이용하는 사람이 m명 늘어날 때 마다 서버 1대가 추가로 필요하다. 즉 어느 시간대에 이용자가 m명 미만이라면 서버 증설이 필요하지 않다 한번 증설된 서버는
     * k 시간동안만 운영된다.
     *
     * @param players 시간대별 이용자 수
     * @param m       서버당 최대 이용자 수 + 1
     * @param k       증설된 서버가 운영하는 시간
     * @return
     */
    public int solution(int[] players, int m, int k) {
        int result = 0;

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < players.length; i++) {
            while (!q.isEmpty() && q.peek() <= i) {
                q.poll();
            }

            int addServerFlag = players[i] - ((1 + q.size()) * m);

            while (addServerFlag >= 0) {
                q.add(i + k);  // 현재 시간부터 k시간 동안 운영될 추가 서버 등록
                result++;      // 증설 횟수 증가
                addServerFlag -= m;   // 추가 서버 1대당 m명 용량 처리
            }

        }
        return result;
    }


}