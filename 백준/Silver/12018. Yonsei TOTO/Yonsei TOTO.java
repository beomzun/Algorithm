import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   //과목 수
        int M = Integer.parseInt(st.nextToken());   //초기 마일리지
        int[] buy = new int[N];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());   //신청 수
            int l = Integer.parseInt(st.nextToken());   //가능인원
            Integer[] arr = new Integer[p];

            st = new StringTokenizer(br.readLine());
            for(int j=0;j<p;j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr, Collections.reverseOrder());

            if(p<l) {
                buy[i] = 1;
                continue;
            }
            buy[i] = arr[l - 1];
        }

        Arrays.sort(buy);

        int count = 0;
        for(int cost : buy) {
            if(M-cost >=0) {
                M-=cost;
                count++;
                continue;
            }
            break;
        }

        System.out.println(count);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
수강신청이 경매방식임 - 신청할때는 최소1점은 넣어야함
첫 줄 - 과목 수와 주어진 마일리지
다음부터 - 한 과목마다 두줄입력
각 과목에 신청한 사람 수와 수강인원 L \ 각 사람이 마일리지 얼마나 부엇나
마일리지가 같으면 내가 우선ㅎ
---
주어진 마일리지로 최대로 들을수있는 과목수
---
각 과목별로 가능인원수까지만 정렬해서 마지막이랑 같은만큼의 마일리지를 저장
모든 과목에 대해 저장끝나면 싼녀석부터 매수
 */