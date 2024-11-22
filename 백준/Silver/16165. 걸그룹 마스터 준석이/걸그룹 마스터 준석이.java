import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, String> nameKey = new HashMap<>();
        Map<String, List<String>> groupKey = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String group = br.readLine();
            int num = Integer.parseInt(br.readLine());
            List<String> nameList = new ArrayList<>();
            for (int j = 0; j < num; j++) {
                String name = br.readLine();
                nameKey.put(name, group);
                nameList.add(name);
            }
            groupKey.put(group, nameList);
        }

        for (int i = 0; i < M; i++) {
            String question = br.readLine();
            int kind = Integer.parseInt(br.readLine());
            if (kind == 1) {
                bw.write(nameKey.get(question) + "\n");
            } else {
                List<String> answer = groupKey.get(question);
                Collections.sort(answer);
                for (String name : answer) {
                    bw.write(name + "\n");
                }
            }
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
