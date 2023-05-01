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
        Map<String, Integer> noListen = new HashMap<>();
        TreeMap<String, Integer> noListenSee = new TreeMap<>();
        for(int i=0; i<N; i++){
            noListen.put(br.readLine(),i);
        }
        for(int i = 0; i<M;i++){
            String name = br.readLine();
            if(noListen.containsKey(name)){
                noListenSee.put(name,i);
            }
        }
        System.out.println(noListenSee.size());
        for (String s : noListenSee.keySet()) {
            System.out.println(s);
        }
    }
}
