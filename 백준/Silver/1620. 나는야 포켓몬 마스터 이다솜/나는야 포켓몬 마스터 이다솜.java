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
        HashMap<Integer, String> pokemon = new HashMap<>();
        HashMap<String, Integer> pokemon2 = new HashMap<>();

        for(int i =1; i<=N; i++){
            String name = br.readLine();
            pokemon.put(i, name);
            pokemon2.put(name,i);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M;i++){
            String m = br.readLine();
            if((int)m.charAt(0)<=90 && 65<=(m.charAt(0))
                || (int)m.charAt(0)<=122 && 97<=(m.charAt(0))){
                sb.append(pokemon2.get(m)+"\n");
            }
            else sb.append(pokemon.get(Integer.parseInt(m))+"\n");
        }
        System.out.println(sb);
    }

}
