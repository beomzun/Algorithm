import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int craneNum = Integer.parseInt(br.readLine());
        ArrayList<Integer> craneList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < craneNum; i++) {
            craneList.add(Integer.parseInt(st.nextToken()));
        }
        craneList.sort(Collections.reverseOrder());

        int boxNum = Integer.parseInt(br.readLine());
        ArrayList<Integer> boxList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < boxNum; i++) {
            boxList.add(Integer.parseInt(st.nextToken()));
        }
        boxList.sort(Collections.reverseOrder());

        if (craneList.get(0) < boxList.get(0)) {
            bw.write(-1 + "");
            bw.flush();
            bw.close();
            return;
        }

        int idx;
        int min = 0;
        while (!boxList.isEmpty()) {
            idx = 0;
            for (int i = 0; i < craneNum; i++) {
                if (boxList.isEmpty() || boxList.size() <= idx) {
                    break;
                } else if (craneList.get(i) >= boxList.get(idx)) {
                    boxList.remove(idx);
                } else {
                    i--;
                    idx++;
                }
            }
            min++;
        }
        bw.write(min + "");
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