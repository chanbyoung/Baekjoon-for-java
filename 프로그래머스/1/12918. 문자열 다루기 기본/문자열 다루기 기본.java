class Solution {
    public boolean solution(String s) {
        boolean answer = false;
        if (s.length() == 4 || s.length() == 6) {
            try {
                Integer i = Integer.valueOf(s);
                answer = true;
            } catch (Exception e){
                
            }
        }
        return answer;
    }
}