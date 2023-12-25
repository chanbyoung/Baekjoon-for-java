import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Set<String> newReportList = new HashSet<>(List.of(report));
        int[] totalReportList = new int[id_list.length];
        String[] reportPeopleIndex = new String[id_list.length];
        Arrays.fill(reportPeopleIndex, "");
        for (String s : newReportList) {
            String[] split_reportList = s.split(" ");
            int reportPeople = Arrays.asList(id_list).indexOf(split_reportList[0]);
            int reportIndex = Arrays.asList(id_list).indexOf(split_reportList[1]);
            reportPeopleIndex[reportIndex] += reportPeople+" ";
            totalReportList[reportIndex]++;
        }
        for (int i = 0; i < id_list.length; i++) {
            if (totalReportList[i] >= k) {
                String[] splitReportPeople = reportPeopleIndex[i].split(" ");
                for (String splitReportPerson : splitReportPeople) {
                    answer[Integer.parseInt(splitReportPerson)] ++;
                }
            }
        }
        return answer;
    }
}