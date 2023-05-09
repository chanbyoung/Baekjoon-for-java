class Solution {
    public static String solution(int[] food) {
        String result = "0";
        for(int i=food.length-1; i>=0; i--){
            int n = food[i]/2;
            String a = "";
            for(int j=0; j<n; j++){
                a += String.valueOf(i);
            }
            result = a+result+a;
        }
        return result;
    }
}