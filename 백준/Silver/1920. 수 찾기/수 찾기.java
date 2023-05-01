import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for (int i = 0; i < N; i++) {
            arr1[i] = sc.nextInt();
        }
        Arrays.sort(arr1);
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for(int i=0; i<M; i++){
            int num = sc.nextInt();
            arr2[i] = binarySearch(arr1, num);
        }
        for (int i : arr2) {
            System.out.println(i);
        }

    }
    public static int binarySearch(int[] arr,int num){
        int start = 0;
        int end = arr.length-1 ;
        while (start <= end) {
            int mid =  (start+end)/2;
            if (arr[mid] > num) {
                end = mid-1;
            } else if (arr[mid] < num) {
                start = mid+1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}