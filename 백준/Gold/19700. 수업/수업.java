import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<int[]> students = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            students.add(new int[]{h, k});
        }
        students.sort((o1, o2) -> o2[0] - o1[0]);

        TreeMap<Integer, Integer> teamsCount = new TreeMap<>();
        int result = 0;
        for (int[] student : students) {
            Integer groupCount = teamsCount.lowerKey(student[1]);
            if (groupCount == null) {
                teamsCount.put(1, teamsCount.getOrDefault(1, 0) + 1);
                result++;
            } else {
                if (teamsCount.get(groupCount) == 1) {
                    teamsCount.remove(groupCount);
                } else {
                    teamsCount.replace(groupCount, teamsCount.get(groupCount) - 1);
                }
                teamsCount.put(groupCount + 1, teamsCount.getOrDefault(groupCount + 1, 0) + 1);
            }
        }
        System.out.println(result);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
키 내림차순 정렬. 등수에 들고 싶으면 등수-1만큼 있으면 됨
---
들어갈 수 있는 팀 중 가장 사람 많이 찬 그룹에 들어가야함. 작은데 자존심이 강한친구가 나중에 나올수도 있으므로.
 */