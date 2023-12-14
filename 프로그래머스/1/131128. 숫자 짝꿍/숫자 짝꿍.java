class Solution {
public  String solution(String X, String Y) {
    String answer = "";
    int[] A = new int[10];
    int[] B = new int[10];

    for (char c : X.toCharArray()) {
        A[c - '0']++;
    }
    for (char c : Y.toCharArray()) {
        B[c - '0']++;
    }

    StringBuilder answerBuilder = new StringBuilder();

    for (int i = 9; i >= 0; i--) {
        int min = Math.min(A[i], B[i]);
        if (min > 0) {
            if (i == 0 && answerBuilder.length() == 0) {
                answerBuilder.append(0);
                break;
            }
            for (int j = 0; j < min; j++) {
                answerBuilder.append(i);
            }
        }
    }

    if (answerBuilder.length() == 0) {
        return "-1";
    }

    return answerBuilder.toString();
}
}