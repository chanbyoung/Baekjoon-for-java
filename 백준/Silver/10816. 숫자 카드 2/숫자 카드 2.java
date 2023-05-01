import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arrN = new int[N];
        for(int i =0; i<N; i++)
            arrN[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arrN);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<M; i++){
            int key = Integer.parseInt(st.nextToken());
            sb.append(upperBound(arrN, key)- lowerBound(arrN, key)).append(" ");
        }
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int key){
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low+ high)/2;
            if(key <= arr[mid]){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }
        return low;
    }
    private static int upperBound(int[] arr,int key){
        int low = 0;
        int high = arr.length;

        while(low<high) {
            int mid = (low + high) / 2;

            if (key < arr[mid]) {
                high = mid;
            }
            else{
                low =mid+1;
        }
        }
        return low;
    }
}



