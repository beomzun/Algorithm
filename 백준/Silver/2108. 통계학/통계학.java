import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

    int[] arr = new int[8001];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //산술평균
        double sum = 0;
        //중앙값
        int count = 0;
        int mid;
        //최빈값
        int fre = 0;
        //범위
        int range;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(br.readLine());
            arr[val + 4000]++;

            if (val < min) {
                min = val;
            }
            if (val > max) {
                max = val;
            }

            sum += val;
        }

        //산술평균
        sum = sum / n;
//        String avg = String.format("%.0f", sum);
        int avg = (int) Math.round(sum);
        bw.write(avg + "\n");
        //중앙값
        int i = 0;
        while (count <= n/2) {
            count += arr[i++];
        }
        mid = i - 4001;
        bw.write(mid + "\n");
        //최빈값
        boolean same = false;
        for (i = 1; i < arr.length; i++) {
            if (arr[i] > arr[fre]) {
                fre = i;
                same = false;
            } else if (arr[i] == arr[fre]) {
                if (!same) {
                    fre = i;
                    same = true;
                }
            }
        }
        bw.write(fre - 4000 + "\n");
        //범위
        range = max - min;
        bw.write(range + "\n");

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
