import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer;
        Map<String, Integer> playerIndices = new HashMap<>();
        List<String> playerList = new ArrayList<>();

        for (String player : players) {
            playerList.add(player);
            playerIndices.put(player, playerList.size() - 1);
        }

        for (String calling : callings) {
            int index = playerIndices.get(calling);
            String frontRunner = playerList.get(index - 1);
            playerList.set(index - 1, playerList.get(index));
            playerList.set(index, frontRunner);

            playerIndices.put(frontRunner, index);
            playerIndices.put(playerList.get(index-1), index-1);
        }

        answer = playerList.toArray(new String[playerList.size()]);
        return answer;
    }
}