class Solution {

    public boolean solution(int x) {
        String[] split = String.valueOf(x).split("");
        int sum = 0;
        for (String s : split) {
            sum += Integer.parseInt(s);
        }
        if (x%sum == 0) {
            return true;
        }
        return false;
    }
}