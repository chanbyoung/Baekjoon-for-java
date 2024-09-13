class Solution {
public static int[] solution(int n, long left, long right) {
    int[] result = new int[(int) (right - left) + 1];
    
    for (long i = left; i <= right; i++) {
        // i번째 요소가 2차원 배열에서 몇 번째 행(row)과 열(col)에 위치하는지 계산
        int row = (int) (i / n);
        int col = (int) (i % n);
        
        // Math.max(row, col) + 1이 해당 위치의 값이 된다
        result[(int) (i - left)] = Math.max(row, col) + 1;
    }
    
    return result;
}
}