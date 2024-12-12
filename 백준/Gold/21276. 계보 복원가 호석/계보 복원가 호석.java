import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, ArrayList<String>> graph = new HashMap<>();
        Map<String, Integer> counts = new HashMap<>();
        Map<String, ArrayList<String>> results = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String name = st.nextToken();
            graph.put(name, new ArrayList<>());
            results.put(name, new ArrayList<>());
            counts.put(name, 0);
        }
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();
            graph.get(parent).add(child);
            counts.replace(child, counts.get(child) + 1);
        }

        ArrayList<String> roots = new ArrayList<>();
        Queue<String> root = new ArrayDeque<>();
        for (String name : counts.keySet()) {
            if (counts.get(name) == 0) {
                roots.add(name);
                root.add(name);
            }
        }
        Collections.sort(roots);

        sb.append(roots.size()).append("\n");
        for (String name : roots) {
            sb.append(name).append(" ");
        }
        sb.append("\n");

        while(!root.isEmpty()) {
            String now = root.remove();
            for (String child : graph.get(now)) {
                int lastParentCount = counts.replace(child, counts.get(child) - 1);
                if (lastParentCount == 1) {
                    results.get(now).add(child);
                    root.add(child);
                    counts.remove(child);
                }
            }
        }
        for (String name : results.keySet()) {
            sb.append(name).append(" ").append(results.get(name).size()).append(" ");
            for (String child : results.get(name)) {
                sb.append(child).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
