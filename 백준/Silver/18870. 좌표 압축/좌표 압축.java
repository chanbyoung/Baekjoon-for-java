import javax.swing.tree.TreeCellRenderer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] arr2= new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i<N; i++){
            arr2[i] = arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int cnt = 0;
        for(int i = 0; i<N; i++){
            if(!hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], cnt);
                cnt++;
            }
        }
        for(int i =0 ; i<N;i++){
            sb.append(hashMap.get(arr2[i])+" ");
        }
        System.out.print(sb);
    }
}