import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        while(N --> 0){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                if (heap.isEmpty()){
                    System.out.println(0);
                }
                else {
                    System.out.println(heap.peek()[1]);
                    heap.poll();
                }
            }
            else {
                heap.add(new int[]{Math.abs(n), n});
            }
        }

    }
}