import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String word = br.readLine();
        String str="";
        for(int i=0;i<N;i++){
            str = str+"IO";
        }
        str= str+"I";
        int cnt = 0;
        for(int i = 0; i<M; i++){
            if(i+N*2+1>M){
                break;
            }
            String word2 = word.substring(i,i+N*2+1);
            if(word2.equals(str)){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}