import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
    class Solution {
        public static int[] solution(String today, String[] terms, String[] privacies) {
            Map<String, Integer> term = new HashMap<>();
            List<Integer> list= new ArrayList<>();
            for(int i=0; i<terms.length; i++){
                String[] termSplit = terms[i].split(" ");
                term.put(termSplit[0], Integer.parseInt(termSplit[1]));
            }
            for(int i =0; i< privacies.length;i++){
                String[] splitP = privacies[i].split(" ");
                String[] time = splitP[0].split("\\.");
                Integer plusTime = term.get(splitP[1]); //추가할 달을 가져온다
                String[] month = time[1].split("");
                int plusMonth = Integer.parseInt(month[0])*10+Integer.parseInt(month[1])+plusTime ;
                int plusYear = 0;
                while(plusMonth>12){
                    plusYear+=1;
                    plusMonth-=12;
                }
                //유효기간이 경과된 결과값들
                int resultYear = Integer.parseInt(time[0])+plusYear;
                int resultMonth = plusMonth;
                int resultDay = Integer.parseInt(time[2]);
                LocalDate result = LocalDate.of(resultYear,resultMonth,resultDay);
                String[] todayTime = today.split("\\.");
                int todayYear = Integer.parseInt(todayTime[0]);
                int todayMonth = Integer.parseInt(todayTime[1]);
                int todayDay = Integer.parseInt(todayTime[2]);
                LocalDate day = LocalDate.of(todayYear, todayMonth, todayDay);
                if(result.isBefore(day) || result.isEqual(day)){
                    list.add(i+1);
                }
            }
            int[] answer = new int[list.size()];
            for(int i=0; i<list.size();i++){
                answer[i] = list.get(i);
            }
            return answer;
        }
        
    }