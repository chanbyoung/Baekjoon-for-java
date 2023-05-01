import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num = br.readLine().split(" ");
        int K = Integer.parseInt(num[0]);
        int N = Integer.parseInt(num[1]);
        int[] arr = new int[K];
        for(int i = 0; i< K ; i++){
             arr[i] = Integer.parseInt(br.readLine());
        }
        //배열에 값 넣기 완료
        Arrays.sort(arr);
        long result = binarySearch(arr, N);
        System.out.println(result-1);
        }
        public static long binarySearch(int arr[] , int N){
            long low = 0;
            long high = arr[arr.length-1];
            high++;
            while(low< high){
                long mid = (low + high)/2;
                long cnt = 0;
                for (int i : arr) {
                    cnt += i/mid;
                }
                if(cnt >= N){
                    low = mid+1;
                }
                else{  //cnt < N
                    high = mid;
                }
            }
            return low;
        }
}



