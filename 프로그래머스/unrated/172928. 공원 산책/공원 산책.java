class Solution {
public static int[] solution(String[] park, String[] routes) {
        String arr[][] = new String[park.length][park[0].length()];
        int x =0;
        int y= 0;
        for(int i=0; i<park.length ; i++){
            String[] arr2 = park[i].split("");
            for(int j=0; j<arr2.length; j++){
                if(arr2[j].equals("S")){
                    x=i;
                    y=j; // 현재 위치 저장
                }
                arr[i][j] = arr2[j];
            }
        }
        for(int i=0; i< routes.length; i++) {
            String[] cmd = routes[i].split(" ");
            int num = Integer.parseInt(cmd[1]);
            boolean flag = true;
            if (cmd[0].equals("E")) {
                if (y + num < arr[0].length) {
                    for(int j=1; j<=num; j++){
                        if(arr[x][y+j].equals("X")){
                            flag =false;
                        }
                    }
                    if(flag) {
                        y = y + num;
                    }
                }
            } else if (cmd[0].equals("W")) {
                if (0 <= y - num) {
                    for(int j=1; j<=num; j++){
                        if(arr[x][y-j].equals("X")){
                            flag =false;
                        }
                    }
                    if(flag) {
                        y = y - num;
                    }
                }
            } else if (cmd[0].equals("N")) {
                if (0 <= x - num) {
                    for(int j=1; j<=num; j++){
                        if(arr[x-j][y].equals("X")){
                            flag =false;
                        }
                    }
                    if(flag) {
                        x = x - num;
                    }
                }
            } else if (cmd[0].equals("S")) {
                if (x + num < arr.length ) {
                    for(int j=1; j<=num; j++){
                        if(arr[x+j][y].equals("X")){
                            flag =false;
                        }
                    }
                    if(flag) {
                        x = x + num;
                    }
                }
            }

        }
        int[] result = new int[2];
        result[0]= x;
        result[1]= y;
        return result;
    }
}