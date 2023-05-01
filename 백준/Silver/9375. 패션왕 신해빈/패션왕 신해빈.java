import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while(T --> 0){
            HashMap<String, Integer> wear = new HashMap<>(); //옷의 종류와 개수
            int n = Integer.parseInt(br.readLine());
            while(n -->0) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken(); // 옷의 이름은 필요 없음
                String type = st.nextToken();
                if(wear.containsKey(type)){
                    wear.put(type, wear.get(type)+1);
                }
                else wear.put(type, 1);
            }
            int sum = 1;
            for (Integer value : wear.values()) {
                sum *= (value+1);
            }
            System.out.println(sum-1);

        }
    }
}
