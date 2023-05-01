import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> password = new HashMap<>();
        for(int i= 0; i<N; i++){
            st = new StringTokenizer(br.readLine()," ");
            password.put(st.nextToken(), st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            String address = br.readLine();
            sb.append(password.get(address));
            sb.append("\n");
        }
        System.out.print(sb);
    }

}
