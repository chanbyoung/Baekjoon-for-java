import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        for(int i = M; i<=N; i++){
            boolean result = primeNumber(i);
            if(result == true){
                System.out.println(i);
            }
        }
    }

    public static boolean primeNumber(int n) {
        if(n <= 1){
            return false;
        } else if (n%2 == 0) {
            boolean re = (n==2) ? true : false;
            return  re;
        }
        else {
            int cnt = 0;
            for (int i = 3; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    cnt++;
                    break;
                }
            }
            if (cnt > 0) {
                return false;
            } else {
                return true;
            }
        }
    }
}

