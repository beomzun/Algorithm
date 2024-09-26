import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] knowTruth = new boolean[N + 1];
        boolean[] visit = new boolean[N + 1];
        boolean[] lieParty = new boolean[M + 1];
        Arrays.fill(lieParty, true);
        int canLie = M;

        ArrayList<Integer>[] participate = new ArrayList[N + 1];    //각 사람별 참가한 파티
        ArrayList<Integer>[] atParty = new ArrayList[M + 1];    //각 파티별 속한 사람들

        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        if (num > 0) {
            while (st.hasMoreTokens()) {
                knowTruth[Integer.parseInt(st.nextToken())] = true;
            }
        }

        for (int i = 1; i <= N; i++) {
            participate[i] = new ArrayList<>();
        }
        for (int i = 1; i <= M; i++) {
            atParty[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int personNum = Integer.parseInt(st.nextToken());
                atParty[i].add(personNum);
                participate[personNum].add(i);
            }
        }

        Queue<Integer> truePeople = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            // 진실을 알고, 방문되지 않은 사람
            if (knowTruth[i] && !visit[i]) {
                visit[i] = true;
                truePeople.add(i);
            }
        }

        while(!truePeople.isEmpty()) {
            int now = truePeople.remove();
            // 해당 사람이 방문한 파티 out
            for (int partyNum : participate[now]) {
                if (lieParty[partyNum]) {
                    lieParty[partyNum] = false;
                    canLie--;
                    // 해당 파티의 다른 사람들
                    for (int personNum : atParty[partyNum]) {
                        if (!visit[personNum]) {
                            visit[personNum] = true;
                            truePeople.add(personNum);
                        }
                    }
                }
            }
        }
        System.out.println(canLie);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
진실을 아는 사람이 속한 파티는 out. 해당 파티에 속한 다른 사람들이 속한 파티도 out.
1. 각 사람별 파티 배열 -> 해당 사람이 속한 파티 out 위함.
2. 파티에 속한 사람 배열 -> out된 파티에 속한 다른 사람들의 파티 Out 위함.
 */