import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r,c ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = 1;
        for(int i = 0; i< N; i++){
            n *=2;
        }
        int result = divide(0,0,n);
        System.out.println(result);
    }
    public static int divide(int row , int col , int size){
        if(size == 1){
            return 0;
        }
        int nSize = size/2;
        if(r<row+nSize && c<col+nSize) return divide(row,col, nSize); // 4부분으로 나눈 기준 왼쪽 위
        else if(r>=row+nSize && c<col+nSize) return divide(row+nSize, col, nSize)+(int)Math.pow(nSize,2)*2; //왼쪽 아래
        else if(r<row+nSize && c>=col+nSize) return divide(row, col+nSize, nSize)+(int)Math.pow(nSize,2); // 오른쪽 위
        else return divide(row+nSize, col+ nSize, nSize)+(int)Math.pow(nSize,2)*3; // 오른쪽 아래
    }

}