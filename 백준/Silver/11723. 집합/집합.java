import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            String[] st = br.readLine().split(" ");
            if(st[0].equals("add")){
                set.add(Integer.parseInt(st[1]));
            } else if (st[0].equals("remove")) {
                set.remove(Integer.parseInt(st[1]));
            }
            else if(st[0].equals("check")){
                int n = Integer.parseInt(st[1]);
                if(set.contains(n)==true){
                    sb.append(1+"\n");
                }
                else sb.append(0+"\n");
            }
            else if(st[0].equals("toggle")){
                int n = Integer.parseInt(st[1]);
                if(set.contains(n)==true){
                    set.remove(n);
                }
                else set.add(n);
            }
            else if(st[0].equals("all")){
                set.clear();
                for(int j=1; j<=20; j++) set.add(j);
            }
            else if(st[0].equals("empty")){
                set.clear();
            }
        }
        System.out.print(sb);
    }

}
