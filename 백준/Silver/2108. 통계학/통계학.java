import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[8001]; //-4000~4000 을 0~8000의 범의로 생각한다
        double sum = 0;
        int max = Integer.MIN_VALUE; // -2147483648
        int min = Integer.MAX_VALUE; //  2147483647

        for(int i = 0; i < N; i++){
            int value = Integer.parseInt(br.readLine());
            sum += value;
            arr[value+4000]++; //0~8000의 범위로 생각하므로 +4000 해 준 값에 ++
            if(max < value) max = value;
            if(min > value) min = value;
        }
        // 중앙값 과 최빈값 -4000 ~ 4000 을 제외한 수로 초기화
        int median = 10000;
        int mode = 10000;
        int cnt = 0;
        int mode_max = 0; //최빈값의 최대


        boolean flag = false;

        for(int i = min+4000; i<= max + 4000; i++){
            if(arr[i]>0){

                if(cnt < (N+1) / 2){
                    cnt += arr[i]; // 빈도수를 cnt 에 누적
                    median = i - 4000; // median 에 중앙값 저장
                }

            }
            if(mode_max < arr[i]){
                mode_max = arr[i];
                mode = i - 4000;
                flag = true;
            } else if (mode_max == arr[i] && flag == true) {
                mode = i - 4000;
                flag = false;
            }
        }
        System.out.println((int)Math.round(sum/N));
        System.out.println(median);
        System.out.println(mode);
        System.out.println(max-min);

    }
}