import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] num1 = br.readLine().split("-");
        int[] sum = new int[num1.length];
        for(int i = 0; i<num1.length; i++) {
            String[] num2 = num1[i].split("\\+");
            for (String s : num2) {
                sum[i] += Integer.parseInt(s);
            }
        }
        int result =  sum[0];
        for(int i=1; i<sum.length; i++){
            result -= sum[i];
        }
        System.out.println(result);


    }
}