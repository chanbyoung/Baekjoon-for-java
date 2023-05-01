import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] arr;
    static int cnt_minusOne =0;
    static int cnt_zero=0;
    static int cnt_plusOne= 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i<N; i++){
            String[] temp = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(temp[j]);
            }
        }
        //값 넣기 완료
        divide(0,0,N);
        System.out.println(cnt_minusOne);
        System.out.println(cnt_zero);
        System.out.println(cnt_plusOne);

    }
    public static void divide(int row, int col, int size){
        if(colorCheck(row,col,size)){
            if(arr[row][col] == -1){
                cnt_minusOne++;
            }
            else if(arr[row][col] == 0)
                cnt_zero++;
            else cnt_plusOne++;
        }
        else {
            int newSize = size / 3;
            divide(row, col, newSize);
            divide(row, col + newSize, newSize);
            divide(row, col + 2 * newSize, newSize);

            divide(row + newSize, col, newSize);
            divide(row + newSize, col + newSize, newSize);
            divide(row + newSize, col + 2 * newSize, newSize);

            divide(row + 2 * newSize, col, newSize);
            divide(row + 2 * newSize, col + newSize, newSize);
            divide(row + 2 * newSize, col + 2 * newSize, newSize);
        }
    }
    public static boolean colorCheck(int row, int col, int size){
        int color = arr[row][col];
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(color != arr[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}