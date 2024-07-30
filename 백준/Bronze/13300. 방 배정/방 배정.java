import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int size = Integer.parseInt(st.nextToken());

        int[] room = new int[14];
        for (int i = 0; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            room[sex + grade * 2]++;
        }

        int count = 0;
        for (int i = 2; i < 14; i++) {
            if (room[i] != 0) {
                count += room[i] / size;
                if (room[i] % size != 0) {
                    count++;
                }
            }
        }

        bw.write(count + "");
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
/**
 * 성별 0,1 | + 1~6 학년 *2
 * 2,3 \ 4,5 \ 6,7 \ 12,13
 */