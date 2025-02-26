import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사람 수
        int m = Integer.parseInt(st.nextToken()); // 파티 수

        Map<Integer, Integer> know = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken()); // 진실을 아는 사람 수
        for (int j = 0; j < i; j++) {
            know.put(Integer.parseInt(st.nextToken()), 0);
        }

        List<Set<Integer>> partyList = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            Set<Integer> party = Arrays.stream(br.readLine().split(" "))
                    .skip(1)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
            partyList.add(party);
        }

        // 진실을 전달하는 과정 (전파)
        boolean updated;
        do {
            updated = false;
            for (Set<Integer> party : partyList) {
                // 현재 파티에 진실을 아는 사람이 있는지 확인
                boolean hasKnownPerson = party.stream().anyMatch(know::containsKey);
                if (hasKnownPerson) {
                    // 현재 파티의 모든 사람을 know에 추가
                    for (Integer person : party) {
                        if (!know.containsKey(person)) {
                            know.put(person, 0);
                            updated = true; // 새로운 사람이 추가되었으므로 한 번 더 반복해야 함
                        }
                    }
                }
            }
        } while (updated); // 새로운 사람이 추가될 때까지 계속 반복

        // 거짓말할 수 있는 파티 개수 계산
        int sum = 0;
        for (Set<Integer> party : partyList) {
            if (party.stream().noneMatch(know::containsKey)) {
                sum++;
            }
        }

        System.out.println(sum);
    }
}