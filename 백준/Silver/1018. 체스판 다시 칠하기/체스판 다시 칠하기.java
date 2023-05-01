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
        String[][] arr = new String[N][M];
        for(int i = 0; i< N; i++){
            arr[i] = br.readLine().split("");
        }
        //이중 배열에 값을 넣음
        int min = countArray(arr); // 초기값
        for(int i=0; i<=N-8; i++){
            for(int j = 0; j<=M-8; j++){
                String[][] copyArr = copyArr(arr, i, j);
                min = (min>countArray(copyArr)) ? countArray(copyArr) : min;
            }
        }
        System.out.println(min);
    }
    public static String[][] copyArr(String arr[][], int n, int m){
        String[][] copyArr= new String[8][8];
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                copyArr[i][j] = arr[i+n][j+m];
            }
        }
        return copyArr;
    }
    public static int countArray(String arr[][]){
        String[][] Barr = new String[8][8]; // 바둑판이 검정색으로 시작하는 경우
        String[][] Warr = new String[8][8]; // 바둑판이 하얀색으로 시작하는 경우

        for(int i = 0; i<8; i++){ //Barr 에 값을 넣음
            for(int j = 0; j <8 ; j++){
                if(i%2==0 && j%2==0) Barr[i][j] = "B";
                else if (i%2 == 0 && j%2 != 0) Barr[i][j]="W";
                else if (i%2 != 0 && j%2 == 0) Barr[i][j]="W";
                else Barr[i][j] = "B";
            }
        }

        for(int i = 0; i<8; i++){ //Barr 에 값을 넣음
            for(int j = 0; j <8 ; j++){
                if(i%2==0 && j%2==0) Warr[i][j] = "W";
                else if (i%2 == 0 && j%2 != 0) Warr[i][j]="B";
                else if (i%2 != 0 && j%2 == 0) Warr[i][j]="B";
                else Warr[i][j] = "W";
            }
        }
        int Bcnt= 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(arr[i][j].equals(Barr[i][j])){
                    continue;
                }
                else{
                    Bcnt++;
                }
            }
        }

        int Wcnt = 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(arr[i][j].equals(Warr[i][j])){
                    continue;
                }
                else{
                    Wcnt++;
                }
            }
        }
        int cnt = (Wcnt>Bcnt) ? Bcnt : Wcnt;
        return cnt;
    }
}



