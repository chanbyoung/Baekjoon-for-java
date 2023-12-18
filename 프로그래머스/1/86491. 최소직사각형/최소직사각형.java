class Solution {
    public int solution(int[][] sizes) {
        int row = 0;
        int col = 0;
        for (int[] size : sizes) {
            int newR = 0;
            int newC = 0;
            if (size[0] >= size[1]) {
                newR = size[0];
                newC = size[1];
            } else {
                newR = size[1];
                newC = size[0];
            }

            if (newR > row) {
                row =newR;
            }
            if (newC > col) {
                col = newC;
            }
        }
        
        return row*col;
    }
}