import static java.lang.Integer.MAX_VALUE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int user = Integer.parseInt(st.nextToken());
        int edge = Integer.parseInt(st.nextToken());
        //edge
        int a,b;
        ArrayList<Integer>[] arr = new ArrayList[user + 1];
        for (int i = 1; i <= user; i++) {
            arr[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            arr[a].add(b);
            arr[b].add(a);
        }
        //케빈 베이컨
        int node = 1;
        int min = MAX_VALUE;
        int sum;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= user; i++) {
            sum = 0;
            //각 노드까지의 최소 거리
            int[] count = new int[user + 1];

            boolean[] visit = new boolean[user + 1];
            queue.add(i);
            visit[i] = true;

            while (!queue.isEmpty()) {
                int idx = queue.remove();
                for (int j = 0; j < arr[idx].size(); j++) {
                    if (!visit[arr[idx].get(j)]) {
                        visit[arr[idx].get(j)] = true;
                        count[arr[idx].get(j)] = count[idx] + 1;
                        queue.add(arr[idx].get(j));
                    }
                }
            }
            for (int j : count) {
                sum += j;
            }
            if (sum < min) {
                node = i;
                min = sum;
            }
        }
        bw.write(String.valueOf(node));
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