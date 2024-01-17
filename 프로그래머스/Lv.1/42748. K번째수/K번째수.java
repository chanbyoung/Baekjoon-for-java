import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int cnt = 0;
        for (int[] command : commands) {
            int start = command[0] -1; //1
            int end = command[1] -1;  //4
            int arrPoint = end - start + 1; //4
            int[] newArr = new int[arrPoint]; //int[4]
            for (int i = 0; i <arrPoint; i++) {
                newArr[i] = array[start + i];
            }
            Arrays.sort(newArr);
            result[cnt] = newArr[command[2] - 1];
            cnt ++;
        }
        return result;
    }
}