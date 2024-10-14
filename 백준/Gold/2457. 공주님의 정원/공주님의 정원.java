import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Flower[] flowers = new Flower[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            flowers[i] = new Flower(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
        }
        Arrays.sort(flowers, (f1, f2) -> Integer.compare(f2.end, f1.end));

        int last = 1201;
        int count = 0;
        int idx = 0;
        while (idx < N) {
            int past = last;
            boolean isNew = false;
            while (idx < N && flowers[idx].end >= last) {
                int tmp = flowers[idx].start;
                if (tmp < past) {
                    past = tmp;
                    isNew = true;
                }
                idx++;
            }
            if (!isNew) {
                System.out.println(0);
                return;
            }
            last = past;
            count++;

            if (last <= 301) {
                System.out.println(count);
                return;
            }
        }
        System.out.println(0);
    }
}
class Flower {
    int start;
    int end;

    Flower(int startM, int startD, int endM, int endD) {
        this.start = startM * 100 + startD;
        this.end = endM * 100 + endD;
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
적은 개수=넓은 구간=마감은 미래, 시작은 과거
특정 시점을 포함하고 시작이 제일 먼곳
마감이 last보다 미래인 녀석들까지 돌면서 시작일이 제일 과거인녀석 픽. last 갱신은 마감일자가 last 보다 과거가 되었을때.
---
우선순위큐 시간초과
-> 일반 리스트로 받은 후 모든 입력 받은 후 한번만 정렬
-> 리스트를 배열로
-> Localdate를 int로
---
-> 종료 조건 명확하지 않아서 무한루프 발생한거였음..
 */