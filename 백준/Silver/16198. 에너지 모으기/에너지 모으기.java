import java.util.*;
import java.io.*;
class Solution {
    ArrayList<Integer> list;
    int max = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        dfs(N, 0);

        System.out.println(max);
    }

    public void dfs(int size, int sum) {
        if(size==2) {
            max = Math.max(max, sum);
            return;
        }

        for(int i=1;i<size-1;i++) {
            int tmpS = list.get(i - 1) * list.get(i + 1);
            int tmp = list.remove(i);
            dfs(size - 1, sum + tmpS);
            list.add(i, tmp);
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Solution s = new Solution();
        s.solution();
    }
}
/*

 */