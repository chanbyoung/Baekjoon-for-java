import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Map<String, Integer> wordMap = new HashMap<>();
        for(int i = 0; i<N; i++){
            String word = sc.next();
            wordMap.put(word,word.length());
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(wordMap.entrySet());
        entryList.sort(Map.Entry.comparingByKey());
        entryList.sort(Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey());
        }
    }
}