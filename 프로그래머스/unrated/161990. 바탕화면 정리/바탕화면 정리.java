import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
class Solution {
      public static int[] solution(String[] wallpaper) {
        int x1= 0, y1=0, x2=0, y2=0;
        List<Integer> listX = new ArrayList<>();
        List<Integer> listY = new ArrayList<>();
        for(int i=0; i<wallpaper.length;i++){
            String[] str = wallpaper[i].split("");
            for(int j=0; j<str.length; j++){
                if(str[j].equals("#")){
                    listX.add(i);
                    listY.add(j);
                }
            }
        }
        Collections.sort(listX);
        Collections.sort(listY);
        int[] result = new int[4];
        result[0] = listX.get(0);
        result[1] = listY.get(0);
        result[2] = listX.get(listX.size()-1)+1;
        result[3] = listY.get(listY.size()-1)+1;
        return result;
    }
}