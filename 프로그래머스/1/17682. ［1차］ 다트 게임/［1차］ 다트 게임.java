import java.util.HashMap;

class Solution {
    public static int solution(String dartResult) {
        String[] split = dartResult.split("");
        int[] numList = new int[split.length];

        HashMap<String, Integer> check1 = new HashMap<>();
        check1.put("S", 1);
        check1.put("D", 2);
        check1.put("T", 3);
        int cnt =0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals("S") || split[i].equals("D") || split[i].equals("T")) {
                numList[cnt-1]= (int) Math.pow(numList[cnt-1],check1.get(split[i]));
            }
            else if (split[i].equals("*")) {
                if (cnt - 2 >= 0) {
                    numList[cnt-2] = numList[cnt-2]*2;
                }
                numList[cnt-1]=numList[cnt-1]*2;
            } else if (split[i].equals("#")) {
                numList[cnt-1] = -numList[cnt-1];
            }
            else {
                if(i+1 < split.length-1) {
                    if (split[i].equals("1") && split[i + 1].equals("0")) {
                        numList[cnt] = 10;
                        cnt++;
                        i=i+1;
                        continue;
                    }
                }
                numList[cnt] = Integer.parseInt(split[i]);
                cnt++;
            }
        }
        int sum =0;
        for (int i : numList) {
            sum += i;
        }
        return sum;
    }
}