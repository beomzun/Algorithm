import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 1; i <= N; i++) {
            set.add(i);
        }

        ArrayList<int[]> assigns = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int reward = Integer.parseInt(st.nextToken());
            assigns.add(new int[]{deadLine, reward});
        }
        assigns.sort((o1, o2) -> o2[1] - o1[1]);

        int result = 0;
        for (int[] assign : assigns) {
            Integer when = set.floor(assign[0]);
            if (when == null) {
                continue;
            }
            set.remove(when);
            result += assign[1];
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
7
2 : 1 7
//1 : 1 6
6 : 2 5
//5 : 2 4
3 : 3 2
//4 : 3 1
7 : 6 1
 */