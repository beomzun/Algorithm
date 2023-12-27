import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Solution {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int count = Integer.parseInt(br.readLine());

        //각 테스트 케이스
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            //문서 개수
            int n = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];
            //궁금한 문서 번호
            int key = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            //문서별 중요도
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            //출력 순서 계산
            int order = 1;
            int maxIndex = 0;
            for (int j = 0; j < n; j++) {
                int max = 0;
                int index = maxIndex;
                for (int k = 0; k < n; k++, index++) {
                    if (index == n) {
                        index = 0;
                    }
                    if (arr[index] > max) {
                        max = arr[index];
                        maxIndex = index;
                    }
                }
                if (maxIndex != key) {
                    arr[maxIndex] = 0;
                    order++;
                } else {
                    bw.write(order + "\n");
                    break;
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
