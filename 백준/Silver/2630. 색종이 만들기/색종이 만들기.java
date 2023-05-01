import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int blue =0;
    static int white=0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        //값 넣기 완료
        divide(0,0,N);
        System.out.println(white);
        System.out.println(blue);
    }
    public static void divide(int row,int col,int size){
        if(colorCheck(row, col, size)){
            int temp = arr[row][col];
            if(temp == 0) {
                white++;
            }
            else blue++;
        }
        else{
            int newSize = size/2;
            divide(row, col, newSize);
            divide(row, col+newSize, newSize);
            divide(row+newSize, col, newSize);
            divide(row+newSize,col+newSize, newSize);
        }
    }
    public static boolean colorCheck(int row, int col, int size){
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(arr[i][j] != arr[row][col])
                    return false;
            }
        }
        return true;
    }
}