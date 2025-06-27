import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxNum = 0;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                 int num = Integer.parseInt(st.nextToken());
                 if(num > maxNum) {
                     maxNum = num;
                     maxRow = i;
                     maxCol = j;
                 }
            }
        }

        System.out.println(maxNum);
        System.out.println((maxRow+1)+" "+(maxCol+1));
    }

}