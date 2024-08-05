import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int students = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            boolean[] team = new boolean[students + 1];
            boolean[] visit = new boolean[students + 1];
            int[] want = new int[students + 1];
            for (int j = 1; j <= students; j++) {
                want[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <= students; j++) {
                if (!team[j] && !visit[j]) {
                    Queue<Integer> queue = new LinkedList<>();
                    Queue<Integer> teamList = new LinkedList<>();

                    queue.add(j);
                    teamList.add(j);
                    visit[j] = true;

                    while(!queue.isEmpty()) {
                        int tmp = want[queue.remove()];
                        if (visit[tmp]) {
                            while (!teamList.isEmpty()) {
                                if (tmp != teamList.peek()) {
                                    teamList.remove();
                                } else {
                                    break;
                                }
                            }
                            while(!teamList.isEmpty()) {
                                team[teamList.remove()] = true;
                            }
                            break;
                        } else {
                            queue.add(tmp);
                            teamList.add(tmp);
                            visit[tmp] = true;
                        }
                    }
                }
            }

            int count = 0;
            for (int j = 1; j <= students; j++) {
                if (team[j]) {
                    count++;
                }
            }
            bw.write(students - count + "\n");
        }
        bw.flush();
        bw.close();
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
