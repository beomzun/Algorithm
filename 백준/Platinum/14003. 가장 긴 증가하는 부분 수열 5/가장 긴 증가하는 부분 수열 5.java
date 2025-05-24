import java.util.*;
import java.io.*;

class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] base = new int[N];    //입력받은 그대로
        int[] set = new int[N];     //큰놈을 대체한 오름차순배열
        int[] index = new int[N];   //몇번째 인덱스에 들어갔는가

        int val = Integer.parseInt(st.nextToken());
        base[0] = val;
        set[0] = val;
        index[0] = 0;

        int setIdx = 0;
        for(int i=1;i<N;i++) {
            val = Integer.parseInt(st.nextToken());
            base[i] = val;
            //제일 큰 경우
            if(val > set[setIdx]) {
                set[++setIdx] = val;
                index[i] = setIdx;
                continue;
            }
            //중간인 경우
            if(val <= set[setIdx]) {
                int left = 0;
                int right = setIdx;
                while(left<right) {
                    int mid = (left+right)/2;
                    if(val < set[mid]) {
                        right = mid;
                    } else if(val>set[mid]) {
                        left = mid+1;
                    } else {
                        left = mid;
                        break;
                    }
                }
                set[left] = val;
                index[i] = left;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(setIdx+1).append("\n");

        Stack<Integer> stack = new Stack<>();
        for(int i=N-1;i>=0;i--) {
            if(index[i]==setIdx) {
                stack.add(base[i]);
                setIdx--;
            }
        }
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*
set으로 하던것처럼 앞의 큰놈 대체하는데, 대신 map으로 몇번째 인덱스를 대신했는지 표기
count 제일 큰놈부터 시작 -> map에서는 내 앞쪽중에서 순서대로 볼 수 없음.
---
입력, set, 인덱스 3개의 배열 사용
set배열 : Treeset과 같이 오름차순배열 관리
인덱스 배열 : 입력배열이 set에서 몇번째 순서에 들어갔는지 관리
이를 통해 제일 큰 인덱스를 갖는 인덱스배열부터 시작해서 제일 마지막에 해당 인덱스에 저장된 녀석으로 스택 구성
 */