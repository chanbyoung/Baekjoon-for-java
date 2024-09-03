import java.util.*;

class Solution {
    /**
     * 과제는 시작하기로 한 시각이 되면 시작한다.
     * 새로운 과제를 시작할 시간이 된다면, 기존에 진행중인 과제를 멈추고 새로운 과제를 시작함
     * 진행중이던 과제를 끝냈을 때 멈춰둔 과제를 이어서 진행함
     * 과제를 끝낸 시각에 새로 시작해야되는 과제와 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행
     * 멈춰둔 과제가 여러개이면, 최근에 멈춘거부터 시작
     */
    public String[] solution(String[][] plans) {
        Plan[] planList = new Plan[plans.length];
        for (int i = 0; i < planList.length; i++) {
            planList[i] = new Plan(plans[i]);
        }
        Arrays.sort(planList, Comparator.comparingInt(a -> a.start));
        Stack<Plan> stopStack = new Stack<>(); // 가장 최근에 멈춘 과제부터 시작하므로 stack 사용
        List<String> result = new ArrayList<>();
        
        for (int i = 0; i < planList.length - 1; i++) {
            Plan currentPlan = planList[i];
            Plan nextPlan = planList[i + 1];
            
            // 진행 중인 과제를 멈추고 새로운 과제를 시작해야 하는 경우
            if (currentPlan.getEndTime() > nextPlan.start) {
                currentPlan.playTime = currentPlan.getEndTime() - nextPlan.start;
                stopStack.push(currentPlan);
            } else {
                result.add(currentPlan.name);
                int time = nextPlan.start - currentPlan.getEndTime();
                
                // 남는 시간 동안 중단한 과제를 이어서 진행
                while (time > 0 && !stopStack.isEmpty()) {
                    Plan stopPlan = stopStack.peek();
                    if (stopPlan.playTime <= time) {
                        time -= stopPlan.playTime;
                        result.add(stopStack.pop().name);
                    } else {
                        stopPlan.playTime -= time;
                        time = 0;
                    }
                }
            }
        }
        
        // 마지막 과제 처리
        result.add(planList[plans.length - 1].name);
        
        // 남은 멈춘 과제 처리
        while (!stopStack.isEmpty()) {
            result.add(stopStack.pop().name);
        }
        
        return result.toArray(new String[0]);
    }

    static class Plan {
        String name;
        int start;
        int playTime;

        public Plan(String name, String start, String playTime) {
            this.name = name;
            String[] time = start.split(":");
            this.start = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            this.playTime = Integer.parseInt(playTime);
        }

        public Plan(String[] plan) {
            this(plan[0], plan[1], plan[2]);
        }

        public int getEndTime() {
            return start + playTime;
        }
    }


}