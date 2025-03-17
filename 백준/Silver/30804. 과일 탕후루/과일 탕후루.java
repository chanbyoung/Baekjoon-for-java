import java.io.*;
import java.util.*;

class Main {

    /**
     * 과일의 개수 n
     * 앞 또는 뒤쪽에서 과일을 빼서 두 종류 이하의 과일만 남겨야 함
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] fruitArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            fruitArr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(getMaxFruit(fruitArr, n));

    }

    public static int getMaxFruit(int[] fruitArr, int n) {
        int start =0;
        int maxLength = 0;
        HashMap<Integer, Integer> fruitMap = new HashMap<>();
        for (int end = 0; end < n; end++) {
            fruitMap.put(fruitArr[end], fruitMap.getOrDefault(fruitArr[end], 0) + 1);
            while (fruitMap.size() > 2) {
                fruitMap.put(fruitArr[start], fruitMap.get(fruitArr[start]) - 1);
                if (fruitMap.get(fruitArr[start]) == 0) {
                    fruitMap.remove(fruitArr[start]);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }




}