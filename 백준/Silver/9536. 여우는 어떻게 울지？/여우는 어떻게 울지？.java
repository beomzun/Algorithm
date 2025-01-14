import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String[] crowling = br.readLine().split(" ");

            Set<String> sounds = new HashSet<>();
            while(true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String animal = st.nextToken();
                if (animal.equals("what")) {
                    break;
                }
                st.nextToken();
                sounds.add(st.nextToken());
            }
            
            for(String sound : crowling) {
                if (sounds.contains(sound)) {
                    continue;
                }
                sb.append(sound).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
