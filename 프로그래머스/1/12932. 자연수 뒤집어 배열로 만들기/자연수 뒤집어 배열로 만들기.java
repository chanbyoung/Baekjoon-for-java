class Solution {
    public static int[] solution(long n) {
        String[] splitN = String.valueOf(n).split("");
        int[] answer = new int[splitN.length];
        for (int i = 0; i < splitN.length; i++) {
            answer[i] = Integer.parseInt(splitN[splitN.length-i-1]);
        }
        return answer;
    }
}