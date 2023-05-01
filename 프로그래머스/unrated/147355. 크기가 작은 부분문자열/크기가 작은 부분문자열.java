class Solution {
    public static int solution(String t, String p) {
        int cnt =0;
        for(int i=0; i<=t.length()- p.length(); i++) {
            Long i1 =  Long.parseLong(p);
            Long i2 =  Long.parseLong(t.substring(i, i + p.length()));
            if(i1>=i2) cnt +=1;
        }
        return cnt;
    }
}