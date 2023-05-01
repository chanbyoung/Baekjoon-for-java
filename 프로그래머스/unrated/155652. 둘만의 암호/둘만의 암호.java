import java.util.*;
class Solution {
          public static String solution(String s, String skip, int index) {
        char[] word = s.toCharArray();
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0; i<skip.length(); i++){
            char w = skip.charAt(i);
            list.add((int)w);
        }
        for(int i =0; i< word.length;i ++){
            int word_num = word[i];
            for(int j=0; j<index; j++){
                word_num++;
                if(word_num> 122){
                    word_num = 97;
                }
                while(list.contains(word_num)){
                    word_num++;
                    if(word_num> 122){
                        word_num = 97;
                    }
                }
            }
            answer += (char)word_num;
        }
        return answer;
    }
}