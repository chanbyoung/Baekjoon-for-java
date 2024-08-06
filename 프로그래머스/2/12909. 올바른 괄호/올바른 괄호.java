import java.util.*;

class Solution { 
  boolean solution(String s) {
    int openCount = 0; // Counter to keep track of open parentheses
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') {
            openCount++;
        } else {
            openCount--;
            if (openCount < 0) {
                return false; // More closing parentheses than opening
            }
        }
    }
    return openCount == 0; // True if all open parentheses are matched
}
}