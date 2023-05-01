import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i =0; i<N; i++){
            String[] st= br.readLine().split("");
            for(int j = 0; j<N; j++){
                map[i][j] = Integer.parseInt(st[j]);
            }
        }
        divide(0,0,N);
    }
    public static void divide(int row, int col ,int size){
        if(check(row, col, size)){
            System.out.print(map[row][col]);
        }
        else{
            System.out.print("(");
            int newSize= size/2;
            divide(row, col, newSize);
            divide(row, col+newSize, newSize);
            divide(row+newSize, col, newSize);
            divide(row+ newSize, col+newSize, newSize);
            System.out.print(")");
        }
    }

    public static boolean check(int row , int col, int size){
        for(int i=row; i<row+size; i++){
            for(int j=col; j<col+size; j++){
                if(map[i][j] != map[row][col]) {
                    return false;
                }
            }
        }
        return true;

    }

}