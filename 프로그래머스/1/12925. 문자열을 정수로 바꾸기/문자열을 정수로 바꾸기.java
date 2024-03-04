class Solution {
    public int solution(String s) {
        if (s.contains("+")) {
            String replace = s.replace("+", "");
            return Integer.parseInt(replace);
        }
        if (s.contains("-")) {
            String replace = s.replace("-", "");
            return -Integer.parseInt(replace);
        }
        return Integer.parseInt(s);
    }
}