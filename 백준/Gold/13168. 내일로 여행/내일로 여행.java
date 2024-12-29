import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        Map<String, Integer> cities = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            String s = st.nextToken();
            if (cities.containsKey(s)) {
                continue;
            }
            cities.put(s, count);
            count++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        String[] visiting = new String[M];
        for (int i = 0; i < M; i++) {
            visiting[i] = st.nextToken();
        }

        int K = Integer.parseInt(br.readLine());
        long[][] dis = new long[count][count];
        double[][] discountDis = new double[count][count];
        long INF = Integer.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            Arrays.fill(dis[i], INF);
            dis[i][i] = 0;
            Arrays.fill(discountDis[i], INF);
            discountDis[i][i] = 0;
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            String kind = st.nextToken();
            String start = st.nextToken();
            String end = st.nextToken();
            int cost = Integer.parseInt(st.nextToken());
            dis[cities.get(start)][cities.get(end)] = Math.min(dis[cities.get(start)][cities.get(end)], cost);
            dis[cities.get(end)][cities.get(start)] = Math.min(dis[cities.get(end)][cities.get(start)], cost);

            double discountCost = cost;
            if (kind.equals("Mugunghwa") || kind.equals("ITX-Saemaeul") || kind.equals(
                    "ITX-Cheongchun")) {
                discountCost = 0;
            } else if (kind.equals("S-Train") || kind.equals("V-Train")) {
                discountCost = (double) cost / 2;
            }
            discountDis[cities.get(start)][cities.get(end)] = Math.min(discountDis[cities.get(start)][cities.get(end)], discountCost);
            discountDis[cities.get(end)][cities.get(start)] = Math.min(discountDis[cities.get(end)][cities.get(start)], discountCost);
        }

        for (int k = 0; k < count; k++) {
            for (int i = 0; i < count; i++) {
                for (int j = 0; j < count; j++) {
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    discountDis[i][j] = Math.min(discountDis[i][j], discountDis[i][k] + discountDis[k][j]);
                }
            }
        }

        long result = 0L;
        for (int i = 1; i < M; i++) {
            result += dis[cities.get(visiting[i - 1])][cities.get(visiting[i])];
        }

        double ticketResult = 0L;
        for (int i = 1; i < M; i++) {
            ticketResult += discountDis[cities.get(visiting[i - 1])][cities.get(visiting[i])];
        }
        ticketResult += R;

        if (ticketResult < result) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}