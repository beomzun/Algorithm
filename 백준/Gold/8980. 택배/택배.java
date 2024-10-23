import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        ArrayList<int[]> boxes = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int sendNum = Integer.parseInt(st.nextToken());
            int receiveNum = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            boxes.add(new int[]{sendNum, receiveNum, size});
        }
        boxes.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int result = 0;
        int last = 1;
        int[] town = new int[N + 1];
        for(int[] box : boxes) {
            int send = box[0];
            int rec = box[1];
            int size = box[2];

            for (int i = last; i <= send; i++) {
                result += town[i];
                town[i] = 0;
            }
            last = send;

            int total = 0;
            for (int i = send; i < rec; i++) {
                total += town[i];
                if (total >= C) {
                    break;
                }
            }
            if (total < C) {
                town[rec] += size;
                for (int i = rec; i <= N; i++) {
                    total += town[i];
                    if (total >= C) {
                        town[i] -= (total - C);
                        Arrays.fill(town, i + 1, N + 1, 0);
                        break;
                    }
                }
            }
        }
        for (int i = last; i <= N; i++) {
            result += town[i];
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
빨리 내릴수 있는게 우선순위. 우선순위에서 밀린 && 넘친 애들 버림
 */