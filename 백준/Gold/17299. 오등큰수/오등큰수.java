import java.util.*;
import java.io.*;
class Solution {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] counts = new int[1_000_001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            int val = Integer.parseInt(st.nextToken());
            arr[i] = val;
            counts[val]++;
        }

        int[] answer = new int[N];
        //인덱스를 담았음.
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<N;i++) {
            //비교대상 없으니 삽입
            if(stack.isEmpty()) {
                stack.add(i);
                continue;
            }

            int past = stack.peek();
            int pastCount = counts[arr[past]];
            int nowCount = counts[arr[i]];
            //이전보다 많음
            while(nowCount > pastCount) {
                past = stack.pop();
                answer[past] = arr[i];
                if(stack.isEmpty()) {
                    break;
                }
                pastCount = counts[arr[stack.peek()]];
            }

            //이전보다 적음
            stack.add(i);
        }

        while(!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for(int val : answer) {
            sb.append(val).append(" ");
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
Ai가 수열에서 등장한 횟수를 F(Ai)라고 했을때, Ai의 오등큰수는 오른쪽에 있으면서 F(Ai)보다 큰수 중에 가장 왼쪽에 있는수. 없으면 오등큰수는 -1
NGF(I) = I번째 수의 오등큰수
수열의 크기 < 백만
1. 나보다 오른쪽
2. 나보다 수열에서 많은 수
---
스택 사용해서 앞녀석보다 크면 pop하고 해당 인덱스에 현재수가 답
 */