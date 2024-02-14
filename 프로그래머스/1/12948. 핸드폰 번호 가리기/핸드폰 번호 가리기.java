class Solution {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < phone_number.length() - 4; i++) {
            answer.append("*");
        }
        String substring = phone_number.substring(phone_number.length() - 4, phone_number.length());
        answer.append(substring);
        return answer.toString();
    }
}