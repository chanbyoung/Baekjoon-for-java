import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr= new int[N];
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int result = binarySearch(arr, 0, arr[N-1], M);
        System.out.println(result-1);

    }
    public static int binarySearch(int arr[], int low, int high, int M){
        int mid = 0;
        while(low<high){
            mid = (low+ high)/2;
            long sum = 0;
            for(int i=0; i<arr.length; i++){
                if(arr[i]>mid){
                    sum += arr[i]-mid;
                }
            }if (sum<M) {
                high = mid;
            }
            else{
                low = mid+1;
            }

        }
        return low;
    }

}

