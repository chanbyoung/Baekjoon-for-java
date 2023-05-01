import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T --> 0){
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            int k = Integer.parseInt(br.readLine());
            while (k --> 0){
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String str = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if(str.equals("I")){
                    treeMap.put(n, treeMap.getOrDefault(n,0)+1);
                    //getOrDefault -> 찾는 키의 키의 값을 반환, 키에 입력값으로 들어온 개수를 세어줌
                }
                else {
                    if(!treeMap.isEmpty()){
                        if(n == -1){
                            int minKey = treeMap.firstKey();
                            if(treeMap.get(minKey) == 1){
                                treeMap.remove(minKey);
                            }
                            else {
                                treeMap.put(minKey, treeMap.get(minKey)- 1);
                            }
                        }
                        else {
                            int maxKey = treeMap.lastKey();
                            if(treeMap.get(maxKey)==1){
                                treeMap.remove(maxKey);
                            }
                            else {
                                treeMap.put(maxKey, treeMap.get(maxKey)-1);
                            }
                        }
                    }
                }

            }
            if (treeMap.isEmpty()){
                System.out.println("EMPTY");
            }
            else {
                System.out.println(treeMap.lastKey()+" "+treeMap.firstKey());
            }
        }

    }
}